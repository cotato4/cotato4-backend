package com.example.cotato4.domain;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class SubwayInfo {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "subway_info_id")
    private Long id;

    private String name;

    private int line;

    private double lat;

    private double lng;

}
