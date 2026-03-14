package jdbc.library;

import java.sql.*;

public class BookDAO {

public static void addBook(String title,String author,double price){

try{

Connection con=DBConnection.getConnection();

PreparedStatement ps=
con.prepareStatement("insert into book(title,author,price) values(?,?,?)");

ps.setString(1,title);
ps.setString(2,author);
ps.setDouble(3,price);

ps.executeUpdate();

System.out.println("Book added successfully");

}catch(Exception e){
e.printStackTrace();
}
}

public static void searchBook(int id){

try{

Connection con=DBConnection.getConnection();

PreparedStatement ps=
con.prepareStatement("select * from book where id=?");

ps.setInt(1,id);

ResultSet rs=ps.executeQuery();

while(rs.next()){

System.out.println("ID: "+rs.getInt("id"));
System.out.println("Title: "+rs.getString("title"));
System.out.println("Author: "+rs.getString("author"));
System.out.println("Price: "+rs.getDouble("price"));

}

}catch(Exception e){
e.printStackTrace();
}
}

public static void updatePrice(int id,double price){

try{

Connection con=DBConnection.getConnection();

PreparedStatement ps=
con.prepareStatement("UPDATE book SET price=? WHERE id=?");

ps.setDouble(1,price);
ps.setInt(2,id);

ps.executeUpdate();

System.out.println("Book price updated successfully");

}catch(Exception e){
e.printStackTrace();
}
}

public static void deleteBook(int id){

try{

Connection con=DBConnection.getConnection();

PreparedStatement ps=
con.prepareStatement("delete from book where id=?");

ps.setInt(1,id);

ps.executeUpdate();

System.out.println("Book deleted successfully");

}catch(Exception e){
e.printStackTrace();
}
}
}