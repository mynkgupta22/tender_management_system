package Dao;

import java.util.List;

import Model.Biding;
import Model.Tender;
import UncheckedException.TenderException;

public interface VendorDao {
	
	public List<Tender> viewAllCurrentTender()throws TenderException;
	
	public String placeABiding(int tender_id,double bid_amount,String email)throws TenderException;
	
	public List<Biding> viewAllBidsHistory(String vendor_email)throws TenderException;
	
	public String getStatus(int tender_id)throws TenderException;

}
