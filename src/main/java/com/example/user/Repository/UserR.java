package com.example.user.Repository;

import com.example.user.Model.UserM;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.OptionalInt;
import java.util.UUID;

public interface UserR  extends JpaRepository<UserM, UUID> {
    OptionalInt findByEmail(String email);

}
