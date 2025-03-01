package com.example.doctorai.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Getter
@Setter
@Builder
public class News {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @JsonIgnore
    private UUID id;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "content", columnDefinition = "text")
    private String content;

    @Column(name = "title")
    private String title;

    @Column(name = "country")
    private String country;

}
