package com.example.cotato4.controller;

import com.example.cotato4.dto.UmbrellaRequestDto;
import com.example.cotato4.service.UmbrellaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.json.simple.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "umbrella")
@RequiredArgsConstructor
@RequestMapping("/umbrella")
@RestController
public class UmbrellaController {

    public final UmbrellaService umbrellaService;

    @Operation(summary = "우산 등록")
    @PostMapping("/{userId}")
    public ResponseEntity<?> createPost(@PathVariable Long userId,
                                        @RequestBody UmbrellaRequestDto umbrellaRequestDto) {
        return umbrellaService.createPost(userId, umbrellaRequestDto);
    }

    @GetMapping("/{userId}")
    public JSONObject getPosts(@PathVariable Long userId, @RequestParam String subway) {
        JSONObject obj = new JSONObject();
        obj.put("userId", userId);
        obj.put("umbrellaList", umbrellaService.getPosts(subway));
        return obj;
    }

    @GetMapping("/{userId}/{umbrellaId}")
    public ResponseEntity<?> getPost(@PathVariable Long userId, @PathVariable Long umbrellaId) {
        return umbrellaService.getPost(userId, umbrellaId);
    }

    @Operation(summary = "가까운 지하철 역 찾기")
    @GetMapping("/{userId}/subway")
    public JSONObject getSubwayList (@PathVariable Long userId,
                                     @RequestParam Double lat,
                                     @RequestParam Double lng) {
        JSONObject obj = new JSONObject();
        obj.put("userId", userId);
        obj.put("subwayList", umbrellaService.getSubwayList(userId, lat, lng));
        return obj;
    }
}
