package com.javaacademy.demo.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import java.time.LocalDate;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Бронирование")
public class BookingDto {

    @Schema(description = "ID бронирования")
    private Integer id;

    @Schema(description = "ссылка на клиента")
    @JsonProperty("client")
    @NonNull
    private ClientDto clientDto;

    @Schema(description = "ID объявления")
    @JsonProperty("advert_id")
    @NonNull
    private Integer advertId;

    @Schema(description = "дата начала бронирования")
    @JsonProperty("date_start")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @NonNull
    private LocalDate startBookingDate;

    @Schema(description = "дата окончания бронирования")
    @JsonProperty("date_finish")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @NonNull
    private LocalDate finishBookingDate;
}
