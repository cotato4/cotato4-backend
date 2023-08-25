package com.example.cotato4.controller;

import com.example.cotato4.dto.UserLoginRequestDto;
import com.example.cotato4.dto.UserRequestDto;
import com.example.cotato4.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "UserController")
@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Operation(summary = "회원가입")
    @PostMapping("/join")
    public Long join(@RequestBody UserRequestDto userRequestDto) {
        return userService.join(userRequestDto);
    }

    @Operation(summary = "로그인")
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserLoginRequestDto userLoginRequestDto) {
        return userService.login(userLoginRequestDto);
    }
}
