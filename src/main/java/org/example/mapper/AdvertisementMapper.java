package org.example.mapper;

import org.example.dto.AdvertisementRequestDto;
import org.example.dto.AdvertisementResponseDto;
import org.example.entity.Advertisement;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface AdvertisementMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    Advertisement toEntity(AdvertisementRequestDto requestDto);

    AdvertisementResponseDto toResponseDto(Advertisement advertisement);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    void updateEntityFromDto(AdvertisementRequestDto requestDto, @MappingTarget Advertisement advertisement);
}
