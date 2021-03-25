package dao;

import java.sql.Connection;




import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.sql.DataSource;

import dto.GingerAdmin;
import dto.GingerMember;
import webapp.Component;
import webapp.DBAction;

@Component("adminDao")
public class AdminDao {
	private DataSource ds;
	public void setDataSource(DataSource ds) {
		this.ds = ds;
	}
	
	// 관리자 등록
	public int insert(GingerAdmin admin) throws Exception {
		Connection connection = null;
		PreparedStatement pstmt = null;
		try {
			connection = ds.getConnection();
			pstmt = connection.prepareStatement(
					"INSERT INTO WORKER(PWD, NAME, ID, PHONE) VALUES (?,?,?,?)");
			pstmt.setString(1, admin.getPassword());
			pstmt.setString(2, admin.getName());
			pstmt.setString(3, admin.getId());
			pstmt.setString(4, admin.getPhone());
			
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
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
	// 관리자 등록 아이디 체크
		public GingerAdmin idCheck(String id) throws Exception{
				Connection connection = null;
				  PreparedStatement pstmt = null;
				  ResultSet rs = null;
				  GingerAdmin admin = null;
				  try{
					  connection = ds.getConnection();
					  pstmt = connection.prepareStatement("SELECT ID FROM WORKER WHERE ID=?");
					  pstmt.setString(1, id);
					  rs = pstmt.executeQuery();
					  if(rs.next()) {
						  admin = new GingerAdmin();
						  admin.setId(rs.getString("id"));
					  }
				  }catch(SQLException e){
					  e.printStackTrace();
				  }
				return admin;
			}
	// 로그인
	public GingerAdmin exist(String id, String password) throws Exception {
        Connection connection = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			connection = ds.getConnection();
			stmt = connection.prepareStatement
					("SELECT ID, NAME, PHONE FROM WORKER" 
			               + " WHERE ID=? AND PWD=?");
			stmt.setString(1, id);
			stmt.setString(2, password);
			rs = stmt.executeQuery();
			if (rs.next()) {
				return new GingerAdmin()
					    .setName(rs.getString("name"))
					    .setId(rs.getString("id"))
					    .setPhone(rs.getString("phone"));
				        
			}
//			else {
//				throw new Exception("로그인 실패");
//			}
		} catch (Exception e) {
			throw e;
		} finally {
			try {if (rs != null) rs.close();} catch (Exception e) {}
			try {if (connection != null) connection.close();} catch (Exception e) {}
			try {if (stmt != null) stmt.close();} catch (Exception e) {}
		}
		return null;
		
	}

//	/* 회원목록 페이징 처리
	public int selectCnt() {
		int result = 0;
		PreparedStatement pstmt = null;
		Connection connection = null;
		ResultSet rs = null;
		String sql = "SELECT COUNT(*) FROM MEMBER";
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
			try {if(rs != null)rs.close();}catch(SQLException e) {}
			try {if(pstmt != null)pstmt.close();}catch(SQLException e) {}
		}
		return result;
	}
	
	public Vector<GingerMember> selectPage(String table, int start, int pageCnt){
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		Connection connection = null;
		String sql = "SELECT * FROM MEMBER LIMIT ?, ?";
		Vector<GingerMember> m = new Vector<GingerMember>();
		try {
			connection = DBAction.getInstance().getConnection();
			pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, pageCnt);
			rs = pstmt.executeQuery();
			while(rs.next()){
				GingerMember member = new GingerMember();
				member.setMno(rs.getInt("mno"));
				member.setId(rs.getString("ID"));
				member.setPassword(rs.getString("PWD"));
				member.setName(rs.getString("NAME"));
				member.setPhone(rs.getString("PHONE"));
				member.setUseyn(rs.getString("USEYN"));
				member.setEmail(rs.getString("EMAIL"));
				member.setCreateDate(rs.getDate("CRE_DATE"));
				m.add(member);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {if(rs != null)rs.close();}catch(SQLException e) {}
			try {if(pstmt != null)pstmt.close();}catch(SQLException e) {}
		}
		return m;
		
	}
//*/
	// 회원정보 수정 뿌려주기
	public GingerMember selectOne(String id) throws Exception{
		Connection connection = null;
	    Statement stmt = null;
	    ResultSet rs = null;
	    try {
	    	connection = ds.getConnection();
	    	stmt = connection.createStatement();
	    	rs = stmt.executeQuery(
	    			"SELECT ID, NAME, EMAIL, PHONE, USEYN, PWD, CRE_DATE FROM MEMBER" +
	    	      " WHERE ID= "+id);
	    	if(rs.next()) {
	    		return new GingerMember()
	    			.setId(rs.getString("ID"))
	    		    .setName(rs.getString("NAME"))
	    		    .setEmail(rs.getString("EMAIL"))
	    		    .setPhone(rs.getString("PHONE"))
	    		    .setPassword(rs.getString("PWD"))
	    		    .setUseyn(rs.getString("USEYN"))
	    		    .setCreateDate(rs.getDate("CRE_DATE"));
	    	} 
	    }catch(Exception e) {
	    	throw e;
	    }finally {
	    	try {if(rs != null) rs.close();}catch(Exception e) {}
	    	try {if(stmt != null) stmt.close();}catch(Exception e) {}
	    	try {if(connection != null) connection.close();}catch(Exception e) {}
	    }
		return null;
	}
	// 회원정보 수정
	public int update(GingerMember member) throws Exception{
		Connection connection = null;
		PreparedStatement stmt = null;
		try {
			connection = ds.getConnection();
			stmt = connection.prepareStatement(
					"UPDATE MEMBER SET EMAIL=?, PWD=? , PHONE=? ,USEYN=? , MOD_DATE=now()"
					+ " WHERE ID=?");
			stmt.setString(1, member.getEmail());
			stmt.setString(2, member.getPassword());
			stmt.setString(3, member.getPhone());
			stmt.setString(4, member.getUseyn());
			stmt.setString(5, member.getId());
			return stmt.executeUpdate();
		}catch(Exception e) {
			throw e;
		}finally {
			try {if(stmt != null) stmt.close();}catch(Exception e) {}
			try {if(connection != null) connection.close();}catch(Exception e) {}
			
		}
		
	}
	//회원 정보 삭제
	public void delete(String id) {
		String sql = "DELETE FROM MEMBER WHERE ID=?";
		Connection connection = null;
		PreparedStatement pstmt = null;
		try {
			connection = ds.getConnection();
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {if(pstmt != null) pstmt.close();}catch(Exception e) {}
			try {if(connection != null) connection.close();}catch(Exception e) {}
		}
	}
}



