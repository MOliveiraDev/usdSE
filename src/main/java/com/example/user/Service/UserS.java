package com.example.user.Service;

import com.example.user.Repository.UserR;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserS {

    @Autowired
    private UserR userR;

    public User UserRegister(User user) {
        return userR.save(user);
    }
}
