package UseCases;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Dao.AdminDao;
import Dao.AdminDaoImpl;
import Model.Biding;
import UncheckedException.TenderException;

public class ViewAllBids {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("enter your email id");
		String email = sc.next();
		
        AdminDao dao = new AdminDaoImpl();
		
		try {
			
			List<Biding> bidings = new ArrayList<>(dao.ViewAllBids(email));
			
			bidings.forEach(b -> System.out.println(b));
			
		} catch (TenderException e) {
			
			e.printStackTrace();
		}

	}

}
