package CafeModel;

import java.sql.*;
import java.util.*;

public class TakeAwayOrder {
    static Scanner obj = new Scanner(System.in);
    static Connection con;

    static {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/RestaurantDB", "root", "qwertyuiop1234");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean takeAway() throws SQLException {
        System.out.print("Confirm Takeaway: ");
        String confirmation = obj.nextLine();
        if (ConfirmChoice.confirmationChecker(confirmation)) {
            residentialDetails();
            return true; // Confirmation successful
        } else {
            System.out.println("Takeaway not confirmed.");
            return false; // Confirmation failed
        }
    }

    private static void residentialDetails() throws SQLException {
        String orderType="TAKEAWAY";

        System.out.print("Enter Your Name: ");
        String custName=obj.nextLine();

        System.out.print("Enter Phone Number: ");
        String custNo=obj.nextLine();

        System.out.print("Enter Address To Deliver To: ");
        String custAdd=obj.nextLine();

        System.out.println("Confirm Details (re-check carefully): ");
        String confirmations=obj.nextLine();

        if(ConfirmChoice.confirmationChecker(confirmations))
        {
            MenuCard.viewMenu();
            PlaceOrder.makeTables(custName, orderType);
        }
        else
        {
            residentialDetails();
        }
    }
}
