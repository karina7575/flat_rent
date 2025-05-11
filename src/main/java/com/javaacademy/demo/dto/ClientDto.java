package com.javaacademy.demo.dto;

import com.javaacademy.demo.entity.Booking;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Клиент")
public class ClientDto {

    @Schema(description = "ID клиента")
    private Integer id;

    @Schema(description = "Имя клиента")
    private String name;

    @Schema(description = "email клиента (УНИКАЛЬНЫЙ)")
    private String email;
}
