package UseCases;

import java.util.ArrayList;
import java.util.List;
import Dao.AdminDao;
import Dao.AdminDaoImpl;
import Model.Tender;
import UncheckedException.TenderException;

public class ViewAllCurrentTender {

	public static void main(String[] args) {
	
        AdminDao dao = new AdminDaoImpl();
		
		try {
			
			List<Tender> tenders = new ArrayList<>(dao.viewAllCurrentTender());
			
			tenders.forEach(t -> System.out.println(t));
			
		} catch (TenderException e) {
			
			e.printStackTrace();
		}
	}

}
