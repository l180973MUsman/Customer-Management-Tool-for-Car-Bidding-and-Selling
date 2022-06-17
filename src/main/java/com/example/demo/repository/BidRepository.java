package com.example.demo.repository;

import java.util.List;

import com.example.demo.model.Bid;

public interface BidRepository {
    int save(Bid bid);
    List<Bid> findAll();
    List<Bid> findByBuyer(int buyer);
    List<Bid> findByAuction(int auction);
    int remove(int bid);
}
