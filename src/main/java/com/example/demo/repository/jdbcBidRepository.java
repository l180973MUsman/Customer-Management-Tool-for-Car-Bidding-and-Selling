package com.example.demo.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Bid;

@Repository
public class jdbcBidRepository implements BidRepository{
	
	@Autowired
    private JdbcTemplate db;
	
	@Override
	public int save(Bid bid) {
		// TODO Auto-generated method stub
		double minbid = db.queryForObject("Select Min_Bid From Auction where ID=?", Double.class, bid.getAuction_id());
		double currentbid = db.queryForObject("Select Current_bid From Auction where ID=?", Double.class, bid.getAuction_id());
		
		if (minbid < bid.getAmount() && currentbid < bid.getAmount()) {
			db.update("Update Auction set Current_bid = ? where ID=?", bid.getAmount(), bid.getAuction_id());
			db.update("Update Auction set Currentwinner_ID = ? where ID=?", bid.getUser_id(), bid.getAuction_id());
			db.update("Update Bid set IsInvalid = ? where Auction_ID=?", true, bid.getAuction_id());
			
		}
		else {
			return 0;
		}
		return db.update(
				"Insert into bid (User_ID, Auction_ID, Amount) values (?,?,?)",
				bid.getUser_id(),bid.getAuction_id(),bid.getAmount());
	}

	@Override
	public List<Bid> findAll() {
		// TODO Auto-generated method stub
		return db.query("Select * from Bid",
                BeanPropertyRowMapper.newInstance(Bid.class));
	}

	@Override
	public List<Bid> findByBuyer(int buyer) {
		// TODO Auto-generated method stub
		return db.query("Select * from Bid where User_ID=?",
                BeanPropertyRowMapper.newInstance(Bid.class), buyer);
	}

	@Override
	public List<Bid> findByAuction(int auction) {
		// TODO Auto-generated method stub
		return db.query("Select * from Bid where Auction_ID=?",
                BeanPropertyRowMapper.newInstance(Bid.class), auction);
	}

	@Override
	public int remove(int bid) {
		// TODO Auto-generated method stub
		return db.update("delete from Bid where ID=?", bid);
	}
	
	

}
