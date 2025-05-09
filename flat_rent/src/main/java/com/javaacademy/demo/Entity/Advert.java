//package com.javaacademy.demo.Entity;
//
//import jakarta.persistence.Column;
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//
//import java.math.BigDecimal;
//
//@Entity
//public class Advert {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Integer id;
//
//    @Column(nullable = false)
//    private BigDecimal price;                             //цена за ночь
//
//    @Column(nullable = false)
//    private AdvertStatus advertStatus;                    //статус (активно или архивное)
//
//    @Column(nullable = false)
//    private Apartment apartment;                          //ссылка на помещение
//
//    @Column(nullable = false)
//    private String description;                           //описание
//
//}
