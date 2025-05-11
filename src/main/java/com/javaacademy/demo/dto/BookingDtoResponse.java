package com.javaacademy.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingDtoResponse {
    private Integer id;
    private LocalDateTime startBookingDate;     //дата начала бронирования
    private LocalDateTime finishBookingDate;    //дата окончания бронирования
    private ClientDto clientDto;                //ссылка на клиента
    private AdvertDtoResponse advertDtoResponse;                //ссылка на объявление
    private BigDecimal bookingPrice;            //стоимость всего бронирования
}
