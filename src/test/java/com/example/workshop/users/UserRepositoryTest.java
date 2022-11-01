package com.example.workshop.users;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class UserRepositoryTest {
    @Autowired
    private UserRepository repository;

    @Test
    void success_get_data_from_db() {
        // Arrange
        MyUser user = new MyUser();
        user.setId(1);
        user.setFirstName("Demo");
        repository.save(user);
        // Act
        Optional<MyUser> result = repository.findById(1);
        // Assert
        assertTrue(result.isPresent());
        assertEquals(1, result.get().getId());
        assertEquals("Demo", result.get().getFirstName());
    }

    @Test
    void fail_user_not_found_get_data_from_db() {
        // Act
        Optional<MyUser> result = repository.findById(1);
        // Assert
        assertFalse(result.isPresent());
    }
}