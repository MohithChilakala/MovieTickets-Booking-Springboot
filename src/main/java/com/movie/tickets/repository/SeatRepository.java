package com.movie.tickets.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.movie.tickets.entity.Seat;

public interface SeatRepository extends JpaRepository<Seat, Long> {
	List<Seat> findAllByShowId(long show_id);
}
