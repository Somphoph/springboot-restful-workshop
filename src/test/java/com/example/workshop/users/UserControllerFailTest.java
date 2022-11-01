package com.example.workshop.users;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class UserControllerFailTest {
    @Autowired
    private TestRestTemplate template;
    @Test
    @DisplayName("การทดสอบไม่สามารถดึงข้อมูลผู้ใช้งาน ...")
    void fail_case_with_404() {
        UserResponse response = template.getForObject("/users/99", UserResponse.class);
        assertEquals(404, response.getHeader().getCode());
        assertEquals(99, response.getBody().getId());
    }
}