package dto;

import java.util.Date;

public class GingerQnA {
	private int qseq;
	private String subject;
	private String content;
	private String id;
	private String reply;
	private String rep;
	private Date CRE_DATE;
	
	public int getQseq() {
		return qseq;
	}
	public GingerQnA setQseq(int qseq) {
		this.qseq = qseq;
		return this;
	}
	public String getSubject() {
		return subject;
	}
	public GingerQnA setSubject(String subject) {
		this.subject = subject;
		return this;
	}
	public String getContent() {
		return content;
	}
	public GingerQnA setContent(String content) {
		this.content = content;
		return this;
	}
	public String getId() {
		return id;
	}
	public GingerQnA setId(String id) {
		this.id = id;
		return this;
	}
	public String getReply() {
		return reply;
	}
	public GingerQnA setReply(String reply) {
		this.reply = reply;
		return this;
	}
	public String getRep() {
		return rep;
	}
	public GingerQnA setRep(String rep) {
		this.rep = rep;
		return this;
	}
	public Date getCRE_DATE() {
		return CRE_DATE;
	}
	public GingerQnA setCRE_DATE(Date cRE_DATE) {
		CRE_DATE = cRE_DATE;
		return this;
	}

}
