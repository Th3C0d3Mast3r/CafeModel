package CafeModel;

import java.sql.*;
import java.util.Scanner;

public class Billing {
    static Scanner obj = new Scanner(System.in);
    static Connection con;
    static String art1 = "  ######         ##        # ######## #   # ######## #\n" +
            " ##    ##       #  #       #              #\n" +
            "##             #    #      #              #\n" +
            "##            #      #     # ####### #    # #### #\n" +
            "##           # ###### #    #              #\n" +
            " ##    ##   #          #   #              #\n" +
            "  ######   #            #  #              # ######## #";

    static {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/RestaurantDB", "root", "qwertyuiop1234");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void payBill(String name, String orderType) throws SQLException {
        double totalBill = billCalculation();
        if (totalBill > 0) {
            System.out.println("\n\n\n\n\n");
            displayBill(totalBill);
        }

        System.out.println("\n");
        System.out.print("How Do You Wish to Pay: ");
        String paymentMethod = obj.nextLine();
        System.out.println("\nKindly Pay the Bill via " + paymentMethod + " Mode.\nDo Visit Again :)");
        addToDailyOrders(name, orderType, totalBill);
        deleteCustomerOrderTable();
        System.exit(0);
    }

    private static void displayBill(double totalBills) throws SQLException {
        String query = "SELECT dish, qty, cost FROM customerOrder";
        try (Statement smt = con.createStatement(); ResultSet rs = smt.executeQuery(query)) {
            System.out.println(art1);
            System.out.println("-------------------------------------------------");
            System.out.printf("%-30s%-10s%-10s\n", "Dish", "Qty", "Cost");
            System.out.println("-------------------------------------------------");
            while (rs.next()) {
                String dish = rs.getString("dish");
                int quant = rs.getInt("qty");
                double cost = rs.getDouble("cost");

                System.out.printf("%-30s%-10d%-10.2f%n", dish, quant, cost);
            }
            System.out.println("-------------------------------------------------");
            System.out.println("TOTAL PAYABLE BILL: Rs." + totalBills);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static double billCalculation() throws SQLException {
        double d = 0;
        String query = "SELECT SUM(cost) FROM customerOrder";
        try (Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            if (rs.next()) {
                d = rs.getDouble(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return d;
    }

    private static void addToDailyOrders(String name, String orderType, double totalAmt) throws SQLException {
        String query = "INSERT INTO dailyOrders(orderType, customerName, totalBill) VALUES(?, ?, ?)";
        try (PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setString(1, orderType);
            pstmt.setString(2, name);
            pstmt.setDouble(3, totalAmt);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void deleteCustomerOrderTable() {
        String query = "DROP TABLE IF EXISTS customerOrder";
        try (Statement stmt = con.createStatement()) {
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
