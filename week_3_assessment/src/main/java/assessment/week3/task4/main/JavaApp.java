package assessment.week3.task4.main;

import assessment.week3.task4.entity.MemberDAO;
import java.util.Scanner;

public class JavaApp {

    public static void exec() {

        MemberDAO dao = new MemberDAO();
        Scanner sc = new Scanner(System.in);

        System.out.println("Choose operation:");
        System.out.println("1. Add Member with Workout");
        System.out.println("2. Search Member by ID");
        System.out.println("3. Update Workout Duration");
        System.out.println("4. Delete Member");
        System.out.print("Enter choice: ");

        int choice = sc.nextInt();
        sc.nextLine();

        switch (choice) {

            case 1:
                System.out.print("Enter name membershipType exerciseName duration workoutDate: ");
                String line      = sc.nextLine().trim();
                String[] parts   = line.split(" ");
                String name           = parts[0];
                String membershipType = parts[1];
                String exerciseName   = parts[2];
                int duration          = Integer.parseInt(parts[3]);
                String workoutDate    = parts[4];
                dao.addMember(name, membershipType, exerciseName, duration, workoutDate);
                break;

            case 2:
                System.out.print("Enter Member ID: ");
                int searchId = sc.nextInt();
                dao.searchMember(searchId);
                break;

            case 3:
                System.out.print("Enter memberId workoutId newDuration: ");
                int memberId   = sc.nextInt();
                int workoutId  = sc.nextInt();
                int newDuration = sc.nextInt();
                dao.updateWorkoutDuration(memberId, workoutId, newDuration);
                break;

            case 4:
                System.out.print("Enter Member ID to delete: ");
                int deleteId = sc.nextInt();
                dao.deleteMember(deleteId);
                break;

            default:
                System.out.println("Invalid choice");
        }

        dao.close();
        sc.close();
    }
}