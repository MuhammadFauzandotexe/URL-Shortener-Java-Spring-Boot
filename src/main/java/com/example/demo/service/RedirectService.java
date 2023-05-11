package com.example.demo.service;

import com.example.demo.model.Url;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import javax.persistence.Query;
@Service
@Repository
@AllArgsConstructor
public class RedirectService {
    private EntityManager entityManager;
    public String getUrl(String newUrl){
        String queryString = "SELECT u FROM Url u WHERE newURL = :newUrl";
        Query query = entityManager.createQuery(queryString,Url.class);
        query.setParameter("newUrl",newUrl);
        Url url = (Url) query.getSingleResult();
        String nativeUrl = url.getNativeURL();
        return nativeUrl;
    }
}
