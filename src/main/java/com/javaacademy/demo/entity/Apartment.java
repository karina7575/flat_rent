package com.javaacademy.demo.entity;

import com.javaacademy.demo.entity.enums.ApartmentType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * Помещение
 */
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Apartment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer id;

    @Column(nullable = false)
    private String city;              //город

    @Column(nullable = false)
    private String street;            //улица

    @Column(name = "house_number", nullable = false)
    private String houseNumber;      //дом

    @Column(nullable = false)
    private String building;          //корпус

    @Column(nullable = false, columnDefinition = "ApartmentType", name = "rooms")
    @Enumerated(EnumType.STRING)
    private ApartmentType rooms;     //количество комнат

    @ToString.Exclude
    @OneToMany(mappedBy = "apartment", fetch = FetchType.LAZY)
    private List<Advert> advert;
}
