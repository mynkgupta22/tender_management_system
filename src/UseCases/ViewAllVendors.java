package UseCases;

import java.util.ArrayList;
import java.util.List;

import Dao.AdminDao;
import Dao.AdminDaoImpl;
import Model.User;
import UncheckedException.AdminException;

public class ViewAllVendors {

	public static void main(String[] args) {
		
		AdminDao dao = new AdminDaoImpl();
		
		try {
			
			List<User> vendors = new ArrayList<>(dao.viewAllVendors());
			
			vendors.forEach(v -> System.out.println(v));
			
		} catch (AdminException e) {
			
			e.printStackTrace();
		}

	}

}
