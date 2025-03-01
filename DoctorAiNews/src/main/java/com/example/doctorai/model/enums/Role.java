package com.example.doctorai.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Role {
    USER("user"),
    SYSTEM("system");

    private String role;
}
