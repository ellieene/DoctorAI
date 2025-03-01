package com.example.doctorai.service;

import com.example.doctorai.exception.CreateNewsException;
import com.example.doctorai.feignclient.GigaChatClient;
import com.example.doctorai.model.Chat;
import com.example.doctorai.model.Message;
import com.example.doctorai.model.entity.News;
import com.example.doctorai.model.enums.Journalist;
import com.example.doctorai.model.enums.Role;
import com.example.doctorai.repository.NewsRepository;
import lombok.AllArgsConstructor;
import org.json.JSONObject;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class NewsService {

    private final NewsRepository newsRepository;
    private final GigaChatClient gigaChatClient;
    private final LetterService letterService;

    /**
     * Вывод всех новостей
     * @return List {@link News}
     */
    @Transactional
    public List<News> getNews(){
        return newsRepository.findAll();
    }


    /**
     * Генерация новостей в определенное время
     */
    @Scheduled(cron = "0 33 15 * * ?")
    @Transactional
    public void generateNews() {
        Chat chat = new Chat();
        chat.getMessages()
                .add(createMessage(Journalist.NEWS.getMessage(), Role.SYSTEM.getRole()));
        chat.getMessages()
                .add(createMessage(Journalist.GENERATED.getMessage(), Role.USER.getRole()));
        try {
            Message message = gigaChatClient.generateNews(chat, "cc69f3cf-241a-448f-a917-dd8de9c635b9");

            String a = cleanJson(message.getContent());


            JSONObject jsonObject = new JSONObject(a);

            News news = News
                    .builder()
                    .date(LocalDate.now())
                    .title(jsonObject.getString("title"))
                    .content(jsonObject.getString("content"))
                    .country(jsonObject.getString("country"))
                    .build();
            newsRepository.save(news);

            letterService.letter(news);

        } catch (Exception e) {
            throw new CreateNewsException(e.getMessage());
        }
    }

    /**
     * Удаление не нужных символов с сообщения
     * @param input сообщение из GigaChat
     * @return json
     */
    private String cleanJson(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("Ошибка: JSON пустой или null");
        }

        input = input.replaceAll("^```json\\s*", "").replaceAll("\\s*```$", "");

        int startIndex = input.indexOf("{");
        if (startIndex == -1) {
            throw new IllegalArgumentException("Ошибка: JSON не содержит '{'");
        }

        return input.substring(startIndex).trim();
    }

    /**
     * Настройка чата с GigaChat
     * @param systemMessage сообщение
     * @param role роль
     * @return {@link Message}
     */
    private Message createMessage(String systemMessage, String role) {
        Message message = new Message();
        message.setRole(role);
        message.setContent(systemMessage);
        return message;
    }
}
