package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DBUtility.DBUtil;
import Model.Biding;
import Model.Tender;
import UncheckedException.TenderException;

public class VendorDaoImpl implements VendorDao{

	@Override
	public List<Tender> viewAllCurrentTender() throws TenderException {
		
		List<Tender> tenders = new ArrayList<>();
		
		try (Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("Select * from tenders where CURDATE()<=last_date");
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int tender_id= rs.getInt("tender_id");
				String start_date = rs.getString("start_date");
				String last_date = rs.getString("last_date");
				String tender_name = rs.getString("tender_name");
				
				
				Tender tender = new Tender(tender_id,start_date,last_date,tender_name);		
				tenders.add(tender);
				
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
			throw new TenderException(e.getMessage());
		}
		
		
		
		return tenders;
	}

	@Override
	public String placeABiding(int tender_id, double bid_amount, String email) throws TenderException {
	String msg = "failed";
		
        try(Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("insert into biding(biding_time,tender_id,bid_amount,vendor_email) values(now(),?,?,?)");
			ps.setInt(1,tender_id);
			ps.setDouble(2,bid_amount);
			ps.setString(3,email );
			
			
			int x = ps.executeUpdate();
			
			if(x>0) {
				
				
				msg = "Your bid is placed";
				
			}else {
				throw new TenderException("Enter all details correctly");
			}
			
			
		}catch(SQLException e) {
			e.printStackTrace();
			throw new TenderException(e.getMessage());
		}
		
		
		
		return msg;
	}

	@Override
	public List<Biding> viewAllBidsHistory(String vendor_email) throws TenderException {
		 List<Biding> bidings = new ArrayList<>();
			
			try (Connection conn = DBUtil.provideConnection()){
				
				PreparedStatement ps = conn.prepareStatement("Select * from biding where vendor_email= ?");
				ps.setString(1, vendor_email);
				
				ResultSet rs = ps.executeQuery();
				
				while(rs.next()) {
					int biding_id = rs.getInt("biding_id");
					String biding_time = rs.getString("biding_time");
					int tender_id = rs.getInt("tender_id");
					double bid_amount = rs.getDouble( "bid_amount");
					
					boolean isAssigned = rs.getBoolean("isAssigned");
					
				
					
					Biding biding = new Biding(biding_id,biding_time,tender_id,bid_amount,vendor_email,isAssigned);
					
					bidings.add(biding);
					
				}
				
			}catch(SQLException e) {
				e.printStackTrace();
				throw new TenderException(e.getMessage());
			}
			
			return bidings;
	}

	@Override
	public String getStatus(int tender_id) throws TenderException {
		String result = "something went wrong";
            try(Connection conn = DBUtil.provideConnection()){
            	
            	PreparedStatement ps = conn.prepareStatement("Select isAssigned from biding where tender_id= ?");
				ps.setInt(1, tender_id);
				
				ResultSet rs = ps.executeQuery();
				
				while(rs.next()) {
		
					
					boolean isAssigned = rs.getBoolean("isAssigned");
					
					if(isAssigned) 
						result = "Your bid is Selected";
					else
						result = "Sorry! Your bid is Selected";
				
			    }
			
			
		}catch(SQLException e) {
			e.printStackTrace();
			throw new TenderException(e.getMessage());
		}
		return result;
	}

}
