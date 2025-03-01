package com.example.gigachat.service;

import com.example.gigachat.exception.GigaChatException;
import com.example.gigachat.feignclient.GigaChatAPIToken;
import com.example.gigachat.feignclient.GigaChatClient;
import com.example.gigachat.model.Chat;
import com.example.gigachat.model.Message;
import com.example.gigachat.model.request.AnswerGigaChatMessageRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class GigaChatService {

//    private final String secretToken = "OWRhOTU4ZTctODcyYi00NDA1LWE2NGEtYTM1M2EzMGFmZTIwOjkyNTZiMjJhLWM0ZDgtNGY5Ny1iMGMxLTA5NjJkNjJjNzExZg==";
    private final GigaChatAPIToken gigaChatAPIToken;
    private final GigaChatClient gigaChatClient;

    @Value("${secret-token}")
    private String secretToken;

    @Getter
    @Setter
    private String accessToken;




    /**
     * Обновление токена какждые 25 минут
     */
    @Scheduled(cron = "0 */1 * * * *")
    private void updateToken() {
        try {
            String rqUID = UUID.randomUUID().toString();
            String authorizationHeader = "Bearer " + secretToken;
            String scope = "scope=GIGACHAT_API_PERS";

            JSONObject jsonObject = new JSONObject(gigaChatAPIToken.getToken(rqUID, authorizationHeader, scope));

//            accessToken = jsonObject.getString("access_token");
            setAccessToken(jsonObject.getString("access_token"));
            System.out.println(LocalDateTime.now());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * Генерация ответа врача
     *
     * @param rawBody
     * @return
     */
    public Message requestMessageService(Chat rawBody, String UUID) {
        try {
            String authorizationHeader = "Bearer " + accessToken;
            AnswerGigaChatMessageRequest answerGigaChatMessageRequest = gigaChatClient.requestMessage(authorizationHeader, rawBody, UUID);
            return answerGigaChatMessageRequest.getChoices().get(0).getMessage();
        } catch (Exception e) {
            throw new GigaChatException("GigaChat устал");
        }

    }
//

}

