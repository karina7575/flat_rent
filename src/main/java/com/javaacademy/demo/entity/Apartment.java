package com.javaacademy.demo.entity;

import com.javaacademy.demo.entity.enums.ApartmentLayout;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Помещение
 */
@Entity
@ToString
@Getter
@Setter
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
    private ApartmentLayout rooms;     //количество комнат

    @ToString.Exclude
    @OneToOne(mappedBy = "apartment")
    private Advert advert;
}
