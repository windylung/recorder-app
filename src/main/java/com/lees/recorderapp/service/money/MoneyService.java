package com.lees.recorderapp.service.money;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.lees.recorderapp.domain.User;
import com.lees.recorderapp.dto.money.MoneyRequest;
import com.lees.recorderapp.dto.money.MoneyResponse;
import com.lees.recorderapp.dto.record.RecordGetRequest;
import com.lees.recorderapp.dto.record.week.Week;
import com.lees.recorderapp.service.record.RecordService;
import com.lees.recorderapp.service.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MoneyService {

    private Integer moneyPerHour = 12000;
    private final RecordService recordService;
    private final UserRepository userRepository;


    @Transactional
    public MoneyResponse getMoneyVal(MoneyRequest request){
        // 사용자의 userId > getTargetRecord, getActualRecord
        // 하나씩 보면서 target - actual > 0 이라면 diff에 저장
        // diff * moeneyPerHour return
        // getTargetRecord = 0 인 경우, -1 리턴 > FE에서 알림창 띄우기
        try {
            Integer moneyVal;
            String name;
            name = userRepository.findById(request.getUserId()).orElseThrow(IllegalArgumentException::new).getName();
            Week targetRecord = recordService.getTargetRecord(new RecordGetRequest(request.getUserId(), request.getKeyDate()));
            Week actualRecord = recordService.getActualRecord(new RecordGetRequest(request.getUserId(), request.getKeyDate()));
            if (targetRecord.isAllZero()) {moneyVal = -1;}
            else {moneyVal = targetRecord.calDifference(actualRecord) * moneyPerHour; }
            return new MoneyResponse(name, moneyVal);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @Transactional
    public MoneyResponse getFriendMoneyVal(MoneyRequest request){
        Integer friendId = userRepository.findById(request.getUserId())
                .orElseThrow(IllegalArgumentException::new)
                .getFriendId();
        return getMoneyVal(new MoneyRequest(friendId, request.getKeyDate()));
    }



}
