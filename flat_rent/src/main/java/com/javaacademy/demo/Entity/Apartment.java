package com.javaacademy.demo.Entity;

import jakarta.persistence.Entity;

import java.math.BigDecimal;

@Entity
public class Apartment {

    private String city;              //город

    private String street;            //улица

    private Integer houseNumber;      //дом

    private String building;          //корпус

    private Integer rooms;            //количество комнат ( только комната, 1-комнатная, 2-комнатная, 3-комнатная, 4 и более комнатная квартира)
}
