package com.javaacademy.demo.Entity;

import jakarta.persistence.Entity;

import java.math.BigDecimal;

@Entity
public class Advert {

    private BigDecimal price;                             //цена за ночь

    private AdvertStatus advertStatus;                    //статус (активно или архивное)

    private Apartment apartment;                          //ссылка на помещение

    private String description;                           //описание

}
