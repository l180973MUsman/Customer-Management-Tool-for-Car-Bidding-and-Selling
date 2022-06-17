CREATE DATABASE auction_site;
drop DATABASE auction_site;
USE auction_site;

CREATE TABLE users(
ID int PRIMARY KEY AUTO_INCREMENT,
Name varchar(255) NOT NULL,
Email_Address varchar(255) NOT NULL UNIQUE,
Password varchar(255) NOT NULL,
Phone_Number varchar(255),
Cnic varchar(15) NOT NULL UNIQUE,
Type varchar(255) NOT NULL,
Date_of_Joining datetime default now()
);

CREATE TABLE vehicle(
ID int PRIMARY KEY AUTO_INCREMENT,
Name varchar(255) NOT NULL,
Color varchar(255) NOT NULL,
Engine_Number varchar(255) NOT NULL UNIQUE,
Chassis_Number varchar(255) NOT NULL UNIQUE,
Engine_Size varchar(4) NOT NULL,
Fuel_Type varchar(25) NOT NULL,
Drivetrain varchar(3) NOT NULL,
Seller int NOT NULL,
Buyer int,
FOREIGN KEY (Seller) REFERENCES users(id) ON DELETE CASCADE,
FOREIGN KEY (Buyer) REFERENCES users(id) ON DELETE CASCADE
);

CREATE TABLE auction(
ID int PRIMARY KEY AUTO_INCREMENT,
Status bool default True,
Vehicle_ID int,
User_ID int,
Currentwinner_ID int,
Finalwinner_ID int,
Min_Bid double NOT NULL,
Buy_Out double NOT NULL,
Current_bid double DEFAULT 0.00,
Delivery bool,
Sold bool default False,
Date_Added datetime default now(),
Date_Ending datetime,
FOREIGN KEY (Vehicle_ID) REFERENCES vehicle(ID) ON DELETE CASCADE,
FOREIGN KEY (User_ID) REFERENCES users(id) ON DELETE CASCADE,
FOREIGN KEY (Currentwinner_ID) REFERENCES users(id) ON DELETE CASCADE,
FOREIGN KEY (Finalwinner_ID) REFERENCES users(id) ON DELETE CASCADE
);


CREATE TABLE bid(
ID int PRIMARY KEY AUTO_INCREMENT,
User_ID int NOT NULL,
Auction_ID int NOT NULL,
Amount double NOT NULL,
Bid_Date datetime default now(),
IsInvalid boolean default False,
FOREIGN KEY (User_ID) REFERENCES users(id) ON DELETE CASCADE,
FOREIGN KEY (Auction_ID) REFERENCES auction(ID) ON DELETE CASCADE
);


drop table users;
drop table vehicle;
drop table auction;
drop table bid;

INSERT INTO users (Name,Email_Address,Password,Phone_Number,Cnic,Type) VALUES ("Hashim","hashimqh@gmail.com","Test123","+92 332 474 9292","35555-5555555-5","Buyer");

SELECT * from users;

INSERT INTO vehicle (Name,Color,Engine_Number,Chassis_Number,Engine_Size,Fuel_Type,Drivetrain,Seller) VALUES ("Honda Civic","White","1235","1235","1999","Petrol","FWD","usman@gmail.com");
UPDATE vehicle SET Buyer = 'usman@gmail.com' WHERE Seller = 'usman@gmail.com';

INSERT INTO auction (Vehicle_ID, User_ID, Min_Bid, Buy_Out, Delivery, Date_Ending) VALUES (1, 19, 250.00, 700.00, false, STR_TO_DATE('23-12-2022 00:00:00','%d-%m-%Y %H:%i:%s'));
SELECT * from vehicle;
SELECT * from auction;
SELECT * from bid;



