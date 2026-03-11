package assessment.week3.task2.dao;

import java.sql.*;

public class StudentDAO {

    // ADD Student
    public void addStudent(String name, String course, int semester) {

        String insertSQL = "INSERT INTO student(name, course, semester) VALUES (?, ?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(insertSQL,
                     Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, name);
            ps.setString(2, course);
            ps.setInt(3, semester);
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            int generatedId = 0;
            if (rs.next()) {
                generatedId = rs.getInt(1);
            }

            System.out.println("Student added successfully");
            searchStudent(generatedId);

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // SEARCH Student by ID
    public void searchStudent(int id) {

        String selectSQL = "SELECT * FROM student WHERE id = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(selectSQL)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                System.out.println("ID: "       + rs.getInt("id"));
                System.out.println("Name: "     + rs.getString("name"));
                System.out.println("Course: "   + rs.getString("course"));
                System.out.println("Semester: " + rs.getInt("semester"));
            } else {
                System.out.println("Student not found");
            }

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // UPDATE Course
    public void updateCourse(int id, String newCourse) {

        if (!studentExists(id)) {
            System.out.println("Student not found");
            return;
        }

        String updateSQL = "UPDATE student SET course = ? WHERE id = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(updateSQL)) {

            ps.setString(1, newCourse);
            ps.setInt(2, id);
            ps.executeUpdate();

            System.out.println("Course updated successfully");

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // DELETE Student
    public void deleteStudent(int id) {

        if (!studentExists(id)) {
            System.out.println("Student not found");
            return;
        }

        String deleteSQL = "DELETE FROM student WHERE id = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(deleteSQL)) {

            ps.setInt(1, id);
            ps.executeUpdate();

            System.out.println("Student deleted successfully");

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Helper: check if student exists
    private boolean studentExists(int id) {

        String selectSQL = "SELECT * FROM student WHERE id = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(selectSQL)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            return rs.next();

        } catch (SQLException e) {
            return false;
        }
    }
}