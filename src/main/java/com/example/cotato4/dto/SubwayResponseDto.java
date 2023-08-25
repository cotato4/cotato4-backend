package com.example.cotato4.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

import static com.example.cotato4.service.UmbrellaService.subwayColor;

@Getter
public class SubwayResponseDto {
    private final String name;
    private final List<SubwayIcon> subwayIconList;

    @Getter
    @Builder
    @RequiredArgsConstructor
    private static class SubwayIcon {
        private final int line;
        private final String colorCode;
    }

    @Builder
    public SubwayResponseDto(String name, List<Integer> lineList) {
        this.name = name;
        this.subwayIconList = new ArrayList<>();
        for (int line : lineList) {
            subwayIconList.add(SubwayIcon.builder()
                            .line(line)
                            .colorCode(subwayColor.get(line))
                    .build());
        }
    }
}