package Model;

public class TenderDto {
	private int tender_id;
	private String tender_name;
	private String start_date;
	private String last_date;

	private String vendor_email;
	private boolean isAssigned;
	public int getTender_id() {
		return tender_id;
	}
	public void setTender_id(int tender_id) {
		this.tender_id = tender_id;
	}
	public String getTender_name() {
		return tender_name;
	}
	public void setTender_name(String tender_name) {
		this.tender_name = tender_name;
	}
	public String getStart_date() {
		return start_date;
	}
	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}
	public String getLast_date() {
		return last_date;
	}
	public void setLast_date(String last_date) {
		this.last_date = last_date;
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
	public TenderDto(int tender_id, String tender_name, String start_date, String last_date, String vendor_email,
			boolean isAssigned) {
		super();
		this.tender_id = tender_id;
		this.tender_name = tender_name;
		this.start_date = start_date;
		this.last_date = last_date;
		this.vendor_email = vendor_email;
		this.isAssigned = isAssigned;
	}
	@Override
	public String toString() {
		return "TenderDto [tender_id=" + tender_id + ", tender_name=" + tender_name + ", start_date=" + start_date
				+ ", last_date=" + last_date + ", vendor_email=" + vendor_email + ", isAssigned=" + isAssigned + "]";
	}
	

}
