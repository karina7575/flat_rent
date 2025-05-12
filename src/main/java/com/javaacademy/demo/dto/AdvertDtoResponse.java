package com.javaacademy.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Объявление")
public class AdvertDtoResponse {

    @Schema(description = "id объявления")
    private Integer id;

    @Schema(description = "цена за ночь")
    private BigDecimal price;

    @Schema(description = "ссылка на помещение")
    @JsonProperty("apartment")
    private ApartmentDto apartmentDto;

    @Schema(description = "описание объявления")
    private String description;
}
