package myBank.model;

public class TransactionReqVo {
	String access_token;
	
	String bank_tran_id;  
	String fitech_use_num; 

	String inquiry_type; 
	String inquiry_base;  
	String from_date; 
	String to_date; 
	String sort_order;
	String tran_dtime;
	String before_inquiry_trace_info;
	
	
	public String getAccess_token() {
		return access_token;
	}
	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}
	public String getBank_tran_id() {
		return bank_tran_id;
	}
	public void setBank_tran_id(String bank_tran_id) {
		this.bank_tran_id = bank_tran_id;
	}
	public String getFitech_use_num() {
		return fitech_use_num;
	}
	public void setFitech_use_num(String fitech_use_num) {
		this.fitech_use_num = fitech_use_num;
	}
	public String getInquiry_type() {
		return inquiry_type;
	}
	public void setInquiry_type(String inquiry_type) {
		this.inquiry_type = inquiry_type;
	}
	public String getInquiry_base() {
		return inquiry_base;
	}
	public void setInquiry_base(String inquiry_base) {
		this.inquiry_base = inquiry_base;
	}
	public String getFrom_date() {
		return from_date;
	}
	public void setFrom_date(String from_date) {
		this.from_date = from_date;
	}
	public String getTo_date() {
		return to_date;
	}
	public void setTo_date(String to_date) {
		this.to_date = to_date;
	}
	public String getSort_order() {
		return sort_order;
	}
	public void setSort_order(String sort_order) {
		this.sort_order = sort_order;
	}
	public String getTran_dtime() {
		return tran_dtime;
	}
	public void setTran_dtime(String tran_dtime) {
		this.tran_dtime = tran_dtime;
	}
	public String getBefore_inquiry_trace_info() {
		return before_inquiry_trace_info;
	}
	public void setBefore_inquiry_trace_info(String before_inquiry_trace_info) {
		this.before_inquiry_trace_info = before_inquiry_trace_info;
	}
	
	
	
	
	
	
	
}
