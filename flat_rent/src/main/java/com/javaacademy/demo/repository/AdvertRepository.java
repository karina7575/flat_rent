package com.javaacademy.demo.repository;

import com.javaacademy.demo.entity.Advert;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdvertRepository extends JpaRepository<Advert, Integer> {
}
