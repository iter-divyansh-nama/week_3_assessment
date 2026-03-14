package jdbc.library;

import java.util.Scanner;

public class Main {

public static void main(String[] args) {

Scanner sc = new Scanner(System.in);

System.out.println("Enter title author price");

String title = sc.next();
String author = sc.next();
double price = sc.nextDouble();

BookDAO.addBook(title, author, price);

/* show inserted record */
BookDAO.searchBook(210);

}
}