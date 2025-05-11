package com.javaacademy.demo.service;

import com.javaacademy.demo.exception.EntityNotFoundException;
import com.javaacademy.demo.exception.FilledIdException;
import com.javaacademy.demo.dto.AdvertDtoResponse;
import com.javaacademy.demo.dto.AdvertDto;
import com.javaacademy.demo.entity.Advert;
import com.javaacademy.demo.mapper.AdvertMapperMapstruct;
import com.javaacademy.demo.repository.AdvertRepository;
import com.javaacademy.demo.repository.ApartmentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AdvertService {
    private AdvertRepository advertRepository;
    private ApartmentRepository apartmentRepository;
    private AdvertMapperMapstruct advertMapperMapstruct;
    private static final int PAGE_SIZE = 10;

    public AdvertDtoResponse saveAdvert(AdvertDto advertDto) {
        if (advertDto.getApartmentId() == null) {
            throw new FilledIdException("Объявление без ID помещения не будет сохранено");
        }
        apartmentRepository.findById(advertDto.getApartmentId())
                .orElseThrow(() -> new EntityNotFoundException("Клиента с ID не существует."));
        Advert advert = advertRepository.save(advertMapperMapstruct.toEntityWithRelation(advertDto));
        log.trace("Выполнено сохранение объявления.");
        return advertMapperMapstruct.toDto(advertRepository.findById(advert.getId()).orElseThrow());
    }

    public Page<AdvertDtoResponse> findAllByCity(Integer pageNumber, String city) {
        Sort sort = Sort.by(Sort.Direction.DESC, "price");
        PageRequest pageRequest = PageRequest.of(pageNumber, PAGE_SIZE, sort);
        Page<Advert> adverts = advertRepository.findAllByApartmentCity(city, pageRequest);
        log.trace("Выполнен поиск объявлений по городу.");
        return adverts.map(advertMapperMapstruct::toDto);
    }


}
