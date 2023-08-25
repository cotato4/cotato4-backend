package com.example.cotato4.service;

import com.example.cotato4.domain.Umbrella;
import com.example.cotato4.domain.User;
import com.example.cotato4.dto.UmbrellaRequestDto;
import com.example.cotato4.repository.UmbrellaRepository;
import com.example.cotato4.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UmbrellaService {

    private final UserRepository userRepository;
    private final UmbrellaRepository umbrellaRepository;

    public ResponseEntity<?> createPost(Long userId, UmbrellaRequestDto umbrellaRequestDto) {
        User user = userRepository.findById(userId).get();

        Umbrella umbrella = Umbrella.builder()
                .type(umbrellaRequestDto.getType())
                .price(umbrellaRequestDto.getPrice())
                .subway(umbrellaRequestDto.getSubway())
                .sell(false)
                .title(umbrellaRequestDto.getTitle())
                .content(umbrellaRequestDto.getContent())
                .user(user)
                .build();

        return ResponseEntity.ok(umbrellaRepository.save(umbrella));
    }
}
