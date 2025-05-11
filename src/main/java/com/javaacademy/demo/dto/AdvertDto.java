package com.javaacademy.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
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
@Schema(description = "Объявление")
public class AdvertDto {
    @Schema(description = "id объявления")
    private Integer id;

    @Schema(description = "цена за ночь")
    private BigDecimal price;

    @Schema(description = "статус (активно или архивное)")
    @JsonProperty("is_active")
    @NonNull
    private Boolean isActive;

    @Schema(description = "id помещения")
    @JsonProperty("apartment_id")
    @NonNull
    private Integer apartmentId;

    @Schema(description = "описание объявления")
    private String description;
}
