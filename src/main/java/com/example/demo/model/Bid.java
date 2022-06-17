package com.example.demo.model;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Bid {

	private int id;
	private int user_id;
	private int auction_id;
	private double amount;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime bid_date;
	private boolean isinvalid;
	
	Bid(){}
	
	public Bid (int user_id, int auction_id, double amount){
		this.user_id = user_id;
		this.auction_id = auction_id;
		this.amount = amount;
		this.isinvalid = false;
    }
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getAuction_id() {
		return auction_id;
	}
	public void setAuction_id(int auction_id) {
		this.auction_id = auction_id;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}

	public boolean isIsinvalid() {
		return isinvalid;
	}

	public void setIsinvalid(boolean isinvalid) {
		this.isinvalid = isinvalid;
	}

	public LocalDateTime getBid_date() {
		return bid_date;
	}

	public void setBid_date(LocalDateTime bid_date) {
		this.bid_date = bid_date;
	}
}
