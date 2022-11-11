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
import Model.User;
import UncheckedException.AdminException;
import UncheckedException.TenderException;

public class AdminDaoImpl implements AdminDao  {

	@Override
	public User registerNewVendor(String email, String password, String username, String name, boolean role, String phone) throws AdminException {
		User user = null;
		
		try(Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("insert into users values(?,?,?,?,?,?)");
			ps.setString(1, email);
			ps.setString(2, password);
			ps.setString(3, username);
			ps.setString(4, name);
			ps.setBoolean(5, role);
			ps.setString(6, phone);
			
			int x = ps.executeUpdate();
			
			if(x>0) {
				System.out.println("Vendor registered successfully");
				user = new User(email,password,username,name,role,phone);
				
				
			}else {
				throw new AdminException("Enter Correct details");
			}
			
			
		}catch(SQLException e) {
			e.printStackTrace();
			throw new AdminException(e.getMessage());
		}
		
		
		
		
		
		return user;
	}

	@Override
	public List<User> viewAllVendors() throws AdminException {
		List<User> users = new ArrayList<>();
		
		try (Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("Select * from users where role=false");
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				String email = rs.getString("email");
				String name = rs.getString("name");
				String username = rs.getString("username");
				String phone = rs.getString("phone");
				
				User user = new User(email,username,name,phone);
				
				users.add(user);
				
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
			throw new AdminException(e.getMessage());
		}
		
		return users;
	}

	@Override
	public String createNewTender(int tender_id, String start_date, String last_date, 
			String tender_name) throws TenderException {
		
        String res = "failed to add tender";
        
		try(Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("insert into tenders values(?,?,?,?)");
			ps.setInt(1,tender_id);
			ps.setString(2,start_date);
			ps.setString(3, last_date);
			//ps.setBoolean(4, status);
			ps.setString(4, tender_name);
			
			
			int x = ps.executeUpdate();
			
			if(x>0) {
				
				System.out.println("new tender created");
				
				
			}else {
				throw new TenderException("Enter all details correctly");
			}
			
			
		}catch(SQLException e) {
			e.printStackTrace();
			throw new TenderException(e.getMessage());
		}
		
		
		return res;
	}

	@Override
	public List<Tender> viewAllTender() throws TenderException {
			
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
	public String PlaceABid(int tender_id, double bid_amount,String email) throws TenderException {
		String msg = "failed";
		
        try(Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("insert into biding(biding_time,tender_id,bid_amount,vender_email) values(currefdate(),?,?,?)");
			ps.setInt(1,tender_id);
			ps.setDouble(2,bid_amount);
			ps.setString(3,email );
			//ps.setBoolean(4, status);
			//ps.setBoolean(4, false);
			
			
			int x = ps.executeUpdate();
			
			if(x>0) {
				
				System.out.println("new tender created");
				
				
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
	public List<Tender> viewAllCurrentTender() throws TenderException {
		 List<Tender> tenders = new ArrayList<>();
			
			try (Connection conn = DBUtil.provideConnection()){
				
				PreparedStatement ps = conn.prepareStatement("Select * from tenders");
				
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
	public List<Biding> ViewAllBidsOfATender(int tender_id) throws TenderException {
        List<Biding> bidings = new ArrayList<>();
		
		try (Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("Select * from biding where tender_id = ?");
			ps.setInt(1, tender_id);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				double bid_amount = rs.getDouble( "bid_amount");
				String vendor_email = rs.getString("vendor_email");
				
				Biding biding = new Biding(tender_id,bid_amount,vendor_email);
				
				bidings.add(biding);
				
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
			throw new TenderException(e.getMessage());
		}
		
		return bidings;
	}

	@Override
	public List<Biding> ViewAllBids(String vendor_email) throws TenderException {
		  List<Biding> bidings = new ArrayList<>();
			
			try (Connection conn = DBUtil.provideConnection()){
				
				PreparedStatement ps = conn.prepareStatement("Select * from biding where vendor_email= ?");
				ps.setString(1, vendor_email);
				
				ResultSet rs = ps.executeQuery();
				
				while(rs.next()) {
					int tender_id = rs.getInt("tender_id");
					double bid_amount = rs.getDouble( "bid_amount");
					
					
					Biding biding = new Biding(tender_id,bid_amount,vendor_email);
					
					bidings.add(biding);
					
				}
				
			}catch(SQLException e) {
				e.printStackTrace();
				throw new TenderException(e.getMessage());
			}
			
			return bidings;
	}
	
	

}
