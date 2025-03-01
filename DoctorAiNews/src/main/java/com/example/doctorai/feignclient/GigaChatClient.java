package com.example.doctorai.feignclient;
import com.example.doctorai.model.Chat;
import com.example.doctorai.model.Message;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient(
        name = "GigaChatService",
        url = "${url-gigachat-service}")
public interface GigaChatClient {

    @PostMapping
    Message generateNews(@RequestBody Chat chat, @RequestParam String UUID);
}
