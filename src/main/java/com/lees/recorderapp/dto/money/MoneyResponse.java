package com.lees.recorderapp.dto.money;

import lombok.Getter;

@Getter
public class MoneyResponse {
    private String name;
    private Integer moneyVal;

    public MoneyResponse(String name, Integer moneyVal) {
        this.name = name;
        this.moneyVal = moneyVal;
    }

    protected MoneyResponse(){}
}
