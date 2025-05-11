package com.javaacademy.demo.service;

import com.javaacademy.demo.exception.FilledIdException;
import com.javaacademy.demo.dto.AdvertDtoResponse;
import com.javaacademy.demo.dto.AdvertDto;
import com.javaacademy.demo.entity.Advert;
import com.javaacademy.demo.mapper.AdvertMapperMapstruct;
import com.javaacademy.demo.repository.AdvertRepository;
import com.javaacademy.demo.repository.ApartmentRepository;
import org.springframework.stereotype.Service;

@Service
public class AdvertService {
    private AdvertRepository advertRepository;
    private ApartmentRepository apartmentRepository;
    private AdvertMapperMapstruct advertMapperMapstruct;

    public AdvertDtoResponse saveAdvert(AdvertDto advertDto) {
        if (advertDto.getId() != null) {
            throw new FilledIdException("ID объявления должен быть null");
        }
        if (advertDto.getApartmentId() == null) {
            throw new FilledIdException("Объявление без ID помещения не будет сохранено");
        }
        apartmentRepository.findById(advertDto.getApartmentId()).orElseThrow();
        Advert advert = advertRepository.save(advertMapperMapstruct.toEntityWithRelation(advertDto));
        return advertMapperMapstruct.toDto(advertRepository.findById(advert.getId()).orElseThrow());
    }


}
