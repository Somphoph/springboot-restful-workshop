package com.example.workshop.users;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceUnitTest {
    @Test
    void getById() {
        UserService userService = new UserService();
        UserResponse response = userService.getById(1);
        assertEquals(1, response.getBody().getId());
        assertEquals(200, response.getHeader().getCode());
    }

    @Test
    void getByIdWithException() {
        UserService userService = new UserService();
        try {
            userService.getById(100);
            fail();
        } catch (UserNotFoundException e) {
            assertEquals("User id = 100 not found.", e.getMessage());
        }
    }

    @Test
    void getByIdWithException_junit5() {
        UserService userService = new UserService();
        Exception e = assertThrows(UserNotFoundException.class,()-> userService.getById(100));
        assertEquals("User id = 100 not found.", e.getMessage());
    }
}
