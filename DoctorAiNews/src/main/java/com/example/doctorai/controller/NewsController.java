package com.example.doctorai.controller;

import com.example.doctorai.model.dto.User;
import com.example.doctorai.model.entity.News;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import com.example.doctorai.service.NewsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/news")
@Tag(name="Новости")
public class NewsController {

    private final NewsService newsService;

    @GetMapping
    @Operation(description = "Получение всех пользователей с уведомлениями")
    public ResponseEntity<List<News>> getNews() {
        return ResponseEntity.ok(newsService.getNews());
    }

}
