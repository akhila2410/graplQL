package com.techshard.graphql.query;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.techshard.graphql.dao.entity.Vehicle;
import com.techshard.graphql.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class VehicleQuery implements GraphQLQueryResolver {

    @Autowired
    private VehicleService vehicleService;
    
    public List<Vehicle> findAllVehicles() {
        return this.vehicleService.getAllVehicles();
    }

    public List<Vehicle> getVehiclesByCount(final int count) {
        return this.vehicleService.getVehiclesbyCount(count);
    }

    public Optional<Vehicle> getVehicleById(final int id) {
        return this.vehicleService.getVehicle(id);
    }
}
