package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Vehicle;
import com.example.demo.repository.VehicleRepository;

@RestController
public class VehicleController {
	@Autowired
    VehicleRepository vehicleRepository;
	
    @GetMapping(value="/getvehicles")
    public ResponseEntity<List<Vehicle>> getAllItems() {
        //Getting the ID of the logged in user.
        System.out.println("GET ALL VEHICLES");
        return new ResponseEntity<>(vehicleRepository.findAll(), HttpStatus.OK);
    }
    
    @GetMapping(value="/sellervehicles/{sellerId}")
    public ResponseEntity<List<Vehicle>> getSellerVehicle(@PathVariable("sellerId") String sellerId){
        System.out.println(sellerId);
        List<Vehicle> response = null;
        try{
        	response = vehicleRepository.findBySeller(sellerId);
        }
        catch(Exception e){
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
        
    }
    
    @GetMapping(value="/buyervehicles/{buyerId}")
    public ResponseEntity<List<Vehicle>> getBuyerVehicle(@PathVariable("buyerId") String buyerId){
        System.out.println(buyerId);
        List<Vehicle> response = null;
        try{
        	response = vehicleRepository.findByBuyer(buyerId);
        }
        catch(Exception e){
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
        
    }
    
    @PostMapping(value="/addvehicle")
    public ResponseEntity<Integer> addItem(@RequestBody Vehicle vehicle){        
        int response = 0;
        Vehicle temp = new Vehicle(vehicle.getName(), vehicle.getColor(), vehicle.getEngine_number(), vehicle.getChassis_number(), vehicle.getEngine_size(), vehicle.getFuel_type(), vehicle.getDrivetrain(), vehicle.getSeller());
        try{
        	response = vehicleRepository.save(temp);
        }
        catch(Exception e){
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    
    @PostMapping(value = "/removeVehicle/{vehicleId}")
    public ResponseEntity<Integer> removeItem(@PathVariable("vehicleId") int vehicleId) {
        System.out.println(vehicleId);
        int response = 0;
        try {
            response = vehicleRepository.remove(vehicleId);
        } catch (Exception e) {
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
 }
