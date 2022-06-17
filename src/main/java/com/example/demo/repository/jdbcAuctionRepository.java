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



	@Override
	public int endAuction(int auction) {
		// TODO Auto-generated method stub
		return db.update("Update Auction set Status = ? where ID=?", false, auction);
	}



	@Override
	public int soldAuction(int auction) {
		// TODO Auto-generated method stub
		int active = db.queryForObject("Select Status From Auction where ID=?", Integer.class, auction);
		int winner = db.queryForObject("Select Currentwinner_ID From Auction where ID=?", Integer.class, auction);
		int vehicle = db.queryForObject("Select Vehicle_ID From Auction where ID=?", Integer.class, auction);
		db.update("Update Auction set Finalwinner_ID = ? where ID=?", winner, auction);
		if (active == 1) {
			db.update("Update Auction set Status = ? where ID=?", false, auction);
			db.update("Update Vehicle set Buyer = ? where ID=?", winner, vehicle);
		}
		else {
			return 0;
		}
		
		return db.update("Update Auction set Sold = ? where ID=?", true, auction);
	}



	@Override
	public List<Auction> findAllActive() {
		// TODO Auto-generated method stub
		return db.query("Select * from Auction where Status = ?",
                BeanPropertyRowMapper.newInstance(Auction.class), true);
	}



	@Override
	public int remove(int auction) {
		// TODO Auto-generated method stub
		return db.update("delete from Auction where ID=?", auction);
	}

}
