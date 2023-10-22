package com.lees.recorderapp.domain;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @Column(nullable = false)
    String name;
    @Column(nullable = false)
    String password;

    @Column
    Integer friendId;
    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    protected User(){

    }
}
