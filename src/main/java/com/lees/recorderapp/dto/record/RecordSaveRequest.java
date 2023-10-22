package com.lees.recorderapp.dto.record;

import com.lees.recorderapp.dto.record.week.Week;
import lombok.Getter;

@Getter
public class RecordSaveRequest {
    private Integer userId;
    private String keyDate;
    private Week weekList;
}
