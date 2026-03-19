package org.example.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.dto.AdvertisementRequestDto;
import org.example.dto.AdvertisementResponseDto;
import org.example.service.AdvertisementService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/advertisements")
@RequiredArgsConstructor
@Tag(name = "Advertisements", description = "CRUD operations for advertisements")
public class AdvertisementController {

    private final AdvertisementService advertisementService;

    @GetMapping
    @Operation(summary = "Get all advertisements")
    public ResponseEntity<List<AdvertisementResponseDto>> getAll() {
        return ResponseEntity.ok(advertisementService.getAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get advertisement by id")
    public ResponseEntity<AdvertisementResponseDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(advertisementService.getById(id));
    }

    @PostMapping
    @Operation(summary = "Create advertisement")
    public ResponseEntity<AdvertisementResponseDto> create(
            @Valid @RequestBody AdvertisementRequestDto requestDto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(advertisementService.create(requestDto));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update advertisement")
    public ResponseEntity<AdvertisementResponseDto> update(
            @PathVariable Long id,
            @Valid @RequestBody AdvertisementRequestDto requestDto) {
        return ResponseEntity.ok(advertisementService.update(id, requestDto));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete advertisement")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        advertisementService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
