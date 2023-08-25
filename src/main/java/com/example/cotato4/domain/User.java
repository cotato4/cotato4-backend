package com.example.cotato4.domain;

import javax.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class User {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column
    private String nickname;

    @Column
    private String phoneNumber;

    @Column
    private String password;

    @Column(unique = true)
    private String email;
}
