package assessment.week3.task1.main;

import assessment.week3.task1.dao.MemberDAO;
import java.util.Scanner;

public class JavaApp {

    public static void exec() {

        MemberDAO dao = new MemberDAO();
        Scanner sc    = new Scanner(System.in);

        System.out.println("Choose operation:");
        System.out.println("1. Add Member");
        System.out.println("2. Search Member by ID");
        System.out.println("3. Update Membership Fee");
        System.out.println("4. Delete Member");
        System.out.print("Enter choice: ");

        int choice = sc.nextInt();
        sc.nextLine();

        switch (choice) {

            case 1:
                System.out.print("Enter name membershipType fee: ");
                String line    = sc.nextLine().trim();
                String[] parts = line.split(" ");
                String name           = parts[0];
                String membershipType = parts[1];
                double fee            = Double.parseDouble(parts[2]);
                dao.addMember(name, membershipType, fee);
                break;

            case 2:
                System.out.print("Enter Member ID: ");
                int searchId = sc.nextInt();
                dao.searchMember(searchId);
                break;

            case 3:
                System.out.print("Enter id newFee: ");
                int updateId  = sc.nextInt();
                double newFee = sc.nextDouble();
                dao.updateFee(updateId, newFee);
                break;

            case 4:
                System.out.print("Enter Member ID to delete: ");
                int deleteId = sc.nextInt();
                dao.deleteMember(deleteId);
                break;

            default:
                System.out.println("Invalid choice");
        }

        sc.close();
    }
}