package com.sparta.personal_blog.controller;

import com.sparta.personal_blog.dto.ResponseDto;
import com.sparta.personal_blog.dto.SignupRequestDto;
import com.sparta.personal_blog.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class UserController {
    private final UserService userService;
    @PostMapping("/signupapi/member/signup")
    public ResponseDto<?> registerUser(@RequestBody SignupRequestDto requestDto) {
        return userService.registerUser(requestDto);
    }

}
