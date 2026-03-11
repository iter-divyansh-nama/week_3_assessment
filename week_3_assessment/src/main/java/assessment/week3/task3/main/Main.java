package assessment.week3.task3.main;

import java.sql.*;
import java.util.Scanner;

public class Main {

    static String url = "jdbc:mysql://localhost:3306/assessment_week3_jdbc";
    static String user = "mohit";
    static String password = "1234";

    public static void main(String[] args) throws Exception {

        Connection con = DriverManager.getConnection(url, user, password);
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter title:");
        String title = sc.nextLine();

        System.out.println("Enter author:");
        String author = sc.nextLine();

        System.out.println("Enter price:");
        double price = sc.nextDouble();

        if (price <= 0 || title.isEmpty() || author.isEmpty()) {
            System.out.println("Invalid data");
            return;
        }

        String insert = "INSERT INTO book(title,author,price) VALUES(?,?,?)";
        PreparedStatement ps = con.prepareStatement(insert);
        ps.setString(1, title);
        ps.setString(2, author);
        ps.setDouble(3, price);

        ps.executeUpdate();
        System.out.println("Book added successfully");

        System.out.println("Enter id to search:");
        int id = sc.nextInt();

        String search = "SELECT * FROM book WHERE id=?";
        PreparedStatement ps2 = con.prepareStatement(search);
        ps2.setInt(1, id);

        ResultSet rs = ps2.executeQuery();

        if (rs.next()) {
            System.out.println("ID: " + rs.getInt("id"));
            System.out.println("Title: " + rs.getString("title"));
            System.out.println("Author: " + rs.getString("author"));
            System.out.println("Price: " + rs.getDouble("price"));
        } else {
            System.out.println("Book not found");
        }

        System.out.println("Enter id and new price:");
        int uid = sc.nextInt();
        double newPrice = sc.nextDouble();

        String update = "UPDATE book SET price=? WHERE id=?";
        PreparedStatement ps3 = con.prepareStatement(update);
        ps3.setDouble(1, newPrice);
        ps3.setInt(2, uid);

        int rows = ps3.executeUpdate();

        if (rows > 0)
            System.out.println("Book price updated successfully");
        else
            System.out.println("Book not found");

        System.out.println("Enter id to delete:");
        int did = sc.nextInt();

        String delete = "DELETE FROM book WHERE id=?";
        PreparedStatement ps4 = con.prepareStatement(delete);
        ps4.setInt(1, did);

        int drows = ps4.executeUpdate();

        if (drows > 0)
            System.out.println("Book deleted successfully");
        else
            System.out.println("Book not found");

        con.close();
        sc.close();
    }
}