package com.javaacademy.demo.dto;

import com.javaacademy.demo.entity.enums.ApartmentLayout;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Помещение")
public class ApartmentDto {

    @Schema(description = "ID помещения")
    private Integer id;

    @Schema(description = "город")
    private String city;

    @Schema(description = "улица")
    private String street;

    @Schema(description = "дом")
    private Integer house;

    @Schema(description = "корпус")
    private String building;

    @Schema(description = "количество комнат")
    private ApartmentLayout rooms;
}
