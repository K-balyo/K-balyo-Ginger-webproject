package dto;

import java.util.Date;

public class GingerReview {
	private int oseq;
	private int odseq;
	private String id;
	private int pseq;     
	private	String phone;
	private	String pname;
	private	String mname;
	private int quantity;  
	private	String result;
	private int price2;
	private String image;
	private Date createDate;
	private int state;
	
	public int getOseq() {
		return oseq;
	}
	public GingerReview setOseq(int oseq) {
		this.oseq = oseq;
		return this;
	}
	public int getOdseq() {
		return odseq;
	}
	public GingerReview setOdseq(int odseq) {
		this.odseq = odseq;
		return this;
	}
	public String getId() {
		return id;
	}
	public GingerReview setId(String id) {
		this.id = id;
		return this;
	}
	public int getPseq() {
		return pseq;
	}
	public GingerReview setPseq(int pseq) {
		this.pseq = pseq;
		return this;
	}
	public String getPhone() {
		return phone;
	}
	public GingerReview setPhone(String phone) {
		this.phone = phone;
		return this;
	}
	public String getPname() {
		return pname;
	}
	public GingerReview setPname(String pname) {
		this.pname = pname;
		return this;
	}
	public String getMname() {
		return mname;
	}
	public GingerReview setMname(String mname) {
		this.mname = mname;
		return this;
	}
	public int getQuantity() {
		return quantity;
	}
	public GingerReview setQuantity(int quantity) {
		this.quantity = quantity;
		return this;
	}
	public String getResult() {
		return result;
	}
	public GingerReview setResult(String result) {
		this.result = result;
		return this;
	}
	public int getPrice2() {
		return price2;
	}
	public GingerReview setPrice2(int price2) {
		this.price2 = price2;
		return this;
	}
	public String getImage() {
		return image;
	}
	public GingerReview setImage(String image) {
		this.image = image;
		return this;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public GingerReview setCreateDate(Date createDate) {
		this.createDate = createDate;
		return this;
	}
	public int getState() {
		return state;
	}
	public GingerReview setState(int state) {
		this.state = state;
		return this;
	}


}
