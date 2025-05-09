package com.javaacademy.demo.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;

import java.math.BigDecimal;

/**
 * Объявление
 */
@Entity
public class Advert {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private BigDecimal price;                             //цена за ночь

    @Column(nullable = false, columnDefinition = "AdvertStatus")
    @Enumerated(EnumType.STRING)
    private AdvertStatus advertStatus;                    //статус (активно или архивное)

    //@Column(nullable = false, unique = true)
    @OneToOne
    @JoinColumn(name = "apartment_id")
    private Apartment apartment;                          //ссылка на помещение

    @Column(nullable = false)
    private String description;                           //описание

    @OneToOne(mappedBy = "advert")
    private Booking booking;
}
