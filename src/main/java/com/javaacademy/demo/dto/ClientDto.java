package com.javaacademy.demo.dto;

import com.javaacademy.demo.entity.Booking;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClientDto {
    private Integer id;
    private String name;                          //Имя клиента
    private String email;                         //email клиента (УНИКАЛЬНЫЙ)
    private Booking booking;
}
