package assessment.week3.task1.dao;

import java.sql.*;

public class MemberDAO {

    // ADD Member
    public void addMember(String name, String membershipType, double fee) {

        String insertSQL = "INSERT INTO member(name, membershipType, fee) VALUES (?, ?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(insertSQL,
                     Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, name);
            ps.setString(2, membershipType);
            ps.setDouble(3, fee);
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            int generatedId = 0;
            if (rs.next()) {
                generatedId = rs.getInt(1);
            }

            System.out.println("Member added successfully");
            searchMember(generatedId);

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // SEARCH Member by ID
    public void searchMember(int id) {

        String selectSQL = "SELECT * FROM member WHERE id = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(selectSQL)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                System.out.println("ID: "              + rs.getInt("id"));
                System.out.println("Name: "            + rs.getString("name"));
                System.out.println("Membership Type: " + rs.getString("membershipType"));
                System.out.println("Fee: "             + (int) rs.getDouble("fee"));
            } else {
                System.out.println("Member not found");
            }

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // UPDATE Membership Fee
    public void updateFee(int id, double newFee) {

        if (!memberExists(id)) {
            System.out.println("Member not found");
            return;
        }

        String updateSQL = "UPDATE member SET fee = ? WHERE id = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(updateSQL)) {

            ps.setDouble(1, newFee);
            ps.setInt(2, id);
            ps.executeUpdate();

            System.out.println("Membership fee updated successfully");

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // DELETE Member
    public void deleteMember(int id) {

        if (!memberExists(id)) {
            System.out.println("Member not found");
            return;
        }

        String deleteSQL = "DELETE FROM member WHERE id = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(deleteSQL)) {

            ps.setInt(1, id);
            ps.executeUpdate();

            System.out.println("Member deleted successfully");

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Helper: check if member exists
    private boolean memberExists(int id) {

        String selectSQL = "SELECT * FROM member WHERE id = ?";

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