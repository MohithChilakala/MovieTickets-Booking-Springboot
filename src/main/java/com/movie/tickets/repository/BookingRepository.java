package com.movie.tickets.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.movie.tickets.entity.Booking;

public interface BookingRepository extends JpaRepository<Booking, Long> {

}
