package com.movie.tickets.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.movie.tickets.entity.Hall;

public interface HallRepository extends JpaRepository<Hall, Long> {

}
