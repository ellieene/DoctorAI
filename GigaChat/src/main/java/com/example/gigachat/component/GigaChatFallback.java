package com.example.gigachat.component;

import com.example.gigachat.feignclient.GigaChatClient;
import com.example.gigachat.model.Chat;
import com.example.gigachat.model.request.AnswerGigaChatMessageRequest;
import org.springframework.stereotype.Component;

@Component
public class GigaChatFallback implements GigaChatClient {
    @Override
    public AnswerGigaChatMessageRequest requestMessage(String authorizationHeader, Chat chat, String UUID) {
        System.out.println("GigaChat API недоступен!");
        throw new RuntimeException("GigaChat API недоступен!");
    }
}
