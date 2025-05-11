package com.javaacademy.demo.service;

import com.javaacademy.demo.dto.ApartmentDto;
import com.javaacademy.demo.entity.Apartment;
import com.javaacademy.demo.mapper.ApartmentMapperMapstruct;
import com.javaacademy.demo.repository.ApartmentRepository;
import org.springframework.stereotype.Service;

@Service
public class ApartmentService {
    private ApartmentRepository apartmentRepository;
    private ApartmentMapperMapstruct apartmentMapperMapstruct;

    public ApartmentDto saveApartment(ApartmentDto apartmentDto) {
        Apartment apartment = apartmentRepository.save(apartmentMapperMapstruct.toEntity(apartmentDto));
        return apartmentMapperMapstruct.toDto(apartmentRepository.findById(apartment.getId()).orElseThrow());
    }
}
