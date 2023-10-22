package com.lees.recorderapp.dto.record;

import lombok.Getter;

@Getter
public class RecordGetRequest {
    private Integer userId;
    private String keyDate;

    public RecordGetRequest(Integer userId, String keyDate) {
        this.userId = userId;
        this.keyDate = keyDate;
    }
}
