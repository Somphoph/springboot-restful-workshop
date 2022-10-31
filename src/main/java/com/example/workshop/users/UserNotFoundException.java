package com.example.workshop.users;

public class UserNotFoundException extends RuntimeException {
    private final int id;

    public UserNotFoundException(String message, int id) {
        super(message);
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
