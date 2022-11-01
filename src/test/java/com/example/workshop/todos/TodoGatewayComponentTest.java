package com.example.workshop.todos;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWireMock(port = 9999)
class TodoGatewayComponentTest {
    @Autowired
    private TodoGateway todoGateway;

    @Test
    public void getById() {
        // Act
        Optional<TodoResponse> result = todoGateway.getById(1);
        // Assert
        assertTrue(result.isPresent());
        assertEquals(1, result.get().getId());
        assertEquals("delectus aut autem", result.get().getTitle());
    }
}