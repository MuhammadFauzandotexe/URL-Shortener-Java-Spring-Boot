package com.example.demo.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
@Data
@Entity
@Table(name = "authors")
public class Author {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
    private String uuid;
    private String name;
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
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "author_id")
    private Set<URL> links = new HashSet<>();
}
