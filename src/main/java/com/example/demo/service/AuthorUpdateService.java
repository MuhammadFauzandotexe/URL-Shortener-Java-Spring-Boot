package com.example.demo.service;

import com.example.demo.utility.JsonParser;
import com.example.demo.utility.PayLoadEncoder;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;
@Slf4j
@AllArgsConstructor
@Service
public class AuthorUpdateService  {
    private final EntityManager entityManager;
    private final JsonObject jsonObject;
    private final PayLoadEncoder payLoadEncoder;
    private final Gson gson;
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
}
