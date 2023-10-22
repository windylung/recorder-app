package com.lees.recorderapp.controller.record;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.lees.recorderapp.dto.record.RecordGetRequest;
import com.lees.recorderapp.dto.record.RecordSaveRequest;
import com.lees.recorderapp.dto.record.week.Week;
import com.lees.recorderapp.service.record.RecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class RecordController {

    private final RecordService recordService;
    @PostMapping("/get/target")
    public Week getTargetRecord(@RequestBody RecordGetRequest request) throws JsonProcessingException {
        return recordService.getTargetRecord(request);
    }

    @PostMapping("/get/actual")
    public Week getActualRecord(@RequestBody RecordGetRequest request) throws JsonProcessingException {
        return recordService.getActualRecord(request);
    }
    @PostMapping("/save")
    public void saveRecord(@RequestBody RecordSaveRequest request) throws JsonProcessingException {
        recordService.saveRecord(request);
    }


}
