package CafeModel;

import java.sql.*;
import java.util.*;

public class DineInOrder {
    static Scanner obj = new Scanner(System.in);
    static Connection con;

    static {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/RestaurantDB", "root", "qwertyuiop1234");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean dineIn() throws SQLException {
        System.out.print("Confirm Dine In: ");
        String confirmation = obj.nextLine();
        if (ConfirmChoice.confirmationChecker(confirmation))
        {
            String orderType="DINE IN";

            System.out.print("Your Name: ");
            String custName=obj.nextLine();

            MenuCard.viewMenu();
            PlaceOrder.makeTables(custName, orderType);
            return true; // Confirmation successful
        } else {
            System.out.println("Dine In not confirmed.");
            return false; // Confirmation failed
        }
    }
}
