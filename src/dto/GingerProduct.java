package dto;

import java.util.Date;

public class GingerProduct {
	private int pseq;
	private	String name;
	private	String kind;
	private int price;
	private int price2;
	private int price3;
	private String content;
	private String image;
	private String useyn;
	private String bestyn;
	private int state;
	private String tag;
	private String address;
	private Date createDate;
	private Date modifiedDate; 
	
	public String getAddress() {
		return address;
	}
	public GingerProduct setAddress(String address) {
		this.address = address;
		return this;
	}
	public int getPseq() {
		return pseq;
	}
	public GingerProduct setPseq(int pseq) {
		this.pseq = pseq;
		return this;
	}
	public String getName() {
		return name;
	}
	public GingerProduct setName(String name) {
		this.name = name;
		return this;
	}
	public String getKind() {
		return kind;
	}
	public GingerProduct setKind(String kind) {
		this.kind = kind;
		return this;
	}
	public int getPrice() {
		return price;
	}
	public GingerProduct setPrice(int price) {
		this.price = price;
		return this;
	}
	public int getPrice2() {
		return price2;
	}
	public GingerProduct setPrice2(int price2) {
		this.price2 = price2;
		return this;
	}
	public int getPrice3() {
		return price3;
	}
	public GingerProduct setPrice3(int price3) {
		this.price3 = price3;
		return this;
	}
	public String getContent() {
		return content;
	}
	public GingerProduct setContent(String content) {
		this.content = content;
		return this;
	}
	public String getImage() {
		return image;
	}
	public GingerProduct setImage(String image) {
		this.image = image;
		return this;
	}
	public String getUseyn() {
		return useyn;
	}
	public GingerProduct setUseyn(String useyn) {
		this.useyn = useyn;
		return this;
	}
	public String getBestyn() {
		return bestyn;
	}
	public GingerProduct setBestyn(String bestyn) {
		this.bestyn = bestyn;
		return this;
	}
	public int getState() {
		return state;
	}
	public GingerProduct setState(int state) {
		this.state = state;
		return this;
	}
	public String getTag() {
		return tag;
	}
	public GingerProduct setTag(String tag) {
		this.tag = tag;
		return this;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public GingerProduct setCreateDate(Date createDate) {
		this.createDate = createDate;
		return this;
	}
	public Date getModifiedDate() {
		return modifiedDate;
	}
	public GingerProduct setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
		return this;
	}


}
