package com.lees.recorderapp.controller.money;

import com.lees.recorderapp.dto.money.MoneyRequest;
import com.lees.recorderapp.dto.money.MoneyResponse;
import com.lees.recorderapp.service.money.MoneyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MoneyController {

    private final MoneyService moneyService;

    @PostMapping("/money/my")
    public MoneyResponse getMyMoneyVal (@RequestBody MoneyRequest request){
        return moneyService.getMoneyVal(request);
    }

    @PostMapping("/money/friend")
    public MoneyResponse getFriendMoneyVal (@RequestBody MoneyRequest request){
        return moneyService.getFriendMoneyVal(request);
    }
}
