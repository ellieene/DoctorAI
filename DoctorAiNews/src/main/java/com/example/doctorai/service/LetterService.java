package com.example.doctorai.service;

import com.example.doctorai.feignclient.GetUser;
import com.example.doctorai.model.dto.NewsLetterDTO;
import com.example.doctorai.model.entity.News;
import com.example.doctorai.producer.KafkaProducer;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LetterService {

    private final GetUser letterUser;
    private final KafkaProducer kafkaProducer;


    @SneakyThrows
    public void letter(News news) {
        NewsLetterDTO newsLetterDTO = NewsLetterDTO
                .builder()
                .news(news)
                .users(letterUser.getUsers())
                .build();

        kafkaProducer.sendUserToLetter(newsLetterDTO);
    }


}
