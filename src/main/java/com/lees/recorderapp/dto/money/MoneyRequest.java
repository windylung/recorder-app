package com.lees.recorderapp.dto.money;

import lombok.Getter;

@Getter

public class MoneyRequest {
    Integer userId;
    String keyDate;

    public MoneyRequest(Integer userId, String keyDate) {
        this.userId = userId;
        this.keyDate = keyDate;
    }

    protected MoneyRequest(){}
}
