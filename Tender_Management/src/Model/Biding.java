package Model;

public class Biding {
	private int biding_id;
	private String biding_time;
	private int tender_id;
	private double bid_amount;
	private String vendor_email;
	private boolean isAssigned;
	public int getBiding_id() {
		return biding_id;
	}
	public void setBiding_id(int biding_id) {
		this.biding_id = biding_id;
	}
	public String getBiding_time() {
		return biding_time;
	}
	public void setBiding_time(String biding_time) {
		this.biding_time = biding_time;
	}
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
	public boolean isAssigned() {
		return isAssigned;
	}
	public void setAssigned(boolean isAssigned) {
		this.isAssigned = isAssigned;
	}
	public Biding(int biding_id, String biding_time, int tender_id, double bid_amount, String vendor_email,
			boolean isAssigned) {
		super();
		this.biding_id = biding_id;
		this.biding_time = biding_time;
		this.tender_id = tender_id;
		this.bid_amount = bid_amount;
		this.vendor_email = vendor_email;
		this.isAssigned = isAssigned;
	}
	@Override
	public String toString() {
		return "Biding [biding_id=" + biding_id + ", biding_time=" + biding_time + ", tender_id=" + tender_id
				+ ", bid_amount=" + bid_amount + ", vendor_email=" + vendor_email + ", isAssigned=" + isAssigned + "]";
	}
	
    
}
