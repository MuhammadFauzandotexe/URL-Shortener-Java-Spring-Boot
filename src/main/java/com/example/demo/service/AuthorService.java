package com.example.demo.service;

import com.example.demo.dto.AuthorDTO;
import com.example.demo.dto.ConfigDTO;
import com.example.demo.model.Author;
import com.example.demo.repository.AuthorRepository;
import com.example.demo.utility.PayLoadEncoder;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.List;
import java.util.Optional;
@AllArgsConstructor
@Service
public class AuthorService {
    private final EmailService emailService;
    private final AuthorRepository authorRepository;
    private final ConfigDTO configDTO;
    private final PayLoadEncoder payLoadEncoder;
    public Author saveData(AuthorDTO dto) throws NoSuchAlgorithmException, IOException {
        String uniqueKey = dto.getUniqueKey();
        String payLoad = payLoadEncoder.encode(uniqueKey,dto.getName(),dto.getEmail());
        String payLoadEncode = Base64.getEncoder().encodeToString(payLoad.getBytes());
        String link = configDTO.domain+payLoadEncode;
        Author author = new Author();
        author.setPassword(dto.getPassword());
        author.setVerificationStatus("unverified");
        author.setUniqueKey(uniqueKey);
        author.setCreatedAt(dto.getTimeNow());
        author.setUpdatedAt(dto.getTimeNow());
        Context context = new Context();
        context.setVariable("username",dto.getName());
        context.setVariable("payload",link);
        context.setVariable("link",link);
        emailService.sendEmail(dto.getEmail(),"Verifikasi Akun Anda-Dedicated Code","email",context);
        return authorRepository.save(author);
    }
    public List<Author> getAllDataAuthor(){
        return authorRepository.findAll();
    }
    public Optional<Author> getAuthorById(Long id){
        return authorRepository.findById(id);
    }
}
