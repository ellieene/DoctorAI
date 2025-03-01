package com.example.gigachat.feignclient;

import com.example.gigachat.component.GigaChatFallback;
import com.example.gigachat.model.Chat;
import com.example.gigachat.model.request.AnswerGigaChatMessageRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(
        name = "Chat",
        url = "${url-chat}",
        fallback = GigaChatFallback.class
)
public interface GigaChatClient {

    @PostMapping(value = "/completions", consumes = "application/json")
    AnswerGigaChatMessageRequest requestMessage(
            @RequestHeader ("Authorization") String authorization,
            @RequestBody Chat chat,
            @RequestHeader ("X-Client-ID") String UUID
    );
}
