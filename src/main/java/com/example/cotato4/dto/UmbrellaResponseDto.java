package com.example.cotato4.dto;

import com.example.cotato4.domain.Umbrella;
import com.example.cotato4.domain.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UmbrellaResponseDto {
    private Long userId;
    private String nickname;
    private String title;
    private int price;
    private String content;

    public static UmbrellaResponseDto toDto(Long userId, User user, Umbrella umbrella) {
        return UmbrellaResponseDto.builder()
                .userId(userId)
                .nickname(user.getNickname())
                .title(umbrella.getTitle())
                .price(umbrella.getPrice())
                .content(umbrella.getContent())
                .build();
    }
}
