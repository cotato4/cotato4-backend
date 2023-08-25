package com.example.cotato4.repository;

import com.example.cotato4.domain.SubwayInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubwayInfoRepository extends JpaRepository<SubwayInfo, Long> {
    List<SubwayInfo> findAllByName(String key);
}
