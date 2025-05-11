package com.javaacademy.demo.repository;

import com.javaacademy.demo.entity.Advert;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdvertRepository extends JpaRepository<Advert, Integer> {
    Page<Advert> findAllByApartmentCity(String city, Pageable pageable);
}
