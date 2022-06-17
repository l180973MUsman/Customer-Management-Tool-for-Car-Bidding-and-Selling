package com.example.demo.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Auction;

@Repository 
public class jdbcAuctionRepository implements AuctionRepository{
	@Autowired
    private JdbcTemplate db;
		
	@Override
	public int save(Auction auction) {
		// TODO Auto-generated method stub
		return db.update(
				"Insert into auction (Vehicle_ID, User_ID, Min_Bid, Buy_Out, Delivery, Date_Ending) values (?,?,?,?,?,?)",
				auction.getVehicle_id(),auction.getUser_id(),
				auction.getMin_bid(),auction.getBuy_out(),
				auction.isDelivery(), auction.getDate_ending());
	}



	@Override
	public List<Auction> findBySeller(int seller) {
		// TODO Auto-generated method stub
		return db.query("Select * from Auction where User_ID=?",
                BeanPropertyRowMapper.newInstance(Auction.class), seller);
	}

	@Override
	public List<Auction> findAll() {
		// TODO Auto-generated method stub
		return db.query("Select * from Auction",
                BeanPropertyRowMapper.newInstance(Auction.class));
	}

}
