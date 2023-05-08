package com.example.demo.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "authors")
public class Author {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "author_generator")
    @SequenceGenerator(name = "author_generator",sequenceName = "author_id_seq")
    private Long id;
    private String username;
    private String email;
    private String password;
    @Column(name = "unique_key")
    private String uniqueKey;
    @Column(name = "verification_status")
    private String verificationStatus;
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "author_id")
    private List<Url> urls = new ArrayList<>();
    public void addChild(Url url) {
        urls.add(url);
    }
}
