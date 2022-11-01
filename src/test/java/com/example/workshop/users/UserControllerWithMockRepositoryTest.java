package com.example.workshop.users;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class UserControllerWithMockRepositoryTest {
    @Autowired
    private TestRestTemplate template;
    @MockBean
    private UserRepository userRepository;

    @Test
    @DisplayName("การทดสอบดึงข้อมูลผู้ใช้งาน")
    void success_case() {
        // Arrange
        MyUser user = new MyUser();
        user.setId(1);
        user.setFirstName("Demo");
        when(userRepository.findById(1)).thenReturn(Optional.of(user));
        // Act
        UserResponse response = template.getForObject("/users/1", UserResponse.class);
        // Assert
        assertEquals(200, response.getHeader().getCode());
        assertEquals(1, response.getBody().getId());
    }

}