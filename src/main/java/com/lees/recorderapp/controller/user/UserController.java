package com.lees.recorderapp.controller.user;

import com.lees.recorderapp.domain.User;
import com.lees.recorderapp.dto.user.UserInfo;
import com.lees.recorderapp.dto.user.UserResponse;
import com.lees.recorderapp.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/login")
    public UserResponse userLogin(@RequestBody UserInfo userInfo){
        return userService.userLogin(userInfo);
    }

//    @PostMapping("/userInfo")
//    public UserResponse userInfo(@RequestBody UserInfo userInfo){
//
//        return userService.userLogin(userInfo);
//    }

    @PostMapping("/signIn")
    public void userSignIn(@RequestBody UserInfo userInfo){
        userService.userSignIn(userInfo);
    }
}
