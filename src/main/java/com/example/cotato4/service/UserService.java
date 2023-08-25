package com.example.cotato4.service;

import com.example.cotato4.domain.User;
import com.example.cotato4.dto.UserLoginRequestDto;
import com.example.cotato4.dto.UserRequestDto;
import com.example.cotato4.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public Long join(UserRequestDto userRequestDto) {
        User user = userRequestDto.toEntity();
        userRepository.save(user);
        return user.getId();
    }

    public ResponseEntity<?> login(UserLoginRequestDto userLoginRequestDto) {
        User user = userRepository.findByEmail(userLoginRequestDto.getEmail());
        if (!Objects.equals(user.getPassword(), userLoginRequestDto.getPassword())) {
            return ResponseEntity.status(401).build();
        }
        return ResponseEntity.ok(user.getId());
    }
}
