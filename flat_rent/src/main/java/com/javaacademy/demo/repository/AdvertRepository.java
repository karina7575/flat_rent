package com.javaacademy.demo.repository;

import com.javaacademy.demo.Entity.Advert;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdvertRepository extends JpaRepository<Advert, Integer> {
}
