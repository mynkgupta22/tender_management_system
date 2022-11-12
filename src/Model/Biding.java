package Model;

public class Biding {
	
	private int tender_id;
	private double bid_amount;
	private String vendor_email;
	//private boolean isAssigned;
	public int getTender_id() {
		return tender_id;
	}
	public void setTender_id(int tender_id) {
		this.tender_id = tender_id;
	}
	public double getBid_amount() {
		return bid_amount;
	}
	public void setBid_amount(double bid_amount) {
		this.bid_amount = bid_amount;
	}
	public String getVendor_email() {
		return vendor_email;
	}
	public void setVendor_email(String vendor_email) {
		this.vendor_email = vendor_email;
	}
	public Biding(int tender_id, double bid_amount, String vendor_email) {
		super();
		this.tender_id = tender_id;
		this.bid_amount = bid_amount;
		this.vendor_email = vendor_email;
	}
	@Override
	public String toString() {
		return "Biding [tender_id=" + tender_id + ", bid_amount=" + bid_amount + ", vendor_email=" + vendor_email + "]";
	}
    
}
