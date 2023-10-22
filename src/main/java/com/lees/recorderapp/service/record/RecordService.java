package com.lees.recorderapp.service.record;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lees.recorderapp.domain.Record;
import com.lees.recorderapp.domain.User;
import com.lees.recorderapp.dto.record.RecordGetRequest;
import com.lees.recorderapp.dto.record.RecordSaveRequest;
import com.lees.recorderapp.dto.record.week.Week;
import com.lees.recorderapp.service.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RecordService {

    private final UserRepository userRepository;
    private final RecordRepository recordRepository;
    private ObjectMapper objectMapper = new ObjectMapper();
    // 이름과 keyDate > weekId가 있다면 수정 > 아니면 새로 생성
    @Transactional
    public void saveRecord(RecordSaveRequest request) throws JsonProcessingException {
        User user = userRepository.findById(request.getUserId())
                .orElseThrow(IllegalArgumentException::new);

        System.out.println("request = " + request.getKeyDate());
        System.out.println("user.getId() = " + user.getId());
        Optional<Record> record = recordRepository.findByUserIdAndKeyDate(user.getId(), request.getKeyDate());
        System.out.println("record = " + record);

        if(record.isPresent()){
            record.get().updateTargetValue(request.getWeekList());
            System.out.println("record = " + record.get().toString());

        }else{
            recordRepository.save(new Record(user.getId(), request.getKeyDate(), request.getWeekList()));
        }
    }

    @Transactional
    public Week getTargetRecord(RecordGetRequest request) throws JsonProcessingException {
        Optional<Record> record = recordRepository.findByUserIdAndKeyDate(request.getUserId(), request.getKeyDate());
        if (record.isPresent() && (record.get().getTargetValue() != null)){
            try {
                return objectMapper.readValue(record.get().getTargetValue(), Week.class);
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }

        }

        return new Week(0,0,0,0,0,0,0);
    }@Transactional
    public Week getActualRecord(RecordGetRequest request) throws JsonProcessingException {
        Optional<Record> record = recordRepository.findByUserIdAndKeyDate(request.getUserId(), request.getKeyDate());
        if (record.isPresent() && (record.get().getActualValue() != null)){
            try {
                return objectMapper.readValue(record.get().getActualValue(), Week.class);
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }

        }

        return new Week(0,0,0,0,0,0,0);
    }


}
