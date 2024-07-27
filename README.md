# Restaurant Management System: Cafe Model

## Description

This project is a simple Restaurant Management System implemented in Java. It allows users to place orders either for DINE-IN or TAKEAWAY, view the menu, and process billing. The system uses MySQL for database management and supports functionalities like menu display, order placement, and billing.

## Features

- **View Menu**: Display available dishes and their prices.
- **Order Placement**: Allows users to place orders for dine-in or takeaway.
- **Billing**: Calculates the total bill, displays the order summary, and allows payment.
- **Database Management**: Utilizes MySQL to manage menu items and customer orders.
- **Daily Orders Tracking**: Records daily orders with type, customer name, and total bill.

## Getting Started

### Prerequisites

- Java Development Kit (JDK) 8 or higher
- MySQL Database
- MySQL Connector/J

### Installation

1. **Clone the Repository**

   ```bash
   git clone https://github.com/yourusername/your-repository-name.git
   cd your-repository-name
   ```

2. **Setup the MySQL Database**

   - Create a MySQL database and tables using the SQL queries provided below.

3. **Configure Database Connection**

   - Update the `DriverManager.getConnection` method in your Java code with your MySQL database credentials.

4. **Build and Run**

   - Compile the Java files:
   
     ```bash
     javac -d bin src/CafeModel/*.java
     ```
   
   - Run the main class:

     ```bash
     java -cp bin CafeModel.Main
     ```

## Usage

1. **Run the Application**

   Execute the main class to start the application.

   ```bash
   java CafeModel.Main
   ```

2. **Interact with the System**

   - Choose between `DINE IN` and `TAKEAWAY`.
   - Follow the prompts to enter order details.
   - Confirm order details and proceed to payment.
   - The system will display the bill and process payment accordingly.

## Code Overview

- **Main.java**: Entry point of the application. Handles user interaction for order type selection.
- **MenuCard.java**: Manages the display of the menu.
- **DineInOrder.java**: Handles dine-in orders and customer details.
- **TakeAwayOrder.java**: Handles takeaway orders and customer details.
- **PlaceOrder.java**: Manages the order placement and table creation.
- **Billing.java**: Handles billing, payment, and database updates.
- **ConfirmChoice.java**: Utility class for confirmation checks.

## SQL Queries

### Database and Table Creation

```sql
CREATE DATABASE IF NOT EXISTS RestaurantDB;
USE RestaurantDB;

CREATE TABLE IF NOT EXISTS dailyOrders (
    orderType ENUM('DINE IN', 'TAKEAWAY') NOT NULL,
    customerName VARCHAR(30),
    tableNo VARCHAR(2),
    orderNo INT,
    totalBill DOUBLE
);

CREATE TABLE IF NOT EXISTS Menu (
    Dish VARCHAR(30),
    Price DOUBLE
);
```

### Inserting Menu Items

```sql
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
```

### Viewing and Formatting Tables

```sql
-- Viewing the tables
SELECT * FROM Menu;
SELECT * FROM dailyOrders; -- This shows the daily orders
SELECT * FROM customerOrder; -- This table is created and deleted dynamically

-- Formatting the tables to blank
SET SQL_SAFE_UPDATES = 0;
DELETE FROM dailyOrders;
```

## Contributing

Contributions are welcome! Please submit a pull request or open an issue for any suggestions or improvements.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Acknowledgements

- [Java Documentation](https://docs.oracle.com/en/java/)
- [MySQL Documentation](https://dev.mysql.com/doc/)
- A big thanks to **ChatGPT** for assisting with writing this README file and making it comprehensive and professional.

---
