package com.example.demo.repository;

import java.util.List;

import com.example.demo.model.Vehicle;

public interface VehicleRepository {
    int save(Vehicle vehicle);
    List<Vehicle> findAll();
    List<Vehicle> findBySeller(String seller);
    List<Vehicle> findByBuyer(String buyer);
    int remove(int vehicle);
}
