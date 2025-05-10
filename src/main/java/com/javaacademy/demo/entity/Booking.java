package com.javaacademy.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Бронирование
 */
@Entity
@ToString
@Getter
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private LocalDateTime startBookingDate;     //дата начала бронирования

    @Column(nullable = false)
    private LocalDateTime finishBookingDate;    //дата окончания бронирования

    //@Column(nullable = false)
    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;                      //ссылка на клиента

    //@Column(nullable = false)
    @ToString.Exclude
    @OneToOne
    @JoinColumn(name = "advert_id")
    private Advert advert;                      //ссылка на объявление

    @Column(nullable = false)
    private BigDecimal bookingPrice;            //стоимость всего бронирования

}
