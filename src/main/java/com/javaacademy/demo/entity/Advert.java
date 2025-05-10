package com.javaacademy.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.math.BigDecimal;

/**
 * Объявление
 */
@Entity
@ToString
@Getter
@Setter
public class Advert {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private BigDecimal price;                             //цена за ночь

    @Column(name = "is_active", nullable = false)
    private Boolean isActive;                             //статус (активно или архивное)

    //@Column(nullable = false, unique = true)
    @ToString.Exclude
    @OneToOne
    @JoinColumn(name = "apartment_id", unique = true)
    private Apartment apartment;                          //ссылка на помещение

    @Column(nullable = false)
    private String description;                           //описание

    @OneToOne(mappedBy = "advert")
    private Booking booking;
}
