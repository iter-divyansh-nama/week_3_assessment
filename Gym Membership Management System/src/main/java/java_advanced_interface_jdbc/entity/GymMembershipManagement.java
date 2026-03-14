package java_advanced_interface_jdbc.entity;

public class GymMembershipManagement {

    public void addMember(String name, String membershipType, double fee) {

        System.out.println("\n===== Member Details =====");
        System.out.println("Name: " + name);
        System.out.println("Membership Type: " + membershipType);
        System.out.println("Fee: " + fee);

        System.out.println("\nMember added successfully!");
    }
}