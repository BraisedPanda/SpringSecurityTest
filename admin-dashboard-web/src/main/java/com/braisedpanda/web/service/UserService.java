package com.braisedpanda.web.service;

import com.braisedpanda.commons.model.User;
import org.springframework.stereotype.Component;

@Component
public interface UserService {
    User getUserByUsername(String username);

    void insertUser(User user);
}
