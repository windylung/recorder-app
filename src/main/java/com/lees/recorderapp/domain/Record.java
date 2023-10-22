package com.lees.recorderapp.domain;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lees.recorderapp.dto.record.week.Week;
import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter

public class Record {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @Column(nullable = false)
    Integer userId;
    @Column
    String keyDate;
    @Column(columnDefinition = "JSON")
    private String targetValue; // Week 객체를 JSON으로 직렬화한 문자열
    @Column(columnDefinition = "JSON")
    private String actualValue;





    public Record(Integer userId, String keyDate, Week targetValue) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        this.userId = userId;
        this.keyDate = keyDate;
        this.targetValue = objectMapper.writeValueAsString(targetValue);
    }

    protected Record(){}

    public void updateTargetValue(Week week) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        this.targetValue =  objectMapper.writeValueAsString(week);
    }
}
