package UseCases;

import java.util.Scanner;

import Model.User;

public class Admin {
	public static void getStarted(User user) {
		System.out.println("");
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome "+user.getName());
		System.out.println("");
		System.out.println("1. Register new Vendor");
		System.out.println("2. Register new Admin");
		System.out.println("3. View all the vendors");
		System.out.println("4. Create new tenders");
		System.out.println("5. View all the Tenders");
		System.out.println("6. View All the Bids of a tender");
		System.out.println("7. Assign tender to a vendor");
		System.out.println("8. LogOut/Exit");
		
		
		int input = sc.nextInt();
		
		switch(input) {
		case 1 :
		}
		
		
		
		
	}

}
