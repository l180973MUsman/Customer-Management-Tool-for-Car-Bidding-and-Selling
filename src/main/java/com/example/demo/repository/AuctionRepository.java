package com.example.demo.repository;

import java.util.List;

import com.example.demo.model.Auction;

public interface AuctionRepository {
    int save(Auction auction);
    List<Auction> findAll();
    List<Auction> findBySeller(int seller);
//    List<Auction> findByBuyer(String buyer);
}
