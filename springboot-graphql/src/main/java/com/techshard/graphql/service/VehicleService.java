package com.techshard.graphql.service;

import com.techshard.graphql.dao.entity.Vehicle;
import com.techshard.graphql.dao.repository.VehicleRepository;
import com.techshard.graphql.exception.VehicleNotFoundException;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

@Service
public class VehicleService {

    private final VehicleRepository vehicleRepository ;

    public VehicleService(final VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository ;
    }

    @Transactional
    public Vehicle createVehicle(final String type,final String modelCode, final String brandName, final String launchDate) {
        final Vehicle vehicle = new Vehicle();
        vehicle.setType(type);
        vehicle.setModelCode(modelCode);
        vehicle.setBrandName(brandName);
        vehicle.setLaunchDate(LocalDate.parse(launchDate));
        return this.vehicleRepository.save(vehicle);
    }

    public List<Vehicle> getAllVehicles() {
        return this.vehicleRepository.findAll();
    }
    
    public List<Vehicle> getVehiclesbyCount(final int count) {
        return this.vehicleRepository.findAll().stream().limit(count).collect(Collectors.toList());
    }

    public Optional<Vehicle> getVehicle(final int id) {
        return this.vehicleRepository.findById(id);
    }
    
    @Transactional
    public boolean deleteVehicle(final int id) {
    	vehicleRepository.deleteById(id);		 
    	return true;
    }
    
    @Transactional
    public  Vehicle updateVehicleType(int id, String type)
    {
    	 Vehicle vehicle = vehicleRepository
    			 .findById(id)
    			 .orElseThrow(()-> new VehicleNotFoundException(id));    			 
    	 vehicle.setType(type);   
    	 vehicleRepository.saveAndFlush(vehicle);
    	return vehicle;
    	
    }

    
   
}
