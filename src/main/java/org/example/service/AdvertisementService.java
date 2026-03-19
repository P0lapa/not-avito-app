package org.example.service;

import org.example.dto.AdvertisementRequestDto;
import org.example.dto.AdvertisementResponseDto;

import java.util.List;

public interface AdvertisementService {

    List<AdvertisementResponseDto> getAll();

    AdvertisementResponseDto getById(Long id);

    AdvertisementResponseDto create(AdvertisementRequestDto requestDto);

    AdvertisementResponseDto update(Long id, AdvertisementRequestDto requestDto);

    void delete(Long id);
}
