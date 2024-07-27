create database if not exists RestaurantDB;
use RestaurantDB;

create table if not exists dailyOrders(
orderType enum("DINE IN", "TAKEAWAY")not null, /*(this makes this of only 2 inputs)*/
customerName varchar(30),
tableNo varchar(2),
orderNo int,
totalBill double	
);

create table if not exists Menu(
Dish varchar(30),
Price double
);	

/*(Adding the Menu and Dishes)*/
-- Inserting Sandwiches
INSERT INTO Menu (Dish, Price) VALUES
('Veg Sandwich', 35.00),
('Veg Toast', 45.00),
('Veg Grilled', 90.00),
('Veg Cheese Toast', 70.00),
('Veg Cheese Grill', 100.00),
('Paneer Toast', 90.00),
('Paneer Grill', 130.00),
('Paneer Cheese Toast', 100.00),
('Paneer Cheese Grill', 140.00);
-- Inserting Frankies
INSERT INTO Menu (Dish, Price) VALUES
('Veg Frankie', 50.00),
('Paneer Frankie', 60.00),
('Cheese Frankie', 70.00),
('Noodles Frankie', 60.00),
('Schezwan Frankie', 60.00),
('Mix Frankie', 90.00);
-- Inserting Rolls
INSERT INTO Menu (Dish, Price) VALUES
('Veg Roll', 55.00),
('Paneer Roll', 75.00),
('Cheese Roll', 65.00),
('Mushroom Roll', 85.00);
-- Inserting Momos
INSERT INTO Menu (Dish, Price) VALUES
('Steamed Momos', 70.00),
('Fried Momos', 80.00),
('Paneer Momos', 90.00),
('Cheese Momos', 100.00);
-- Inserting Mumbai Snacks
INSERT INTO Menu (Dish, Price) VALUES
('Vada Pav', 17.00),
('Samosa Pav', 18.00),
('Bhajiya Pav', 20.00),
('Cutlet', 25.00),
('Kachori', 17.00),
('Paneer Bite', 40.00);
-- Inserting Beverages - Coffees
INSERT INTO Menu (Dish, Price) VALUES
('Espresso', 90.00),
('Cappuccino', 100.00),
('Latte', 110.00),
('Mocha', 115.00);

-- Inserting Beverages - Chai
INSERT INTO Menu (Dish, Price) VALUES
('Chai', 20.00),
('Cutting Chai', 10.00),
('Special Chai', 30.00);


-- VIEWING THE TABLES
select * from Menu;
select * from dailyOrders; -- this is what will show the daily ka khaata
select * from customerOrder; -- this is created in the code, and deleted itself there



-- FORMATTING THE TABLE[S] TO BLANK
set SQL_SAFE_UPDATES=0;
delete from dailyOrders;