package com.example.demo.model;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Auction {

	private int id;
    private Boolean status;
    private int vehicle_id;
    private int user_id;
    private int currentwinner_id;
    private int finalwinner_id;
    private double min_bid;
    private double buy_out;
    private double current_bid;
    private boolean delivery;
    private boolean sold;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime date_added;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime date_ending;
    
    Auction(){
    }
    
    public Auction(int vehicle_id, int user_id, double min_bid, double buy_out, boolean delivery, LocalDateTime date_ending){
    	this.status = true;
    	this.vehicle_id = vehicle_id;
    	this.user_id = user_id;
    	this.min_bid = min_bid;
    	this.buy_out = buy_out;
    	this.delivery = delivery;
    	this.date_ending = date_ending;
    	this.sold = false;
    }
    
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	public int getVehicle_id() {
		return vehicle_id;
	}
	public void setVehicle_id(int vehicle_id) {
		this.vehicle_id = vehicle_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public double getMin_bid() {
		return min_bid;
	}
	public void setMin_bid(double min_bid) {
		this.min_bid = min_bid;
	}
	public double getBuy_out() {
		return buy_out;
	}
	public void setBuy_out(double buy_out) {
		this.buy_out = buy_out;
	}
	public double getCurrent_bid() {
		return current_bid;
	}
	public void setCurrent_bid(double current_bid) {
		this.current_bid = current_bid;
	}
	public boolean isDelivery() {
		return delivery;
	}
	public void setDelivery(boolean delivery) {
		this.delivery = delivery;
	}
	public boolean isSold() {
		return sold;
	}
	public void setSold(boolean sold) {
		this.sold = sold;
	}
	public LocalDateTime getDate_added() {
		return date_added;
	}
	public void setDate_added(LocalDateTime date_added) {
		this.date_added = date_added;
	}
	public LocalDateTime getDate_ending() {
		return date_ending;
	}
	public void setDate_ending(LocalDateTime date_ending) {
		this.date_ending = date_ending;
	}

	public int getCurrentwinner_id() {
		return currentwinner_id;
	}

	public void setCurrentwinner_id(int currentwinner_id) {
		this.currentwinner_id = currentwinner_id;
	}

	public int getFinalwinner_id() {
		return finalwinner_id;
	}

	public void setFinalwinner_id(int finalwinner_id) {
		this.finalwinner_id = finalwinner_id;
	}
    

}
