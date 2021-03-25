package dao;

import java.sql.Connection;




import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import dto.GingerBoard;
import dto.GingerQnA;
import webapp.Component;
import webapp.DBAction;

import javax.sql.DataSource;

@Component("boardDao")
public class BoardDao {
	private static BoardDao instance = new BoardDao();
	public static BoardDao getInstance() {
		return instance;
	}
	
	private DataSource ds;
	public void setDataSource(DataSource ds) {
		this.ds = ds;
	}

	// 자유게시판 글쓰기
		public int insert(GingerBoard board) throws Exception{
			Connection connection = null;
			PreparedStatement pstmt = null;
			try {
				connection = ds.getConnection();
				pstmt = connection.prepareStatement(
						"INSERT INTO BOARD(SUBJECT, CONTENT, ID, likey,rep, CRE_DATE) "
						+ " VALUES (?, ?, ?,0,0, NOW())");
				pstmt.setString(1, board.getSubject());
				pstmt.setString(2, board.getContent());
				pstmt.setString(3, board.getId());
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
		// 자유게시판 상세보기
		public GingerBoard detail(int bseq) {
			Connection connection = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				connection = ds.getConnection();
				pstmt = connection.prepareStatement(
						"SELECT * FROM BOARD WHERE BSEQ=?");
				pstmt.setInt(1, bseq);
				rs = pstmt.executeQuery();
				if(rs.next()) {
					GingerBoard board = new GingerBoard();
					board.setBseq(rs.getInt("bseq"));
					board.setSubject(rs.getString("subject"));
					board.setContent(rs.getString("content"));
					board.setId(rs.getString("id"));
					board.setLikey(rs.getInt("likey"));
					board.setRep(rs.getInt("rep"));
					board.setYn(rs.getString("yn"));
					board.setCRE_DATE(rs.getDate("CRE_DATE"));
					return board;
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
		
	// 내 게시글 검색
		public ArrayList<GingerBoard> mylist(String id,String page,String form,String add) {
			ArrayList<GingerBoard> boardlist = new ArrayList<GingerBoard>();
			Connection connection = null;
			int p = Integer.parseInt(page);
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				connection = ds.getConnection();
				if(form.equals("all")) {
					pstmt = connection.prepareStatement(
							"SELECT BSEQ, SUBJECT, CONTENT, LIKEY, ID, REP, YN,CRE_DATE "  
								+ "FROM BOARD WHERE id='"+id+"' AND yn='y' ORDER BY BSEQ ASC limit "+ (p-1)*10+",10" );
				}else if(form.equals("sub")) {
					pstmt = connection.prepareStatement(
							"SELECT BSEQ, SUBJECT, CONTENT, LIKEY, ID, REP, YN,CRE_DATE "  
								+ "FROM BOARD WHERE id='"+id+"' AND yn='y' AND subject LIKE '%" + add + "%' ORDER BY BSEQ ASC limit "+ (p-1)*10+",10" );
				}else if(form.equals("con")) {
					pstmt = connection.prepareStatement(
							"SELECT BSEQ, SUBJECT, CONTENT, LIKEY, ID, REP, YN,CRE_DATE "  
								+ "FROM BOARD WHERE id='"+id+"' AND yn='y' AND content LIKE '%" + add + "%' ORDER BY BSEQ ASC limit "+ (p-1)*10+",10" );
				}else if(form.equals("likey")) {
					pstmt = connection.prepareStatement(
							"SELECT BSEQ, SUBJECT, CONTENT, LIKEY, ID, REP, YN,CRE_DATE "  
								+ "FROM BOARD WHERE id='"+id+"' AND yn='y' AND subject LIKE '%" + add + "%' ORDER BY likey DESC limit "+ (p-1)*10+",10" );
				}else if(form.equals("rep")) {
					pstmt = connection.prepareStatement(
							"SELECT BSEQ, SUBJECT, CONTENT, LIKEY, ID, REP, YN,CRE_DATE "  
								+ "FROM BOARD WHERE id='"+id+"' AND yn='y' AND subject LIKE '%" + add + "%' ORDER BY rep DESC limit "+ (p-1)*10+",10" );
				}
				rs = pstmt.executeQuery();
				while(rs.next()) {
					GingerBoard board = new GingerBoard();
					board.setBseq(rs.getInt("bseq"));
					board.setSubject(rs.getString("subject"));
					board.setContent(rs.getString("content"));
					board.setId(rs.getString("id"));
					board.setLikey(rs.getInt("likey"));
					board.setRep(rs.getInt("rep"));
					board.setYn(rs.getString("yn"));
					board.setCRE_DATE(rs.getDate("CRE_DATE"));
					boardlist.add(board);
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
			return boardlist;
		}
		//자유게시판 내 글 카운트
		public int myselectCnt(String id,String form,String add) {
			int result = 0;
			String sql = null;
			PreparedStatement pstmt = null;
			Connection connection = null;
			ResultSet rs = null;
			if(form.equals("all")) {
				sql = "SELECT COUNT(*) FROM BOARD WHERE id= '"+id+"' AND yn='y'";			
			}else if(form.equals("sub")) {
				sql = "SELECT COUNT(*) FROM BOARD WHERE id= '"+id+"' AND yn='y' AND subject LIKE '%" + add + "%' ";			
			}else if(form.equals("con")) {
				sql = "SELECT COUNT(*) FROM BOARD WHERE id= '"+id+"' AND yn='y' AND content LIKE '%" + add + "%' ";		
			}else if(form.equals("likey")) {
				sql = "SELECT COUNT(*) FROM BOARD WHERE id= '"+id+"' AND yn='y' AND subject LIKE '%" + add + "%' ";
			}else if(form.equals("rep")) {
				sql = "SELECT COUNT(*) FROM BOARD WHERE id= '"+id+"' AND yn='y' AND subject LIKE '%" + add + "%' ";		
			}
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
		
	public ArrayList<GingerBoard> list(String page, String form ,String add)  {
		ArrayList<GingerBoard> boardlist = new ArrayList<GingerBoard>();
		Connection connection = null;
		int p = Integer.parseInt(page);
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			connection = ds.getConnection();
			if(form.equals("all")) {
				pstmt = connection.prepareStatement(
						"SELECT BSEQ, SUBJECT, CONTENT, LIKEY, ID, REP, YN,CRE_DATE "  
							+ "FROM BOARD WHERE yn='y' ORDER BY BSEQ ASC limit "+ (p-1)*10+",10" );
			}else if(form.equals("id")) {
				pstmt = connection.prepareStatement(
						"SELECT BSEQ, SUBJECT, CONTENT, LIKEY, ID, REP, YN,CRE_DATE "  
							+ "FROM BOARD WHERE yn='y' AND id LIKE '%" + add + "%' ORDER BY BSEQ ASC limit "+ (p-1)*10+",10" );
			}else if(form.equals("sub")) {
				pstmt = connection.prepareStatement(
						"SELECT BSEQ, SUBJECT, CONTENT, LIKEY, ID, REP, YN,CRE_DATE "  
							+ "FROM BOARD WHERE yn='y' AND subject LIKE '%" + add + "%' ORDER BY BSEQ ASC limit "+ (p-1)*10+",10" );
			}else if(form.equals("con")) {
				pstmt = connection.prepareStatement(
						"SELECT BSEQ, SUBJECT, CONTENT, LIKEY, ID, REP, YN,CRE_DATE "  
							+ "FROM BOARD WHERE yn='y' AND content LIKE '%" + add + "%' ORDER BY BSEQ ASC limit "+ (p-1)*10+",10" );
			}else if(form.equals("likey")) {
				pstmt = connection.prepareStatement(
						"SELECT BSEQ, SUBJECT, CONTENT, LIKEY, ID, REP, YN,CRE_DATE "  
							+ "FROM BOARD WHERE yn='y' AND subject LIKE '%" + add + "%' ORDER BY likey DESC limit "+ (p-1)*10+",10" );
			}else if(form.equals("rep")) {
				pstmt = connection.prepareStatement(
						"SELECT BSEQ, SUBJECT, CONTENT, LIKEY, ID, REP, YN,CRE_DATE "  
							+ "FROM BOARD WHERE yn='y' AND subject LIKE '%" + add + "%' ORDER BY rep DESC limit "+ (p-1)*10+",10" );
			}
			rs = pstmt.executeQuery();
			while(rs.next()) {
				GingerBoard board = new GingerBoard();
				board.setBseq(rs.getInt("bseq"));
				board.setSubject(rs.getString("subject"));
				board.setContent(rs.getString("content"));
				board.setId(rs.getString("id"));
				board.setLikey(rs.getInt("likey"));
				board.setRep(rs.getInt("rep"));
				board.setYn(rs.getString("yn"));
				board.setCRE_DATE(rs.getDate("CRE_DATE"));
				boardlist.add(board);
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
		return boardlist;
	}
	//자유게시판 전체글 카운트
	public int selectCnt(String form,String add) {
		int result = 0;
		String sql = null;
		PreparedStatement pstmt = null;
		Connection connection = null;
		ResultSet rs = null;
		if(form.equals("all")) {
			sql = "SELECT COUNT(*) FROM BOARD WHERE yn='y'";			
		}else if(form.equals("id")) {
			sql = "SELECT COUNT(*) FROM BOARD WHERE yn='y' AND id LIKE '%" + add + "%'";			
		}
		else if(form.equals("sub")) {
			sql = "SELECT COUNT(*) FROM BOARD WHERE yn='y' AND subject LIKE '%" + add + "%'";			
		}
		else if(form.equals("con")) {
			sql = "SELECT COUNT(*) FROM BOARD WHERE yn='y' AND content LIKE '%" + add + "%'";		
		}
		else if(form.equals("likey")) {
			sql = "SELECT COUNT(*) FROM BOARD WHERE yn='y' AND subject LIKE '%" + add + "%' ";
		}
		else if(form.equals("rep")) {
			sql = "SELECT COUNT(*) FROM BOARD WHERE yn='y' AND subject LIKE '%" + add + "%' ";		
		}
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
	
// 문의내용 뿌리기
	/*
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
	*/	//사용자용 개인 자유게시판 페이징처리
	public int mselectCnt(String id) {
		int result = 0;
		PreparedStatement pstmt = null;
		Connection connection = null;
		ResultSet rs = null;
		String sql = "SELECT COUNT(*) FROM BOARD WHERE ID="+id;
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
	public Vector<GingerBoard> mselectPage(String table, String id ,int start, int pageCnt){
		PreparedStatement pstmt = null;
		Connection connection = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM BOARD WHERE ID='"+id+"' LIMIT ?, ?";
		Vector<GingerBoard> v = new Vector<GingerBoard>();
		try {
			connection = DBAction.getInstance().getConnection();
			pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, pageCnt);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				GingerBoard board = new GingerBoard();
				board.setBseq(rs.getInt("bseq"));
				board.setId(rs.getString("id"));
				board.setSubject(rs.getString("subject"));
				board.setContent(rs.getString("content"));
				board.setRep(rs.getInt("rep"));
				board.setLikey(rs.getInt("likey"));
				board.setYn(rs.getString("yn"));
				board.setCRE_DATE(rs.getDate("CRE_DATE"));
				v.add(board);
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
	// 개인 게시글 페이징처리 끝
}

