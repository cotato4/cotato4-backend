package com.example.cotato4.service;

import com.example.cotato4.domain.SubwayInfo;
import com.example.cotato4.domain.Umbrella;
import com.example.cotato4.domain.User;
import com.example.cotato4.dto.SubwayResponseDto;
import com.example.cotato4.dto.UmbrellaRequestDto;
import com.example.cotato4.repository.SubwayInfoRepository;
import com.example.cotato4.repository.UmbrellaRepository;
import com.example.cotato4.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@RequiredArgsConstructor
@Service
public class UmbrellaService {

    private final UserRepository userRepository;
    private final UmbrellaRepository umbrellaRepository;
    private final SubwayInfoRepository subwayInfoRepository;

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
        umbrellaRepository.save(umbrella);

        return ResponseEntity.ok().build();
    }

    public List<SubwayResponseDto> getSubwayList(Long userId, Double lat, Double lng) {
        Map<Double, String> subwayMap = new TreeMap<>();
        List<SubwayInfo> subwayInfoList = subwayInfoRepository.findAll();
        for (SubwayInfo subwayInfo : subwayInfoList) {
            if (!subwayMap.containsValue(subwayInfo.getName())) {
                subwayMap.put(calcDist(lat - subwayInfo.getLat(), lng - subwayInfo.getLng()), subwayInfo.getName());
            }
        }
//        for (int i = 0; i < 3; i++) {
//            subwayInfoList = subwayInfoRepository.findAllByName(subwayMap.)
//        }
        Iterator<Map.Entry<Double,String>> iterator = subwayMap.entrySet().iterator();

        List<SubwayResponseDto> subwayResponseDtoList = new ArrayList<>();

        for (int i = 0; i < 3 && iterator.hasNext(); i++) {
            Map.Entry<Double,String> entry = iterator.next();
//            System.out.println("Key: " + entry.getKey() + ", Value: "+ entry.getValue());
            subwayInfoList = subwayInfoRepository.findAllByName(entry.getValue());
            List<Integer> lineList = new ArrayList<>();
            for (SubwayInfo subwayInfo : subwayInfoList) {
                lineList.add(subwayInfo.getLine());
            }

            subwayResponseDtoList.add(SubwayResponseDto.builder()
                            .name(entry.getValue())
                            .lineList(lineList)
                    .build());
        }
        return subwayResponseDtoList;
    }

    private Double calcDist(double lat, double lng) {
        return lat * lat + lng * lng;
    }

    public static final Map<Integer, String> subwayColor = new HashMap<>() {{
        put(1, "#0052A4");
        put(2, "#00A84D");
        put(3, "#EF7C1C");
        put(4, "#00A5DE");
        put(5, "#996CAC");
        put(6, "#CD7C2F");
        put(7, "#747F00");
        put(8, "#E6186C");
        put(9, "#BDB092");
    }};
}
