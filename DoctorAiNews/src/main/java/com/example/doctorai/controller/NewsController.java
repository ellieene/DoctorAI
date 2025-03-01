package com.example.doctorai.controller;

import com.example.doctorai.model.dto.User;
import com.example.doctorai.model.entity.News;
import com.example.doctorai.service.LetterService;
import com.example.doctorai.service.NewsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/news")
public class NewsController {

    private final NewsService newsService;
    private final LetterService letterService;

    @GetMapping
    public ResponseEntity<List<News>> getNews() {
        return ResponseEntity.ok(newsService.getNews());
    }

    @PostMapping
    public void addNews() {
        newsService.generateNews();
    }

}
