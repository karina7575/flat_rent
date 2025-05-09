package com.javaacademy.demo.repository;

import com.javaacademy.demo.Entity.Apartment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApartmentRepository extends JpaRepository<Apartment, Integer> {
}
