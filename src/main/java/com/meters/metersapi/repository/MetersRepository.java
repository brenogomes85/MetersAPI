package com.meters.metersapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.meters.metersapi.models.Medidores;

@Repository
public interface MetersRepository extends JpaRepository<Medidores, Integer> {
	
}
