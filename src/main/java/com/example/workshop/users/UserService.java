package com.example.workshop.users;

import org.springframework.stereotype.Service;

@Service
public class UserService {
    public UserResponse getById(int id) {
        if (id <= 10) {
            Header header = new Header(200, "ok");
            Body body = new Body(id);
            UserResponse response = new UserResponse();
            response.setHeader(header);
            response.setBody(body);
            return response;
        }
        throw new UserNotFoundException("User id = " + id + " not found.", id);
    }
}
