//package com.javaacademy.demo.Entity;
//
//import jakarta.persistence.Column;
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//
//import java.math.BigDecimal;
//import java.time.LocalDateTime;
//
//@Entity
//public class Booking {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Integer id;
//
//    @Column(nullable = false)
//    private LocalDateTime startBookingDate;     //дата начала бронирования
//
//    @Column(nullable = false)
//    private LocalDateTime finishBookingDate;    //дата окончания бронирования
//
//    @Column(nullable = false)
//    private Client client;                      //ссылка на клиента
//
//    @Column(nullable = false)
//    private Advert advert;                      //ссылка на объявление
//
//    @Column(nullable = false)
//    private BigDecimal bookingPrice;            //стоимость всего бронирования
//
//}
