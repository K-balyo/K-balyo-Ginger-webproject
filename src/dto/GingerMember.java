package dto;

import java.util.Date;

public class GingerMember {
	private int mno;
	private String id; 
	private String password;
	private String name;
	private String email;
	private String phone;
	private String image;
	private String useyn;
	private Date createDate;
	private Date modifiedDate;
		
	public int getMno() {
		return mno;
	}
	public GingerMember setMno(int mno) {
		this.mno = mno;
		return this;
	}
	public String getId() {
		return id;
	}
	public GingerMember setId(String id) {
		this.id = id;
		return this;
	}
	public String getPassword() {
		return password;
	}
	public GingerMember setPassword(String password) {
		this.password = password;
		return this;
	}
	public String getName() {
		return name;
	}
	public GingerMember setName(String name) {
		this.name = name;
		return this;
	}
	public String getEmail() {
		return email;
	}
	public GingerMember setEmail(String email) {
		this.email = email;
		return this;
	}
	public String getPhone() {
		return phone;
	}
	public GingerMember setPhone(String phone) {
		this.phone = phone;
		return this;
	}
	public String getImage() {
		return image;
	}
	public GingerMember setImage(String image) {
		this.image = image;
		return this;
	}
	public String getUseyn() {
		return useyn;
	}
	public GingerMember setUseyn(String useyn) {
		this.useyn = useyn;
		return this;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public GingerMember setCreateDate(Date createDate) {
		this.createDate = createDate;
		return this;
	}
	public Date getModifiedDate() {
		return modifiedDate;
	}
	public GingerMember setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
		return this;
	} 

}
