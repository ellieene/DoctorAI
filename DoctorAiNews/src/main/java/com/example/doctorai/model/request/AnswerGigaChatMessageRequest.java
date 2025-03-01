package com.example.doctorai.model.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@Setter
@Getter
public class AnswerGigaChatMessageRequest {
    private List<ChoiceRequest> choices;

    @JsonIgnoreProperties(ignoreUnknown = true)
    @Setter
    @Getter
    public static class ChoiceRequest {
        private GigaChatRequest.Message message;

    }
}
