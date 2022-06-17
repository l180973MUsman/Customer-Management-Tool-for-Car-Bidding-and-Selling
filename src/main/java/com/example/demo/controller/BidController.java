package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Bid;
import com.example.demo.repository.BidRepository;

@RestController
public class BidController {
	@Autowired
    BidRepository bidRepository;
	
    @GetMapping(value="/getbids")
    public ResponseEntity<List<Bid>> getAllItems() {
        //Getting the ID of the logged in user.
        System.out.println("GET ALL Bid");
        return new ResponseEntity<>(bidRepository.findAll(), HttpStatus.OK);
    }
    
    @GetMapping(value="/buyerbids/{buyerId}")
    public ResponseEntity<List<Bid>> getBuyerBid(@PathVariable("buyerId") int buyerId){
        System.out.println(buyerId);
        List<Bid> response = null;
        try{
        	response = bidRepository.findByBuyer(buyerId);
        }
        catch(Exception e){
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
        
    }
    
    @GetMapping(value="/auctionbids/{auctionId}")
    public ResponseEntity<List<Bid>> getAuctionBid(@PathVariable("auctionId") int auctionId){
        System.out.println(auctionId);
        List<Bid> response = null;
        try{
        	response = bidRepository.findByAuction(auctionId);
        }
        catch(Exception e){
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
        
    }
    
    @PostMapping(value="/addbid")
    public ResponseEntity<Integer> addItem(@RequestBody Bid bid){        
        int response = 0;
        Bid temp = new Bid(bid.getUser_id(), bid.getAuction_id(), bid.getAmount());
        try{
        	response = bidRepository.save(temp);
        }
        catch(Exception e){
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping(value = "/removeBid/{bidId}")
    public ResponseEntity<Integer> removeItem(@PathVariable("bidId") int bidId) {
        System.out.println(bidId);
        int response = 0;
        try {
            response = bidRepository.remove(bidId);
        } catch (Exception e) {
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
