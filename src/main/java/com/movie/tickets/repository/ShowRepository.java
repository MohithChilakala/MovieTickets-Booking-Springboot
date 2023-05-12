package com.movie.tickets.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.movie.tickets.entity.Show;

public interface ShowRepository extends JpaRepository<Show, Long> {

}
