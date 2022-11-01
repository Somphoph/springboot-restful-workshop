package com.example.workshop.todos;

import com.github.tomakehurst.wiremock.client.WireMock;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;
import org.springframework.http.MediaType;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.http.HttpHeaders.CONTENT_TYPE;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWireMock(port = 9999)
class TodoGatewayComponentTest {
    @Autowired
    private TodoGateway todoGateway;

    @Test
    void getById() {
        // Arrange
        WireMock.stubFor(WireMock.get(WireMock.urlPathEqualTo("/todos/1"))
                .willReturn(WireMock.aResponse()
                        .withStatus(200)
                        .withHeader(CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                        .withBody("{\n" +
                                "  \"userId\": 1,\n" +
                                "  \"id\": 1,\n" +
                                "  \"title\": \"From Wiremock\",\n" +
                                "  \"completed\": false\n" +
                                "}")
                ));
        // Act
        Optional<TodoResponse> result = todoGateway.getById(1);
        // Assert
        assertTrue(result.isPresent());
        assertEquals(1, result.get().getId());
        assertEquals("From Wiremock", result.get().getTitle());
    }
}