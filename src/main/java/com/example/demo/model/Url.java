package com.example.demo.model;

import lombok.Data;
import javax.persistence.*;
import java.time.LocalDateTime;
@Data
@Entity
@Table(name = "urls")
public class Url {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "url_generator")
    @SequenceGenerator(name = "url_generator",sequenceName = "url_id_seq")
    private Long id;
    @Column(name = "native_url")
    private String nativeURL;
    @Column(name = "new_url",unique = true)
    private String newURL;
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}
