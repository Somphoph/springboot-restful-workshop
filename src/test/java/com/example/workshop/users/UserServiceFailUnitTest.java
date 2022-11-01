package com.example.workshop.users;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class UserServiceFailUnitTest {
    @Mock
    private UserRepository userRepository;
    private UserService userService;
    @BeforeEach
    public void initForException(){
        userService = new UserService();
        userService.setUserRepository(userRepository);
    }
    @Test
    void getByIdWithException() {
        try {
            userService.getById(100);
            fail();
        } catch (UserNotFoundException e) {
            assertEquals("User id = 100 not found.", e.getMessage());
        }
    }

    @Test
    void getByIdWithException_junit5() {
        Exception e = assertThrows(UserNotFoundException.class,()-> userService.getById(100));
        assertEquals("User id = 100 not found.", e.getMessage());
    }
}
