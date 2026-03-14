package jdbc.student;



import java.sql.*;
import java.util.Scanner;

public class StudentDAO {

public static void addStudent(String name,String course,int semester){

try {

Connection con = DBConnection.getConnection();

PreparedStatement ps =
con.prepareStatement("insert into student(name,course,semester) values(?,?,?)");

ps.setString(1,name);
ps.setString(2,course);
ps.setInt(3,semester);

ps.executeUpdate();

System.out.println("Student added successfully");

} catch(Exception e){
e.printStackTrace();
}

}

public static void searchStudent(int id){

try {

Connection con = DBConnection.getConnection();

PreparedStatement ps =
con.prepareStatement("select * from student where id=?");

ps.setInt(1,id);

ResultSet rs = ps.executeQuery();

while(rs.next()){

System.out.println("ID: "+rs.getInt("id"));
System.out.println("Name: "+rs.getString("name"));
System.out.println("Course: "+rs.getString("course"));
System.out.println("Semester: "+rs.getInt("semester"));

}

} catch(Exception e){
e.printStackTrace();
}

}

public static void updateCourse(int id,String course){

try {

Connection con = DBConnection.getConnection();

PreparedStatement ps =
con.prepareStatement("UPDATE student SET course=? WHERE id=?");

ps.setString(1,course);
ps.setInt(2,id);

ps.executeUpdate();

System.out.println("Course updated successfully");

} catch(Exception e){
e.printStackTrace();
}

}

public static void deleteStudent(int id){

try {

Connection con = DBConnection.getConnection();

PreparedStatement ps =
con.prepareStatement("delete from student where id=?");

ps.setInt(1,id);

ps.executeUpdate();

System.out.println("Student deleted successfully");

} catch(Exception e){
e.printStackTrace();
}

}

}