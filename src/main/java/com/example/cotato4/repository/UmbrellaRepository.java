package com.example.cotato4.repository;

import com.example.cotato4.domain.Umbrella;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UmbrellaRepository extends JpaRepository<Umbrella, Long> {
    List<Umbrella> findAllBySubway(String subway);
}
