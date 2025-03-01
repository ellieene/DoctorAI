package com.example.gigachat.model.request;

import com.example.gigachat.model.Message;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

//@JsonIgnoreProperties(ignoreUnknown = true)
@Setter
@Getter
public class AnswerGigaChatMessageRequest {
    private List<ChoiceRequest> choices;

//    @JsonIgnoreProperties(ignoreUnknown = true)
    @Setter
    @Getter
    public static class ChoiceRequest {
        private Message message;

    }
}
