package io.github.kayque.integration_test.Service;

import io.github.kayque.integration_test.Entity.Vehicle;
import io.github.kayque.integration_test.Repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;

    public Boolean createVehicle(String brand, String model, int year){
        try{
            vehicleRepository.save(new Vehicle(null, brand, model, year));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public List<Vehicle> getVehiclesByBrand(String brand){
        return vehicleRepository.findByBrand(brand);
    }

    public List<Vehicle> getAllVehicles(){
        return vehicleRepository.findAll();
    }

    public Vehicle getVehicleById(Long id){
        return vehicleRepository.findById(id).orElse(null);
    }

    public Vehicle updateVehicle(Long id, String brand, String model, Integer year) {
        Vehicle vehicle = vehicleRepository.findById(id).orElse(null);

        if (vehicle == null) {
            return null;
        }else{
            if (brand != null) {
                vehicle.setBrand(brand);
            }
            if (model != null) {
                vehicle.setModel(model);
            }
            if (year != null) {
                vehicle.setManufactureYear(year);
            }
            return vehicleRepository.save(vehicle);
        }
    }

    public Vehicle deleteVehicleById(Long id){
        Vehicle vehicle = vehicleRepository.findById(id).orElse(null);
        if(vehicle != null){
            vehicleRepository.deleteById(id);
        }
        return vehicle;
    }
}
