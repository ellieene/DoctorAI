package com.example.doctorai.feignclient;

import com.example.doctorai.model.dto.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(
        name = "LetterInUser",
        url = "${url-chatai-service}"
)
public interface GetUser {

    @GetMapping
    List<User> getUsers();
}
