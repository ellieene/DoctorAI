package com.example.doctorai.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Chat {

    private String model;

    private List<Message> messages;

    private boolean stream;

    private int update_interval;

    public Chat() {
        this.messages = new ArrayList<>();
        this.model = "GigaChat";
        this.update_interval = 0;
        this.stream = false;
    }

}

