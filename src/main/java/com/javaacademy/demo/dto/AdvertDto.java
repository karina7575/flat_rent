package com.javaacademy.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import java.math.BigDecimal;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdvertDto {
    private Integer id;
    private BigDecimal price;                             //цена за ночь

    @JsonProperty("is_active")
    @NonNull
    private Boolean isActive;                    //статус (активно или архивное)

    @JsonProperty("apartment_id")
    @NonNull
    private Integer apartmentId;                          //id помещения

    private String description;                           //описание
}
