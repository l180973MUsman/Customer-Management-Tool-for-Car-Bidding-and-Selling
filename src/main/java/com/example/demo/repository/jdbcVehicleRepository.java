package com.example.demo.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Vehicle;

@Repository 
public class jdbcVehicleRepository implements VehicleRepository{
   
	@Autowired
    private JdbcTemplate db;
		
	@Override
	public int save(Vehicle vehicle) {
		// TODO Auto-generated method stub
		return db.update(
				"Insert into vehicle (Name, Color, Engine_Number, Chassis_Number, Engine_Size, Fuel_Type, Drivetrain, Seller) values (?,?,?,?,?,?,?,?)",
				vehicle.getName(), vehicle.getColor(), vehicle.getEngine_number(),
				vehicle.getChassis_number(), vehicle.getEngine_size(),
				vehicle.getFuel_type(), vehicle.getDrivetrain(),
				vehicle.getSeller());
	}

	@Override
	public List<Vehicle> findBySeller(String seller) {
		// TODO Auto-generated method stub
		return db.query("Select * from Vehicle where Seller=?",
                BeanPropertyRowMapper.newInstance(Vehicle.class), seller);
	}

	@Override
	public List<Vehicle> findByBuyer(String buyer) {
		// TODO Auto-generated method stub
		return db.query("Select * from Vehicle where Buyer=?",
                BeanPropertyRowMapper.newInstance(Vehicle.class), buyer);
	}

	@Override
	public List<Vehicle> findAll() {
		// TODO Auto-generated method stub
		return db.query("Select * from Vehicle",
                BeanPropertyRowMapper.newInstance(Vehicle.class));
	}

	@Override
	public int remove(int vehicle) {
		// TODO Auto-generated method stub
		return db.update("delete from Vehicle where ID=?", vehicle);
	}
	
	

}
