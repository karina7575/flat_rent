package com.javaacademy.demo.mapper;

import com.javaacademy.demo.dto.BookingDto;
import com.javaacademy.demo.dto.BookingDtoResponse;
import com.javaacademy.demo.entity.Advert;
import com.javaacademy.demo.entity.Booking;
import com.javaacademy.demo.entity.Client;
import com.javaacademy.demo.exception.EntityNotFoundException;
import com.javaacademy.demo.repository.AdvertRepository;
import com.javaacademy.demo.repository.ClientRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(uses = {AdvertMapperMapstruct.class, ApartmentMapperMapstruct.class},
        componentModel = MappingConstants.ComponentModel.SPRING)
public abstract class BookingMapperMapstruct {
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private AdvertRepository advertRepository;

    @Mapping(target = "client", source = "clientDto")
    @Mapping(target = "advert", source = "advertId", qualifiedByName = "getAdvert")
    @Mapping(target = "bookingPrice", ignore = true)
    @Mapping(target = "startBookingDate", source = "dateStart")
    @Mapping(target = "finishBookingDate", source = "dateFinish")
    public abstract Booking toEntityWithRelation(BookingDto bookingDto);

    @Mapping(target = "clientDto", source = "client")
    @Mapping(target = "advertDtoResponse", source = "advert")
    public abstract BookingDtoResponse toDto(Booking booking);

    @Named("getClient")
    protected Client getClient(Integer clientId) {
        return clientRepository.findById(clientId)
                .orElseThrow(() -> new EntityNotFoundException("Клиента с ID = %s не существует."
                        .formatted(clientId)));
    }

    @Named("getAdvert")
    protected Advert getAdvert(Integer advertId) {
        return advertRepository.findById(advertId)
                .orElseThrow(() -> new EntityNotFoundException("Объявления с ID = %s не существует."
                        .formatted(advertId)));
    }

}
