package Dao;

import java.util.List;

import javax.security.auth.login.LoginException;

import Model.Biding;
import Model.Tender;
import Model.TenderDto;
import Model.User;
import UncheckedException.AdminException;
import UncheckedException.TenderException;

public interface AdminDao  {
	
public User registerNewVendor(String email, String password, String username, String name, boolean role, String phone) throws AdminException;

public List<User> viewAllVendors()throws AdminException;

public String createNewTender(int tender_id, String start_date, String last_date,  String tender_name)throws TenderException;

public List<Tender> viewAllTender()throws TenderException;

public List<Biding> getAllBidsOfATender(int tender_id)throws TenderException;

public String assignedTender(int biding_id)throws TenderException;

public String getPassword(String email,String phone)throws LoginException;

public TenderDto getAllDetails(int tender_id)throws TenderException;

}
