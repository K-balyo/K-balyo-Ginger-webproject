package dto;

public class GingerBoardLikey {
	String id;
	int bseq;
	
	public String getId() {
		return id;
	}
	public GingerBoardLikey setId(String id) {
		this.id = id;
		return this;
	}
	public int getBseq() {
		return bseq;
	}
	public GingerBoardLikey setBseq(int bseq) {
		this.bseq = bseq;
		return this;
	}
	public GingerBoardLikey() {
		
	}
	public GingerBoardLikey(String id, int bseq) {
		super();
		this.id = id;
		this.bseq = bseq;
	}
	

}
