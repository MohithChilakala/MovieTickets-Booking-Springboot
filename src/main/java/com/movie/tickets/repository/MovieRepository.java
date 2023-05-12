package com.movie.tickets.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.movie.tickets.entity.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long> {

}
