package CafeModel;

import java.sql.*;
import java.util.*;

public class Main {
    static Scanner obj = new Scanner(System.in);
    static Connection con;
    static int attemptCount = 0;
    static final int MAX_ATTEMPTS = 3;

    static {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/RestaurantDB", "root", "qwertyuiop1234");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws SQLException {
        run();
    }

    private static void run() throws SQLException {
        System.out.println("\n\n\t\tWELCOME TO 'THE CAFE'\n");

        while (attemptCount < MAX_ATTEMPTS) {
            System.out.println("How Would You Like to Order\n1) DINE IN\n2) TAKEAWAY");
            String reply = obj.nextLine();

            if (reply.equalsIgnoreCase("dine in") || reply.contains("dine") || reply.charAt(0) == 'd' || reply.charAt(0) == 'D'|| reply.equals("1"))
            {
                boolean confirmed = DineInOrder.dineIn();
                if (confirmed)
                {
                    return; // Exit after successful selection
                }
            }
            else if (reply.equalsIgnoreCase("take away") || reply.contains("take") || reply.charAt(0) == 't' || reply.charAt(0) == 'T' || reply.equals("2"))
            {
                boolean confirmed = TakeAwayOrder.takeAway();
                if (confirmed)
                {
                    return; // Exit after successful selection
                }
            }
            else
            {
                System.out.println("Invalid choice. Please try again.");
            }

            attemptCount++;
            if (attemptCount >= MAX_ATTEMPTS) {
                System.out.println("TOO MANY OPTION SWITCH. THANK YOU FOR VISITING CAFE\nHOPING TO SEE YOU AGAIN SOON :)");
                System.exit(0);
            }
        }
    }
}
