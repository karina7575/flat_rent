package com.javaacademy.demo.dto;

import lombok.Builder;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Builder
public class BookingDto {
    private Integer id;
    private LocalDateTime startBookingDate;     //дата начала бронирования
    private LocalDateTime finishBookingDate;    //дата окончания бронирования
    private ClientDto client;                      //ссылка на клиента
    private AdvertDto advert;                      //ссылка на объявление
    private BigDecimal bookingPrice;            //стоимость всего бронирования
}
