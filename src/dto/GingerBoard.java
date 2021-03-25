package dto;

import java.util.Date;

public class GingerBoard {
	private int bseq;
	private String subject;
	private String content;
	private String id;
	private int likey;
	private int rep;
	private String yn;
	private Date CRE_DATE;
	
	public String getYn() {
		return yn;
	}
	public GingerBoard setYn(String yn) {
		this.yn = yn;
		return this;
	}
	public int getBseq() {
		return bseq;
	}
	public GingerBoard setBseq(int bseq) {
		this.bseq = bseq;
		return this;
	}
	public String getSubject() {
		return subject;
	}
	public GingerBoard setSubject(String subject) {
		this.subject = subject;
		return this;
	}
	public String getContent() {
		return content;
	}
	public GingerBoard setContent(String content) {
		this.content = content;
		return this;
	}
	public String getId() {
		return id;
	}
	public GingerBoard setId(String id) {
		this.id = id;
		return this;
	}
	public int getLikey() {
		return likey;
	}
	public GingerBoard setLikey(int likey) {
		this.likey = likey;
		return this;
	}
	public int getRep() {
		return rep;
	}
	public GingerBoard setRep(int rep) {
		this.rep = rep;
		return this;
	}
	public Date getCRE_DATE() {
		return CRE_DATE;
	}
	public GingerBoard setCRE_DATE(Date cRE_DATE) {
		CRE_DATE = cRE_DATE;
		return this;
	}

}
