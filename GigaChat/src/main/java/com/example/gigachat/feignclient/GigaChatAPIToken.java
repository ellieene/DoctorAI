package com.example.gigachat.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(
        name = "GigaChatAPI",
        url = "${url-token}"
)
public interface GigaChatAPIToken {

    @PostMapping(value = "/oauth", consumes = "application/x-www-form-urlencoded")
    String getToken(
            @RequestHeader("RqUID") String rqUID,
            @RequestHeader("Authorization") String authorization,
            @RequestBody() String scope
    );
}
