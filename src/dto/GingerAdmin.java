package dto;



public class GingerAdmin {
	private String id; 
	private String password;
	private String name;
	private String phone;
	
	public String getId() {
		return id;
	}
	public GingerAdmin setId(String id) {
		this.id = id;
		return this;
	}

	public String getPassword() {
		return password;
	}
	public GingerAdmin setPassword(String password) {
		this.password = password;
		return this;
	}
	public String getName() {
		return name;
	}
	public GingerAdmin setName(String name) {
		this.name = name;
		return this;
	}
	public String getPhone() {
		return phone;
	}
	public GingerAdmin setPhone(String phone) {
		this.phone = phone;
		return this;
	}

}
