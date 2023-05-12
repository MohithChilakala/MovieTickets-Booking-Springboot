package com.movie.tickets.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.movie.tickets.entity.Address;
import com.movie.tickets.entity.Theatre;

public interface AddressRepository extends JpaRepository<Address, Long> {
	List<Address> findByCity(String city);
	List<Address> findByPincode(String pincode);
	Address findByTheatre(Theatre theatre);
}
