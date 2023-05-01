package com.example.demo.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.repository.Modifying;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;
@Slf4j
@AllArgsConstructor
public class AuthorUpdateService  {
    private final EntityManager entityManager;
    @Transactional
    @Modifying
    public void updateByname (String username,String email, String uniqueKey){
        Query query = entityManager.createNativeQuery("UPDATE authors SET  username = :username ,email = :email, verification_status='verified' WHERE unique_key = :uniqueKey");
        query.setParameter("name",username);
        query.setParameter("email",email);
        query.setParameter("uniqueKey",uniqueKey);
        int data = query.executeUpdate();
        log.info(String.valueOf(data));
    }
}
