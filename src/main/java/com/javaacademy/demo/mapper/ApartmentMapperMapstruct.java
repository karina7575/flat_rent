package com.javaacademy.demo.mapper;

import com.javaacademy.demo.dto.ApartmentDto;
import com.javaacademy.demo.entity.Apartment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(uses = {AdvertMapperMapstruct.class})
public interface ApartmentMapperMapstruct {

    @Mapping(target = "house", source = "houseNumber")
    ApartmentDto toDto(Apartment apartment);

    Apartment toEntity(ApartmentDto apartmentDto);
}
