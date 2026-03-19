package org.example.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.dto.AdvertisementRequestDto;
import org.example.dto.AdvertisementResponseDto;
import org.example.entity.Advertisement;
import org.example.exception.ResourceNotFoundException;
import org.example.mapper.AdvertisementMapper;
import org.example.repository.AdvertisementRepository;
import org.example.service.AdvertisementService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class AdvertisementServiceImpl implements AdvertisementService {

    private final AdvertisementRepository advertisementRepository;
    private final AdvertisementMapper advertisementMapper;

    @Override
    public List<AdvertisementResponseDto> getAll() {
        return advertisementRepository.findAll().stream()
                .map(advertisementMapper::toResponseDto)
                .toList();
    }

    @Override
    public AdvertisementResponseDto getById(Long id) {
        return advertisementMapper.toResponseDto(findByIdOrThrow(id));
    }

    @Override
    @Transactional
    public AdvertisementResponseDto create(AdvertisementRequestDto requestDto) {
        Advertisement advertisement = advertisementMapper.toEntity(requestDto);
        Advertisement savedAdvertisement = advertisementRepository.save(advertisement);
        return advertisementMapper.toResponseDto(savedAdvertisement);
    }

    @Override
    @Transactional
    public AdvertisementResponseDto update(Long id, AdvertisementRequestDto requestDto) {
        Advertisement advertisement = findByIdOrThrow(id);
        advertisementMapper.updateEntityFromDto(requestDto, advertisement);
        Advertisement updatedAdvertisement = advertisementRepository.save(advertisement);
        return advertisementMapper.toResponseDto(updatedAdvertisement);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        Advertisement advertisement = findByIdOrThrow(id);
        advertisementRepository.delete(advertisement);
    }

    private Advertisement findByIdOrThrow(Long id) {
        return advertisementRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Advertisement with id=" + id + " was not found"));
    }
}
