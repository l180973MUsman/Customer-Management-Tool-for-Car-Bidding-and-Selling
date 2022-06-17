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

}
