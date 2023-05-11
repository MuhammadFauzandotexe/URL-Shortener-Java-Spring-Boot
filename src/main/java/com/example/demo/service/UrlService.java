package com.example.demo.service;

import com.example.demo.dto.UrlDTO;
import com.example.demo.model.Author;
import com.example.demo.model.Url;
import com.example.demo.repository.AuthorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Query;
import java.time.LocalDateTime;
@AllArgsConstructor
@Service
public class UrlService {
    private final AuthorRepository authorRepository;
    private EntityManager entityManager;
    public Author addNewURL(Long id, UrlDTO dto){
        Author author = authorRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        Url url = new Url();
        url.setNewURL(dto.getNewURL());
        url.setNativeURL(dto.getNativeURL());
        url.setCreatedAt(LocalDateTime.now());
        url.setUpdatedAt(LocalDateTime.now());
        author.addChild(url);
        return authorRepository.save(author);
    }
    public String getUrl(String newUrl){
        String queryString = "SELECT u FROM Url u WHERE newURL = :newUrl";
        Query query = entityManager.createQuery(queryString,Url.class);
        query.setParameter("newUrl",newUrl);
        Url url = (Url) query.getSingleResult();
        String nativeUrl = url.getNativeURL();
        return nativeUrl;
    }
}
