package com.javaacademy.demo.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

/**
 * Помещение
 */
@Entity
public class Apartment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String city;              //город

    @Column(nullable = false)
    private String street;            //улица

    @Column(nullable = false)
    private Integer houseNumber;      //дом

    @Column(nullable = false)
    private String building;          //корпус

    @Column(nullable = false, columnDefinition = "ApartmentLayout")
    @Enumerated(EnumType.STRING)
    private ApartmentLayout rooms;            //количество комнат ( только комната, 1-комнатная, 2-комнатная, 3-комнатная, 4 и более комнатная квартира)

    @OneToOne(mappedBy = "apartment")
    private Advert advert;
}
