package com.example.workshop.todos;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Component
public class TodoGateway {
    private RestTemplate restTemplate;
    @Value("${target.url}")
    private String targetUrl;

    public TodoGateway(RestTemplateBuilder builder) {
        restTemplate = builder.build();
    }

    public Optional<TodoResponse> getById(int id) {
        String url = String.format("%s/todos/%d", targetUrl, id);
        try {
            TodoResponse result = restTemplate.getForObject(url, TodoResponse.class);
            return Optional.of(result);
        } catch (Exception e) {
            return Optional.empty();
        }
    }
}
