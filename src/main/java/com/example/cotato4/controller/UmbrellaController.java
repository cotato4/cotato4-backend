package com.example.cotato4.controller;

import com.example.cotato4.dto.UmbrellaRequestDto;
import com.example.cotato4.service.UmbrellaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "umbrella", description = "umbrella")
@RequiredArgsConstructor
@RequestMapping("/umbrella")
@RestController
public class UmbrellaController {

    public final UmbrellaService umbrellaService;

    @Operation(summary = "umbrella", description = "umbrella")
    @PostMapping("/{userId}")
    public ResponseEntity createPost(@PathVariable Long userId, @RequestBody UmbrellaRequestDto umbrellaRequestDto) {
        return umbrellaService.createPost(userId, umbrellaRequestDto);
    }
}
