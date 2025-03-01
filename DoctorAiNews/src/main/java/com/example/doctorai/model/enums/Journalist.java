package com.example.doctorai.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public enum Journalist {
    NEWS("Ты частный журналист, ищешь только самые актуальные новости в медицине."),
    GENERATED("Найди мне уникальную новость на " + LocalDate.now().toString()
            + ". Ты должен написать мне только JSON в строковом представлении и ничего больше(без ```), Там должен быть title, content, country.");

    private final String message;

}
