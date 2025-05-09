package com.javaacademy.demo.repository;

import com.javaacademy.demo.Entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Integer> {
}
