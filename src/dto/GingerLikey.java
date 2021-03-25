package dto;

public class GingerLikey {
	String id;
	int pseq;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getPseq() {
		return pseq;
	}
	public void setPseq(int pseq) {
		this.pseq = pseq;
	}
	public GingerLikey() {
		
	}
	public GingerLikey(String id, int pseq) {
		super();
		this.id = id;
		this.pseq = pseq;
	}
	

}
