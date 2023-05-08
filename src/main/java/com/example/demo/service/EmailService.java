package com.example.demo.service;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
@Slf4j
@Service
@AllArgsConstructor
public class EmailService {
    private final JavaMailSender mailSender;
    private final TemplateEngine templateEngine;
    public String sendEmail(String to, String subject, String templateName, Context context) throws IOException {
        try {
            EmailOrder(to, subject, templateName,context);
            log.info("emial telah dikirimkan ke "+to);
            
            return "ok";
        } catch (MessagingException e) {
            return "address not found" + e.getMessage();
        }
    }
    public void EmailOrder(String to, String subject, String templateName, Context context) throws MessagingException, IOException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED, StandardCharsets.UTF_8.name());
        String html = getHtmlContent(templateName, context);
        helper.setTo(to);
        helper.setText(html, true);
        helper.setSubject(subject);
        mailSender.send(message);
    }
    private String getHtmlContent(String templateName, Context context) throws IOException {
        return templateEngine.process(templateName, context);
    }
}
