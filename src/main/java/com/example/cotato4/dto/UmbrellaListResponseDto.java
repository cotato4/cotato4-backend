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
public class UmbrellaListResponseDto {
    private String nickname;
    private String title;
    private int price;

    public static UmbrellaListResponseDto toDto(User user, Umbrella umbrella) {
        return UmbrellaListResponseDto.builder()
                .nickname(user.getNickname())
                .title(umbrella.getTitle())
                .price(umbrella.getPrice())
                .build();
    }
}
