package com.lees.recorderapp.dto.user;

import lombok.Getter;
import java.util.List;

@Getter
public class UserResponse {
    private Integer userId;

    public UserResponse(Integer userId) {
        this.userId = userId;
    }

    protected UserResponse(){}
}
