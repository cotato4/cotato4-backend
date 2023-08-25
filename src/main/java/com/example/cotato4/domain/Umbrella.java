package com.example.cotato4.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Umbrella")
public class Umbrella {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "umbrella_id")
    private Long id;

    @Column
    private String type;

    @Column
    private int price;

    @Column
    private String subway;

    @Column
    private Boolean sell;

    @Column
    private String title;

    @Column
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
}
