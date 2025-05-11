package com.javaacademy.demo.mapper;

import com.javaacademy.demo.exception.EntityNotFoundException;
import com.javaacademy.demo.dto.AdvertDtoResponse;
import com.javaacademy.demo.dto.AdvertDto;
import com.javaacademy.demo.entity.Advert;
import com.javaacademy.demo.entity.Apartment;
import com.javaacademy.demo.repository.ApartmentRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(uses = {ApartmentMapperMapstruct.class})
public abstract class AdvertMapperMapstruct {

    @Autowired
    private ApartmentRepository apartmentRepository;

    @Mapping(target = "apartment", source = "apartmentId", qualifiedByName = "getApartment")
    @Mapping(target = "booking", ignore = true)
    public abstract Advert toEntityWithRelation(AdvertDto advertDto);

    @Mapping(target = "apartmentDto", source = "apartment")
    public abstract AdvertDtoResponse toDto(Advert advert);

    @Named("getApartment")
    protected Apartment getApartment(Integer apartmentId) {
        return apartmentRepository.findById(apartmentId)
                .orElseThrow(() -> new EntityNotFoundException("Квартир с ID = %s не существует."
                        .formatted(apartmentId)));
    }
}
