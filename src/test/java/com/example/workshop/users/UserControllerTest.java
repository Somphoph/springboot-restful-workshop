package com.example.workshop.users;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class UserControllerTest {
    @Autowired
    private TestRestTemplate template;
    @Autowired
    private UserRepository userRepository;

    @BeforeEach
    public void initDataForTest() {
        MyUser user = new MyUser();
        user.setId(1);
        user.setFirstName("Demo");
        userRepository.save(user);
    }

    @AfterEach
    public void clearDataForTest() {
        userRepository.deleteById(1);
    }

    @Test
    @DisplayName("การทดสอบดึงข้อมูลผู้ใช้งาน")
    void success_case() {
        // Act
        UserResponse response = template.getForObject("/users/1", UserResponse.class);
        // Assert
        assertEquals(200, response.getHeader().getCode());
        assertEquals(1, response.getBody().getId());
    }

}