package com.lees.recorderapp.service.user;

import com.lees.recorderapp.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    public Optional<User> findByNameAndPassword(String Name, String password);
}
