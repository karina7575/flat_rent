package com.javaacademy.demo.repository;

import com.javaacademy.demo.entity.Booking;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;

public interface BookingRepository extends JpaRepository<Booking, Integer> {
    @Query(value = """
            Select count(id) = 0 as no_booking
            from booking b
            where b.advert_id = :advertId
                and (
                :startDate between b.date_start and b.date_finish
                or
                :finishDate between b.date_start and b.date_finish
                );
            """, nativeQuery = true)
    Boolean canBook(Integer advertId, LocalDate startDate, LocalDate finishDate);

    Page<Booking> findAllByClientEmail(String email, Pageable pageable);

}
