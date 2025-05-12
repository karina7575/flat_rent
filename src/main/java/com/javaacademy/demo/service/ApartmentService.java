package com.javaacademy.demo.service;

import com.javaacademy.demo.dto.ApartmentDto;
import com.javaacademy.demo.entity.Apartment;
import com.javaacademy.demo.mapper.ApartmentMapperMapstruct;
import com.javaacademy.demo.repository.ApartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ApartmentService {
    private final ApartmentRepository apartmentRepository;
    private final ApartmentMapperMapstruct apartmentMapperMapstruct;

    public ApartmentDto saveApartment(ApartmentDto apartmentDto) {
        Apartment apartment = apartmentRepository.save(apartmentMapperMapstruct.toEntity(apartmentDto));
        return apartmentMapperMapstruct.toDto(apartmentRepository.findById(apartment.getId()).orElseThrow());
    }
}
