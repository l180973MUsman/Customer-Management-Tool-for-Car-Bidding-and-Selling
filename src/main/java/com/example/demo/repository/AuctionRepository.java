package com.example.demo.repository;

import java.util.List;

import com.example.demo.model.Auction;

public interface AuctionRepository {
    int save(Auction auction);
    List<Auction> findAll();
    List<Auction> findAllActive();
    List<Auction> findBySeller(int seller);
    int endAuction (int auction);
    int soldAuction (int auction);
    int remove(int auction);
//    List<Auction> findByBuyer(String buyer);
}
