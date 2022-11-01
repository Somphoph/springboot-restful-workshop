package com.example.workshop.users;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceUnitTest {
    @Mock
    private UserRepository userRepository;
    @Test
    void getById() {
        //Arrange
        MyUser user = new MyUser();
        user.setId(1);
        user.setFirstName("Demo");
        when(userRepository.findById(1)).thenReturn(Optional.of(user));

        UserService userService = new UserService();
        userService.setUserRepository(userRepository);
        //Act
        UserResponse response = userService.getById(1);
        // Assert
        assertEquals(1, response.getBody().getId());
        assertEquals(200, response.getHeader().getCode());
    }

}
