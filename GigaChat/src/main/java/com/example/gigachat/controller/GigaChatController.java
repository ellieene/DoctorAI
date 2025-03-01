package com.example.gigachat.controller;

import com.example.gigachat.model.Chat;
import com.example.gigachat.model.Message;
import com.example.gigachat.service.GigaChatService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/answer-in-gigachat")
public class GigaChatController {

    private final GigaChatService gigaChatService;

    @PostMapping
    public ResponseEntity<Message> requestMessage(@RequestBody Chat chat, @RequestParam String UUID) {
        return ResponseEntity.ok(gigaChatService.requestMessageService(chat, UUID));
    }
}
