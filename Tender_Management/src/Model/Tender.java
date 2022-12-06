package Model;

public class Tender {
	private int tender_id;
	private String start_date;
	private String last_date;
	//private boolean status;
	private String tender_name;
	
	public int getTender_id() {
		return tender_id;
	}
	public void setTender_id(int tender_id) {
		this.tender_id = tender_id;
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
	
	public String getTender_name() {
		return tender_name;
	}
	public void setTender_name(String tender_name) {
		this.tender_name = tender_name;
	}
	
	public Tender(int tender_id, String start_date, String last_date,  String tender_name) {
		super();
		this.tender_id = tender_id;
		this.start_date = start_date;
		this.last_date = last_date;
		//this.status = status;
		this.tender_name = tender_name;
		
	}
	
	@Override
	public String toString() {
		return "Tender [tender_id=" + tender_id + ", start_date=" + start_date + ", last_date=" + last_date
				 + ", tender_name=" + tender_name  + "]";
	}
	

}
