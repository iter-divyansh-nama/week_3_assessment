package assessment.week3.task2.main;

import assessment.week3.task2.dao.StudentDAO;
import java.util.Scanner;

public class JavaApp {

    public static void exec() {

        StudentDAO dao = new StudentDAO();
        Scanner sc     = new Scanner(System.in);

        System.out.println("Choose operation:");
        System.out.println("1. Add Student");
        System.out.println("2. Search Student by ID");
        System.out.println("3. Update Course");
        System.out.println("4. Delete Student");
        System.out.print("Enter choice: ");

        int choice = sc.nextInt();
        sc.nextLine();

        switch (choice) {

            case 1:
                System.out.print("Enter name course semester: ");
                String line    = sc.nextLine().trim();
                String[] parts = line.split(" ");
                String name    = parts[0];
                String course  = parts[1];
                int semester   = Integer.parseInt(parts[2]);
                dao.addStudent(name, course, semester);
                break;

            case 2:
                System.out.print("Enter Student ID: ");
                int searchId = sc.nextInt();
                dao.searchStudent(searchId);
                break;

            case 3:
                System.out.print("Enter id newCourse: ");
                int updateId      = sc.nextInt();
                String newCourse  = sc.next();
                dao.updateCourse(updateId, newCourse);
                break;

            case 4:
                System.out.print("Enter Student ID to delete: ");
                int deleteId = sc.nextInt();
                dao.deleteStudent(deleteId);
                break;

            default:
                System.out.println("Invalid choice");
        }

        sc.close();
    }
}