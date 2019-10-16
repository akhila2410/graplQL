package com.techshard.graphql.dao.repository;

import com.techshard.graphql.dao.entity.Vehicle;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Integer> {
	Optional<Vehicle> findById(Long id);
    
}
