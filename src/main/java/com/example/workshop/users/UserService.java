package com.example.workshop.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public UserResponse getById(int id) {
        Optional<MyUser> result = userRepository.findById(id);
        if (result.isPresent()) {
            Header header = new Header(200, "ok");
            Body body = new Body(id);
            body.setFirstname(result.get().getFirstName());
            body.setLastname(result.get().getLastName());
            UserResponse response = new UserResponse();
            response.setHeader(header);
            response.setBody(body);
            return response;
        }
        throw new UserNotFoundException("User id = " + id + " not found.", id);
    }

    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

}
