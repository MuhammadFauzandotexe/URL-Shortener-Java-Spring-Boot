package com.example.demo.service;

import com.example.demo.dto.UrlDTO;
import com.example.demo.model.Author;
import com.example.demo.model.Url;
import com.example.demo.repository.AuthorRepository;
import com.example.demo.repository.URLRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import javax.persistence.EntityNotFoundException;

@AllArgsConstructor
@Service
public class UrlService {
    private final URLRepository urlRepository;
    private final AuthorRepository authorRepository;
    public String dto(Long id, UrlDTO dto){
        Author author = authorRepository.findById(1L).orElseThrow(EntityNotFoundException::new);
        Url url = new Url();
        url.setNewURL("yyyyyyy");
        author.addChild(url);
        authorRepository.save(author);
        return "done";
    }
}
