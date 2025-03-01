package com.example.gigachat.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Chat {

    private String model;

    private List<Message> messages;

    private boolean stream;

    private int update_interval;

}

