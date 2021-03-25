package dto;

import java.util.Date;

public class GingerPick {
	private int cseq; 
	private String id;
	private int pseq; 
	private	String pname;
	private	String mname;
	private	String result;
	private int price;
	private int price2;
	private int price3;
	private Date createDate;
	private String image;
	private int state;
	private String address;
	private String tag;
	private String content;
	private String kind;
	
	public String getKind() {
		return kind;
	}
	public GingerPick setKind(String kind) {
		this.kind = kind;
		return this;
	}
	public String getTag() {
		return tag;
	}
	public GingerPick setTag(String tag) {
		this.tag = tag;
		return this;
	}
	public String getContent() {
		return content;
	}
	public GingerPick setContent(String content) {
		this.content = content;
		return this;
	}
	public String getPname() {
		return pname;
	}
	public GingerPick setPname(String pname) {
		this.pname = pname;
		return this;
	}
	public String getMname() {
		return mname;
	}
	public GingerPick setMname(String mname) {
		this.mname = mname;
		return this;
	}
	public int getPrice() {
		return price;
	}
	public GingerPick setPrice(int price) {
		this.price = price;
		return this;
	}
	public int getPrice2() {
		return price2;
	}
	public GingerPick setPrice2(int price2) {
		this.price2 = price2;
		return this;
	}
	public int getPrice3() {
		return price3;
	}
	public GingerPick setPrice3(int price3) {
		this.price3 = price3;
		return this;
	}
	public String getAddress() {
		return address;
	}
	public GingerPick setAddress(String address) {
		this.address = address;
		return this;
	}

	
	public int getCseq() {
		return cseq;
	}
	public GingerPick setCseq(int cseq) {
		this.cseq = cseq;
		return this;
	}
	public String getId() {
		return id;
	}
	public GingerPick setId(String id) {
		this.id = id;
		return this;
	}
	public int getPseq() {
		return pseq;
	}
	public GingerPick setPseq(int pseq) {
		this.pseq = pseq;
		return this;
	}
	public String getResult() {
		return result;
	}
	public GingerPick setResult(String result) {
		this.result = result;
		return this;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public GingerPick setCreateDate(Date createDate) {
		this.createDate = createDate;
		return this;
	}
	public String getImage() {
		return image;
	}
	public GingerPick setImage(String image) {
		this.image = image;
		return this;
	}
	public int getState() {
		return state;
	}
	public GingerPick setState(int state) {
		this.state = state;
		return this;
	}
	

}
