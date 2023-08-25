package com.example.cotato4.dto;

import com.example.cotato4.domain.User;
import lombok.Getter;

@Getter
public class UserRequestDto {

    private String email;
    private String nickname;
    private String phoneNumber;
    private String password;

    public User toEntity() {
        return User.builder()
                .email(email)
                .nickname(nickname)
                .phoneNumber(phoneNumber)
                .password(password)
                .build();
    }
}
