package UseCases;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Dao.AdminDao;
import Dao.AdminDaoImpl;
import Model.Biding;
import Model.Tender;
import UncheckedException.TenderException;

public class ViewAllBidsOfATender {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter tender id");
		int tender_id = sc.nextInt();

        AdminDao dao = new AdminDaoImpl();
		
		try {
			
			List<Biding> bidings = new ArrayList<>(dao.ViewAllBidsOfATender(tender_id));
			
			bidings.forEach(b -> System.out.println(b));
			
		} catch (TenderException e) {
			
			e.printStackTrace();
		}
	}

}
