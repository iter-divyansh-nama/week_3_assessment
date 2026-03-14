package jdbc.student;



import java.util.Scanner;

public class Main {

public static void main(String[] args) {

Scanner sc = new Scanner(System.in);

System.out.println("Enter name course semester");

String name = sc.next();
String course = sc.next();
int sem = sc.nextInt();

StudentDAO.addStudent(name,course,sem);

StudentDAO.searchStudent(1);

}

}