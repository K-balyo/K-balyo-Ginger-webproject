package dao;

import java.sql.Connection;




import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import dto.GingerQnA;
import webapp.Component;
import webapp.DBAction;

import javax.sql.DataSource;

@Component("qnaDao")
public class QnADao {
	private static QnADao instance = new QnADao();
	public static QnADao getInstance() {
		return instance;
	}
	
	private DataSource ds;
	public void setDataSource(DataSource ds) {
		this.ds = ds;
	}
	
	public GingerQnA selectQnA(int qseq){
		GingerQnA qna = null;
		String sql = "SELECT * FROM QNA WHERE QSEQ=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, qseq);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				qna = new GingerQnA();
				qna.setQseq(rs.getInt("qseq"));
				qna.setSubject(rs.getString("subject"));
				qna.setContent(rs.getString("content"));
				qna.setId(rs.getString("id"));
				qna.setCRE_DATE(rs.getDate("CRE_DATE"));
				qna.setReply(rs.getString("reply"));
				qna.setRep(rs.getString("rep"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return qna;
		
	}
	//고객용 1:1 문의 리스트 페이징
	public int mselectCnt(String id) {
		int result = 0;
		PreparedStatement pstmt = null;
		Connection connection = null;
		ResultSet rs = null;
		String sql = "SELECT COUNT(*) FROM QNA WHERE ID="+id;
		try {
			connection = DBAction.getInstance().getConnection();
			pstmt = connection.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = rs.getInt(1);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) {
					rs.close();
				}
				if(pstmt != null) {
					pstmt.close();
				}
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
		return result;
		}
	public Vector<GingerQnA> mselectPage(String table, String id ,int start, int pageCnt){
		PreparedStatement pstmt = null;
		Connection connection = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM QNA WHERE ID='"+id+"' LIMIT ?, ?";
		Vector<GingerQnA> v = new Vector<GingerQnA>();
		try {
			connection = DBAction.getInstance().getConnection();
			pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, pageCnt);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				GingerQnA dto = new GingerQnA();
				dto.setQseq(rs.getInt("qseq"));
				dto.setId(rs.getString("id"));
				dto.setSubject(rs.getString("subject"));
				dto.setContent(rs.getString("reply"));
				dto.setRep(rs.getString("rep"));
				dto.setCRE_DATE(rs.getDate("CRE_DATE"));
				v.add(dto);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) {
					rs.close();
				}
				if(pstmt != null) {
					pstmt.close();
				}
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return v;
	}
	
	//관리자 문의 페이징
	public int selectCnt() {
		int result = 0;
		PreparedStatement pstmt = null;
		Connection connection = null;
		ResultSet rs = null;
		String sql = "SELECT COUNT(*) FROM QNA ";
		try {
			connection = DBAction.getInstance().getConnection();
			pstmt = connection.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = rs.getInt(1);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) {
					rs.close();
				}
				if(pstmt != null) {
					pstmt.close();
				}
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
		return result;
		}
	public Vector<GingerQnA> selectPage(String table, int start, int pageCnt){
		PreparedStatement pstmt = null;
		Connection connection = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM QNA LIMIT ?, ?";
		Vector<GingerQnA> v = new Vector<GingerQnA>();
		try {
			connection = DBAction.getInstance().getConnection();
			pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, pageCnt);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				GingerQnA dto = new GingerQnA();
				dto.setQseq(rs.getInt("qseq"));
				dto.setId(rs.getString("id"));
				dto.setSubject(rs.getString("subject"));
				dto.setContent(rs.getString("reply"));
				dto.setRep(rs.getString("rep"));
				dto.setCRE_DATE(rs.getDate("CRE_DATE"));
				v.add(dto);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) {
					rs.close();
				}
				if(pstmt != null) {
					pstmt.close();
				}
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return v;
	}
	
//	public List<GingerQnA> selectList() throws Exception {
//		Connection connection = null;
//		Statement stmt = null;
//		Statement stmt2 = null;
//		ResultSet rs = null;
//		try {
//			connection = ds.getConnection();
//			stmt = connection.createStatement();
//			stmt.executeUpdate("SET @CNT=0");
//			stmt2 = connection.createStatement();
//			stmt2.executeUpdate("UPDATE QNA SET QNA.QSEQ=@CNT:=@CNT+1");
//			stmt2.close();
//			rs = stmt.executeQuery("SELECT QSEQ, SUBJECT, CONTENT, REPLY, ID, REP, CRE_DATE "
//					+ "FROM QNA ORDER BY QSEQ ASC");
//			ArrayList<GingerQnA> qlist = new ArrayList<GingerQnA>();
//			while(rs.next()) {
//				qlist.add(new GingerQnA()
//						.setQseq(rs.getInt("QSEQ"))
//						.setSubject(rs.getString("SUBJECT"))
//						.setContent(rs.getString("CONTENT"))
//						.setReply(rs.getString("REPLY"))
//						.setId(rs.getString("ID"))
// 				        .setRep(rs.getString("REP"))
//						.setCRE_DATE(rs.getDate("CRE_DATE")));
//			}
//			return qlist;
//		}catch(Exception e) {
//			throw e;
//		}finally {
//			try {if(rs != null) rs.close();}catch(Exception e) {}
//	    	try {if(stmt != null) stmt.close();}catch(Exception e) {}
//	    	try {if(connection != null) connection.close();}catch(Exception e) {}
//	    }
//	}
	//1:1문의
	public int insert(GingerQnA qna) throws Exception{
		Connection connection = null;
		PreparedStatement pstmt = null;
		try {
			connection = ds.getConnection();
			pstmt = connection.prepareStatement(
					"INSERT INTO QNA(SUBJECT, CONTENT, ID, CRE_DATE) "
					+ " VALUES (?, ?, ?, NOW())");
			pstmt.setString(1, qna.getSubject());
			pstmt.setString(2, qna.getContent());
			pstmt.setString(3, qna.getId());
			return pstmt.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if (connection != null)
					connection.close();
			} catch (Exception e) {
			}
			try {
				if (pstmt != null)
					pstmt.close();
			} catch (Exception e) {
			}
	}
		return -1;
	}
