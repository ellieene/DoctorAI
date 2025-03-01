package com.example.doctorai.model.dto;

import com.example.doctorai.model.entity.News;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class NewsLetterDTO {

    private List<User> users;
    private News news;

}
