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

import com.example.demo.model.Auction;
import com.example.demo.repository.AuctionRepository;

@RestController
public class AuctionController {
	@Autowired
    AuctionRepository auctionRepository;
	
    @GetMapping(value="/getauctions")
    public ResponseEntity<List<Auction>> getAllItems() {
        //Getting the ID of the logged in user.
        System.out.println("GET ALL Auction");
        return new ResponseEntity<>(auctionRepository.findAll(), HttpStatus.OK);
    }
    
    @GetMapping(value="/getactiveauctions")
    public ResponseEntity<List<Auction>> getActiveItems() {
        //Getting the ID of the logged in user.
        System.out.println("GET Active Auction");
        return new ResponseEntity<>(auctionRepository.findAllActive(), HttpStatus.OK);
    }
    
    @GetMapping(value="/sellerauction/{sellerId}")
    public ResponseEntity<List<Auction>> getSellerAuction(@PathVariable("sellerId") int sellerId){
        System.out.println(sellerId);
        List<Auction> response = null;
        try{
        	response = auctionRepository.findBySeller(sellerId);
        }
        catch(Exception e){
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
        
    }
    
    @PostMapping(value="/addauction")
    public ResponseEntity<Integer> addItem(@RequestBody Auction auction){        
        int response = 0;
        Auction temp = new Auction(auction.getVehicle_id(), auction.getUser_id(), auction.getMin_bid(), auction.getBuy_out(), auction.isDelivery(), auction.getDate_ending());
        try{
        	response = auctionRepository.save(temp);
        }
        catch(Exception e){
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    
    @PostMapping(value="/endauction/{auctionId}")
    public ResponseEntity<Integer> endItem(@PathVariable("auctionId") int auctionId){        
        int response = 0;
        try{
        	response = auctionRepository.endAuction(auctionId);
        }
        catch(Exception e){
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    
    @PostMapping(value="/soldauction/{auctionId}")
    public ResponseEntity<Integer> soldItem(@PathVariable("auctionId") int auctionId){        
        int response = 0;
        try{
        	response = auctionRepository.soldAuction(auctionId);
        }
        catch(Exception e){
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    
    @PostMapping(value = "/removeAuction/{auctionId}")
    public ResponseEntity<Integer> removeItem(@PathVariable("auctionId") int auctionId) {
        System.out.println(auctionId);
        int response = 0;
        try {
            response = auctionRepository.remove(auctionId);
        } catch (Exception e) {
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
