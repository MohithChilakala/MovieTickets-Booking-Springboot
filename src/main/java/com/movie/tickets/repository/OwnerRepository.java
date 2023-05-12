package com.movie.tickets.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.movie.tickets.entity.Owner;

public interface OwnerRepository extends JpaRepository<Owner, Long> {
	Owner findByPhoneNo(String phoneNo);
	Owner findByEmail(String email);
	void deleteByEmail(String email);
	void deleteByPhoneNo(String phoneNo);
}
