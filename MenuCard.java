package CafeModel;

import java.sql.*;
import java.util.Scanner;

public class MenuCard {
    static Scanner obj = new Scanner(System.in);
    static Connection con;

    static {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/RestaurantDB", "root", "qwertyuiop1234");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void viewMenu() //just displays the menu card
    {
        String query = "SELECT Dish, Price FROM Menu";
        try (Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            System.out.println("Menu Card:");
            System.out.println("-------------------------------------------------");
            System.out.printf("%-30s%-10s%n", "Dish", "Price");
            System.out.println("-------------------------------------------------");
            while (rs.next()) {
                String dish = rs.getString("Dish");
                double price = rs.getDouble("Price");
                System.out.printf("%-30s%-10.2f%n", dish, price);
            }
            System.out.println("-------------------------------------------------");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
