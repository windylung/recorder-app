package com.lees.recorderapp.service.user;

import com.lees.recorderapp.domain.User;
import com.lees.recorderapp.dto.user.UserInfo;
import com.lees.recorderapp.dto.user.UserResponse;
import com.lees.recorderapp.service.record.RecordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final RecordRepository recordRepository;

    @Transactional
    public UserResponse userLogin(UserInfo userInfo){
//        List<Integer> myWeekList = Arrays.asList(0,0,0,0,0,0,0);
//        List<Integer> friendWeekList = Arrays.asList(0,0,0,0,0,0,0);
        User user = userRepository.findByNameAndPassword(userInfo.getName(), userInfo.getPassword())
                .orElseThrow(IllegalArgumentException::new);

        return new UserResponse(user.getId());
//        LocalDate today = LocalDate.now();
//        LocalDate thisMonday = today.with(TemporalAdjusters.previousOrSame(java.time.DayOfWeek.MONDAY));
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
//        String keyDate = formatter.format(thisMonday);
//        Optional<Record> record = recordRepository.findByUserIdAndKeyDate(user.getId(), keyDate);
//        //기존 week 데이터가 있다면
//        if(record.isPresent()){
//            Week week = weekRepository.findById(record.get().getWeekId()).orElseThrow(IllegalArgumentException::new);
//            myWeekList = week.getWeekList();
//        }
//
//        if (user.getFriendId() != null){
//            Optional<Record> friendRecord = recordRepository.findByUserIdAndKeyDate(user.getFriendId(), keyDate);
//            if (friendRecord.isPresent()){
//                Week friendWeek = weekRepository.findById(friendRecord.get().getWeekId())
//                        .orElseThrow(IllegalArgumentException::new);
//                friendWeekList = friendWeek.getWeekList();
//            }
//        }
//        return new UserResponse(myWeekList, friendWeekList);

    }

    @Transactional
    public void userSignIn(UserInfo userInfo){
        userRepository.save(new User(userInfo.getName(), userInfo.getPassword()));
    }


}
