package com.javaacademy.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdvertDtoResponse {
    private Integer id;
    private BigDecimal price;
    @JsonProperty("is_active")
    private Boolean isActive;
    private ApartmentDto apartmentDto;
    private String description;
}
