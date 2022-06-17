package com.example.demo.model;

public class Vehicle {
	
	private int id;
    private String name;
    private String color;
    private String engine_number;
    private String chassis_number;
    private String engine_size;
    private String fuel_type;
    private String drivetrain;
    private String seller;
    private String buyer;
    

    Vehicle(){
    }
    
    public Vehicle(String name, String color, String engine_number, String chassis_number, String engine_size, String fuel_type, String drivetrain, String seller){
    	this.name = name;
    	this.color = color;
    	this.engine_number = engine_number;
    	this.chassis_number = chassis_number;
    	this.engine_size = engine_size;
    	this.fuel_type = fuel_type;
    	this.drivetrain = drivetrain;
    	this.seller = seller;
    }


	public int getid() {
		return id;
	}


	public void setid(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getColor() {
		return color;
	}


	public void setColor(String color) {
		this.color = color;
	}


	public String getEngine_number() {
		return engine_number;
	}


	public void setEngine_number(String engine_number) {
		this.engine_number = engine_number;
	}


	public String getChassis_number() {
		return chassis_number;
	}


	public void setChassis_number(String chassis_number) {
		this.chassis_number = chassis_number;
	}


	public String getEngine_size() {
		return engine_size;
	}


	public void setEngine_size(String engine_size) {
		this.engine_size = engine_size;
	}


	public String getFuel_type() {
		return fuel_type;
	}


	public void setFuel_type(String fuel_type) {
		this.fuel_type = fuel_type;
	}


	public String getDrivetrain() {
		return drivetrain;
	}


	public void setDrivetrain(String drivetrain) {
		this.drivetrain = drivetrain;
	}


	public String getSeller() {
		return seller;
	}


	public void setSeller(String seller) {
		this.seller = seller;
	}


	public String getBuyer() {
		return buyer;
	}


	public void setBuyer(String buyer) {
		this.buyer = buyer;
	}
}
