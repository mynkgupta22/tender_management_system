package Dao;

import java.util.List;

import Model.Biding;
import Model.Tender;
import Model.User;
import UncheckedException.AdminException;
import UncheckedException.TenderException;

public interface AdminDao  {
	
public User registerNewVendor(String email, String password, String username, String name, boolean role, String phone) throws AdminException;

public List<User> viewAllVendors()throws AdminException;

public String createNewTender(int tender_id, String start_date, String last_date,  String tender_name)throws TenderException;

public List<Tender> viewAllCurrentTender()throws TenderException;

public List<Tender> viewAllTender()throws TenderException;

public String PlaceABid(int tender_id,double bid_amount,String email)throws TenderException;

public List<Biding> ViewAllBidsOfATender(int tender_id)throws TenderException;

public List<Biding> ViewAllBids(String vendor_email)throws TenderException;

}
