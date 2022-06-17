package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
@ComponentScan
public class CarAuctionSystem1Application {

	
	@Autowired
	private JdbcTemplate jdbc;
	
	public static void main(String[] args){
		SpringApplication.run(CarAuctionSystem1Application.class, args);
	}

//	@Override implements CommandLineRunner
//	public void run(String... args) throws Exception {
//		// TODO Auto-generated method stub
//		String sql = "INSERT INTO users (Name,Email_Address,Password,Phone_Number,Cnic,Type) VALUES (?,?,?,?,?,?)";
//		int result = jdbctemplate.update(sql,"Hashim1","1hashimqh@gmail.com","1Test123","+92 332 474 9292","35555-5555555-6","Buyer");
//		if (result > 0) {
//			System.out.println("A new user has been inserted");
//		}
//	}

}
