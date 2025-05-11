package com.javaacademy.demo.mapper;

import com.javaacademy.demo.dto.ApartmentDto;
import com.javaacademy.demo.entity.Apartment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ApartmentMapperMapstruct {

    @Mapping(target = "house", source = "houseNumber")
    ApartmentDto toDto(Apartment apartment);

    @Mapping(target = "advert", ignore = true)
    @Mapping(target = "houseNumber", source = "house")
    Apartment toEntity(ApartmentDto apartmentDto);
}
