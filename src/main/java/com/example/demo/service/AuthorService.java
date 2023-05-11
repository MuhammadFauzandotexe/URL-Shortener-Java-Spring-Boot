package com.example.demo.service;

import com.example.demo.dto.AuthorDTO;
import com.example.demo.dto.ConfigDTO;
import com.example.demo.model.Author;
import com.example.demo.repository.AuthorRepository;
import com.example.demo.utility.JsonParser;
import com.example.demo.utility.PayLoadEncoder;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
@Slf4j
@AllArgsConstructor
@Service
public class AuthorService {
    private final EmailService emailService;
    private final AuthorRepository authorRepository;
    private final ConfigDTO configDTO;
    private final JsonParser jsonParser;
    private final EntityManager entityManager;
    private final JsonObject jsonObject;
    private final PayLoadEncoder payLoadEncoder;
    private final Gson gson;
    public List<Author>  getAllDataAuthor(){
        return authorRepository.findAll();
    }
    public Optional<Author> getById(String id){
        return Optional.ofNullable(authorRepository.findById(Long.valueOf(id)).orElseThrow(EntityNotFoundException::new));
    }
     public Author addNewAuthor(AuthorDTO dto) throws NoSuchAlgorithmException, IOException {
        String uniqueKey = dto.getUniqueKey();
        String payLoad = jsonParser.encodeJson(uniqueKey, dto.getUsername(), dto.getEmail());
        String link = configDTO.domain+"author/"+payLoad;
        Author author = new Author();
        author.setPassword(dto.getPassword());
        author.setVerificationStatus("unverified");
        author.setUniqueKey(uniqueKey);
        author.setCreatedAt(LocalDateTime.now());
        author.setUpdatedAt(LocalDateTime.now());
        Context context = new Context();
        context.setVariable("username",dto.getUsername());
        context.setVariable("payload",link);
        context.setVariable("link",link);
        emailService.sendEmail(dto.getEmail(),"Verifikasi Akun dAnda-Dedicated Code","email",context);
        return authorRepository.save(author);
    }
    @Transactional
    @Modifying
    public int updateByName (String payload){
        JsonParser jsonParser = new JsonParser(jsonObject,payLoadEncoder,gson);
        JsonObject jsonObject = jsonParser.decodeJson(payload);
        Query query = entityManager.createNativeQuery("UPDATE authors SET  username = :username ,email = :email, verification_status='verified' WHERE unique_key = :uniqueKey");
        query.setParameter("username",jsonObject.get("username").getAsString());
        query.setParameter("email",jsonObject.get("email").getAsString());
        query.setParameter("uniqueKey",jsonObject.get("uniqueKey").getAsString());
        log.info(String.valueOf(jsonObject.get("username").getAsString()+" has been verified"));
        return query.executeUpdate();
    }
    public void deleteAuthor(Long authorId){
        authorRepository.deleteById(authorId);
    }
}
