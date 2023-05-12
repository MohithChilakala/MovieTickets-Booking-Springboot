package com.movie.tickets.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.movie.tickets.entity.Address;
import com.movie.tickets.entity.Owner;
import com.movie.tickets.entity.Theatre;

public interface TheatreRepository extends JpaRepository<Theatre, Long> {

	Theatre findByAddress(Address address);
	Theatre findByOwner(Owner owner);

}
