package com.javaacademy.demo.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.time.LocalDate;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Бронирование")
public class BookingDtoResponse {

    @Schema(description = "ID бронирования")
    private Integer id;

    @Schema(description = "дата начала бронирования")
    private LocalDate startBookingDate;

    @Schema(description = "дата окончания бронирования")
    private LocalDate finishBookingDate;

    @Schema(description = "ссылка на клиента")
    private ClientDto clientDto;

    @Schema(description = "ссылка на объявление")
    private AdvertDtoResponse advertDtoResponse;

    @Schema(description = "стоимость всего бронирования")
    private BigDecimal bookingPrice;
}
