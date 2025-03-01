package com.example.doctorai.producer;

import com.example.doctorai.model.dto.NewsLetterDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class KafkaProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final ObjectMapper objectMapper;

    /**
     * Отправка для новостей по Kafka
     *
     * @param newsLetterDTO {@link NewsLetterDTO}
     */
    public void sendUserToLetter(NewsLetterDTO newsLetterDTO) throws JsonProcessingException {
        String message = objectMapper.writeValueAsString(newsLetterDTO);
        kafkaTemplate.send("letter", message);
    }
}
