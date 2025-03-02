package com.example.user.Service;

import com.example.user.Model.UserM;
import com.example.user.Repository.UserR;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.OptionalInt;
import java.util.UUID;

@Service
public class UserS {

    @Autowired
    private UserR userR;

    public UserM UserRegister(UserM user) {
        return userR.save(user);
    }

    public OptionalInt findByEmail(String email) {
        return userR.findByEmail(email);
    }

    public void UpdatePassword(UUID id, String newpassword) {
        userR.findById(id).ifPresent(user -> {
            user.setPassword(newpassword);
            userR.save(user);
        });
    }
}