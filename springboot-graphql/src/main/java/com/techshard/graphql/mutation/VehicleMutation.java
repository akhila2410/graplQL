package com.techshard.graphql.mutation;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.techshard.graphql.dao.entity.Vehicle;
import com.techshard.graphql.dao.repository.VehicleRepository;
import com.techshard.graphql.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class VehicleMutation implements GraphQLMutationResolver {

    @Autowired
    private VehicleService vehicleService;

    public Vehicle createVehicle(final String type, final String modelCode, final String brandName, final String launchDate) {
        return this.vehicleService.createVehicle(type, modelCode, brandName, launchDate);
    }    
  
    public boolean deleteVehicle(final int id) {
    return	vehicleService.deleteVehicle(id);
    }
    
    
    public Vehicle updateVehicleType(int id, String type) {    	
    	return this.vehicleService.updateVehicleType(id, type);
    	
    }
    
 }
       
