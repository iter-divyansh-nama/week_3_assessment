package java_advanced_interface_jdbc.main;

import java.util.Scanner;
import java_advanced_interface_jdbc.entity.GymMembershipManagement;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        GymMembershipManagement gym = new GymMembershipManagement();

        System.out.println("===== Gym Membership System =====");

        System.out.print("Enter Member Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Membership Type (Basic/Premium/VIP): ");
        String membershipType = sc.nextLine();

        System.out.print("Enter Membership Fee: ");
        double fee = sc.nextDouble();

        gym.addMember(name, membershipType, fee);

        sc.close();
    }
}