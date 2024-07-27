package CafeModel;

import java.sql.*;
import java.util.Scanner;

public class PlaceOrder {
    static Scanner obj = new Scanner(System.in);
    static Connection con;

    static {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/RestaurantDB", "root", "qwertyuiop1234");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void makeTables(String name, String type) throws SQLException {
        createTable();
        placeOrder(name, type);
    }

    private static void placeOrder(String customerName, String OrderType) throws SQLException {
        System.out.print("Your Dish: ");
        String dish = obj.nextLine();
        if (dishExists(dish)) {
            System.out.print("Qty: ");
            int quantity = obj.nextInt();
            obj.nextLine(); // Consume the newline left-over

            double price = getDishPrice(dish);
            double cost = price * quantity;

            insertOrder(dish, quantity, cost);

            System.out.print("Continue Ordering: ");
            String continues=obj.nextLine();
            if(ConfirmChoice.confirmationChecker(continues))
            {
                placeOrder(customerName, OrderType);
            }
            else{
                Billing.payBill(customerName, OrderType);
            }
        }
        else {
            System.out.println("Dish not found in the database. Please enter a valid dish.");
            placeOrder(customerName, OrderType);
        }
    }

    private static void createTable() {
        String query = "CREATE TABLE IF NOT EXISTS customerOrder (" +
                "dish VARCHAR(30), " +
                "qty INT, " +
                "cost DOUBLE)";
        try (Statement stmt = con.createStatement()) {
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static boolean dishExists(String dish) {
        String query = "SELECT COUNT(*) FROM Menu WHERE Dish = ?";
        try (PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setString(1, dish);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1) > 0;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    private static double getDishPrice(String dish) {
        String query = "SELECT Price FROM Menu WHERE Dish = ?";
        try (PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setString(1, dish);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getDouble(1);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    private static void insertOrder(String dish, int quantity, double cost) {
        String query = "INSERT INTO customerOrder (dish, qty, cost) VALUES (?, ?, ?)";
        try (PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setString(1, dish);
            pstmt.setInt(2, quantity);
            pstmt.setDouble(3, cost);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