// 질문 상세보기
	public GingerQnA detail(int qseq) {
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			connection = ds.getConnection();
			pstmt = connection.prepareStatement(
					"SELECT * FROM QNA WHERE QSEQ=?");
			pstmt.setInt(1, qseq);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				GingerQnA qna = new GingerQnA();
				qna.setQseq(rs.getInt("qseq"));
				qna.setSubject(rs.getString("subject"));
				qna.setContent(rs.getString("content"));
				qna.setId(rs.getString("id"));
				qna.setReply(rs.getString("reply"));
				qna.setRep(rs.getString("rep"));
				qna.setCRE_DATE(rs.getDate("CRE_DATE"));
				return qna;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) rs.close();
				if(connection != null) connection.close();
				if(pstmt != null) pstmt.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	
///*
	public ArrayList<GingerQnA> mylist(String id) {
		ArrayList<GingerQnA> qnalist = new ArrayList<GingerQnA>();
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			connection = ds.getConnection();
			pstmt = connection.prepareStatement(
					"SELECT QSEQ, SUBJECT, CONTENT, REPLY, ID, REP, CRE_DATE "  
						+ "FROM QNA WHERE ID=? ORDER BY QSEQ ASC");
					pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				GingerQnA qna = new GingerQnA();
				qna.setQseq(rs.getInt("qseq"));
				qna.setSubject(rs.getString("subject"));
				qna.setContent(rs.getString("content"));
				qna.setId(rs.getString("id"));
				qna.setReply(rs.getString("reply"));
				qna.setRep(rs.getString("rep"));
				qna.setCRE_DATE(rs.getDate("CRE_DATE"));
				qnalist.add(qna);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) rs.close();
				if(connection != null) connection.close();
				if(pstmt != null) pstmt.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return qnalist;
	}
//	*/
// 문의내용 뿌리기
	public GingerQnA doreply(int qseq) {
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			connection = ds.getConnection();
			pstmt = connection.prepareStatement(
					"SELECT QSEQ, SUBJECT, CONTENT, ID, REP, REPLY, CRE_DATE FROM QNA WHERE QSEQ=?");
			pstmt.setInt(1, qseq);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				GingerQnA qna = new GingerQnA();
						qna.setQseq(rs.getInt("QSEQ"));
						qna.setSubject(rs.getString("SUBJECT"));
						qna.setContent(rs.getString("CONTENT"));
						qna.setId(rs.getString("ID"));
						qna.setRep(rs.getString("REP"));
                        qna.setReply(rs.getString("REPLY"));
						qna.setCRE_DATE(rs.getDate("CRE_DATE"));
						return qna;
			}
		}catch(Exception e) {
	    	e.printStackTrace();
	    }finally {
	    	try {if(rs != null) rs.close();}catch(Exception e) {}
	    	try {if(pstmt != null) pstmt.close();}catch(Exception e) {}
	    	try {if(connection != null) connection.close();}catch(Exception e) {}
	    }
		return null;
	}
//문의내용 답변달기
	public int reply(GingerQnA qna) throws Exception {
		Connection connection = null;
		PreparedStatement pstmt = null;
		try {
			connection = ds.getConnection();
			pstmt = connection.prepareStatement(
					"UPDATE QNA SET REPLY=?,REP='2' WHERE QSEQ=?");
			pstmt.setString(1, qna.getReply());
			pstmt.setInt(2, qna.getQseq());
			return pstmt.executeUpdate();
		}catch(Exception e) {
			throw e;
		}finally {
			try {if(pstmt != null) pstmt.close();}catch(Exception e) {}
			try {if(connection != null) connection.close();}catch(Exception e) {}
			
		}
		
	}
	
	
}

