//package com.javaacademy.demo.Entity;
//
//import jakarta.persistence.Column;
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//
//@Entity
//public class Client {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Integer id;
//
//    @Column(nullable = false)
//    private String name;                          //Имя клиента
//
//    @Column(nullable = false, unique = true)
//    private String email;                         //email клиента (УНИКАЛЬНЫЙ)
//
//}
