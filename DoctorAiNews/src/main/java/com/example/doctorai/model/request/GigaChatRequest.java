package com.example.doctorai.model.request;


import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Setter
@Getter
public class GigaChatRequest {

    private List<Message> messages;

    private String model;

    private boolean stream;

    private int update_interval;

    public GigaChatRequest() {
        this.model = "GigaChat";
        this.update_interval = 0;
        this.stream = false;
    }

    @Getter
    @Setter
    public static class Message {
        private String role;
        private String content;

        public Message(){
            this.role = "system";
            this.content = "Привет, расскажи мне новость за вчерашний день, может есть какое нибудь открытие в медицине";
        }
    }
}
