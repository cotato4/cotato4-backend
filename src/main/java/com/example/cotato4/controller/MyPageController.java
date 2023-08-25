package com.example.cotato4.controller;

import com.example.cotato4.service.MyPageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/mypage")
@RestController
public class MyPageController {

    private final MyPageService myPageService;

    @PatchMapping("")
    public ResponseEntity<?>
}
