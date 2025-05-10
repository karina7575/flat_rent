package com.javaacademy.demo.dto;

import com.javaacademy.demo.entity.enums.ApartmentLayout;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ApartmentDto {

    private Integer id;
    private String city;              //город
    private String street;            //улица
    private Integer house;            //дом
    private String building;          //корпус
    private ApartmentLayout rooms;    //количество комнат
}
