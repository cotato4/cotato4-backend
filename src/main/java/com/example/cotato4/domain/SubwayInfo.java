package com.example.cotato4.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class SubwayInfo {
    private String line;
    private double lat;
    private double lng;
}
