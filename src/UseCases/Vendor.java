package UseCases;

import java.util.Scanner;

import Model.User;

public class Vendor {
	public static void getStarted(User user) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome "+user.getName());
		System.out.println("");
		System.out.println("1. View all the current Tenders");
		System.out.println("2. Place a Bid against a Tender");
		System.out.println("3. View status of a Bid");
		System.out.println("4. View Bid History");
		
		int input = sc.nextInt();
		
	}

}
