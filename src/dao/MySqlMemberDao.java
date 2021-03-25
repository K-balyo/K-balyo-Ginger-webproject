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

import dto.GingerMember;
import dto.GingerProduct;
import webapp.Component;

@Component("memberDao")
	public class MySqlMemberDao {
		private DataSource ds;
		public void setDataSource(DataSource ds) {
			this.ds = ds;
		}
		// 로그인
		public GingerMember exist(String id, String password) throws Exception {
            Connection connection = null;
			PreparedStatement stmt = null;
			ResultSet rs = null;
			try {
				connection = ds.getConnection();
				stmt = connection.prepareStatement
						("SELECT ID, NAME, EMAIL FROM MEMBER" 
				               + " WHERE ID=? AND PWD=? AND USEYN='Y'");
				stmt.setString(1, id);
				stmt.setString(2, password);
				rs = stmt.executeQuery();
				if (rs.next()) {
					return new GingerMember()
						    .setName(rs.getString("NAME"))
						    .setId(rs.getString("ID"))
					        .setEmail(rs.getString("EMAIL"));
					        
				}
//				else {
//					throw new Exception("로그인 실패");
//				}
			} catch (Exception e) {
				throw e;
			} finally {
				try {if (rs != null) rs.close();} catch (Exception e) {}
				try {if (connection != null) connection.close();} catch (Exception e) {}
				try {if (stmt != null) stmt.close();} catch (Exception e) {}
			}
			return null;
			
		}
//		/*
		//회원정보
		public List<GingerMember> info() throws Exception{
			Connection connection = null;
		    Statement stmt = null;
		    ResultSet rs = null;
		    try {
		    	connection = ds.getConnection();
		    	stmt = connection.createStatement();
		    	rs = stmt.executeQuery("SELECT ID, NAME, EMAIL, PWD, CRE_DATE FROM MEMBER WHERE ID=?" +
		    	" ORDER BY CRE_DATE ASC");
		    	ArrayList<GingerMember> members = new ArrayList<GingerMember>();
		    	while(rs.next()) {
		    		members.add(new GingerMember()
		    			.setId(rs.getString("ID"))
		    		    .setName(rs.getString("NAME"))
		    		    .setPassword(rs.getString("PWD"))
		    		    .setEmail(rs.getString("EMAIL")) 
		    		    .setCreateDate(rs.getDate("CRE_DATE")));
		    	}
		    	return members;
		    }catch(Exception e) {
		    	throw e;
		    }finally {
		    	try {if(rs != null) rs.close();}catch(Exception e) {}
		    	try {if(stmt != null) stmt.close();}catch(Exception e) {}
		    	try {if(connection != null) connection.close();}catch(Exception e) {}
		    }
		}
		// 회원 목록
		public List<GingerMember> selectList() throws Exception{
			Connection connection = null;
		    Statement stmt = null;
		    ResultSet rs = null;
		    try {
		    	connection = ds.getConnection();
		    	stmt = connection.createStatement();
		    	rs = stmt.executeQuery("SELECT ID, NAME, EMAIL, PWD, CRE_DATE FROM MEMBER" +
		    	" ORDER BY CRE_DATE ASC");
		    	ArrayList<GingerMember> members = new ArrayList<GingerMember>();
		    	while(rs.next()) {
		    		members.add(new GingerMember()
		    			.setId(rs.getString("ID"))
		    		    .setName(rs.getString("NAME"))
		    		    .setPassword(rs.getString("PWD"))
		    		    .setEmail(rs.getString("EMAIL")) 
		    		    .setCreateDate(rs.getDate("CRE_DATE")));
		    	}
		    	return members;
		    }catch(Exception e) {
		    	throw e;
		    }finally {
		    	try {if(rs != null) rs.close();}catch(Exception e) {}
		    	try {if(stmt != null) stmt.close();}catch(Exception e) {}
		    	try {if(connection != null) connection.close();}catch(Exception e) {}
		    }
		}
//		*/
		// 회원가입
		public int insert(GingerMember member) throws Exception {
			Connection connection = null;
			PreparedStatement pstmt = null;
			try {
				connection = ds.getConnection();
				pstmt = connection.prepareStatement(
						"INSERT INTO MEMBER(EMAIL, PWD, NAME, ID, PHONE, CRE_DATE) VALUES (?,?,?,?,?,now())");
				pstmt.setString(1, member.getEmail());
				pstmt.setString(2, member.getPassword());
				pstmt.setString(3, member.getName());
				pstmt.setString(4, member.getId());
				pstmt.setString(5, member.getPhone());
				
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
		
		public GingerMember idCheck(String id) throws Exception{
			Connection connection = null;
			  PreparedStatement pstmt = null;
			  ResultSet rs = null;
			  GingerMember member = null;
			  try{
				  connection = ds.getConnection();
				  pstmt = connection.prepareStatement("SELECT ID FROM MEMBER WHERE ID=?");
				  pstmt.setString(1, id);
				  rs = pstmt.executeQuery();
				  if(rs.next()) {
					  member = new GingerMember();
					  member.setId(rs.getString("id"));
				  }
			  }catch(SQLException e){
				  e.printStackTrace();
			  }
			return member;
		}


		// 회원정보 수정 뿌려주기
		public GingerMember selectOne(String id) throws Exception{
			Connection connection = null;
		    Statement stmt = null;
		    ResultSet rs = null;
		    try {
		    	connection = ds.getConnection();
		    	stmt = connection.createStatement();
		    	rs = stmt.executeQuery(
		    			"SELECT ID, NAME, EMAIL, PHONE, PWD, CRE_DATE FROM MEMBER" +
		    	      " WHERE ID= "+id);
		    	if(rs.next()) {
		    		return new GingerMember()
		    			.setId(rs.getString("ID"))
		    		    .setName(rs.getString("NAME"))
		    		    .setEmail(rs.getString("EMAIL"))
		    		    .setPhone(rs.getString("PHONE"))
		    		    .setPassword(rs.getString("PWD"))
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
						"UPDATE MEMBER SET PWD=? , PHONE=? , email=?, MOD_DATE=now()"
						+ " WHERE ID=?");
				stmt.setString(1, member.getPassword());
				stmt.setString(2, member.getPhone());
				stmt.setString(3, member.getEmail());
				stmt.setString(4, member.getId());
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
			String sql = "UPDATE MEMBER SET USEYN='n' WHERE ID=?";
			Connection connection = null;
//			Statement stmt = null;
			PreparedStatement pstmt = null;
			try {
				connection = ds.getConnection();
				pstmt = connection.prepareStatement(sql);
				pstmt.setString(1, id);
				pstmt.executeUpdate();
//				stmt = connection.createStatement();
//				return stmt.executeUpdate(
//						"DELETE FROM MEMBER WHERE ID=?" + id);
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				try {if(pstmt != null)pstmt.close();}catch(Exception e) {}
				try {if(connection != null)connection.close();}catch(Exception e) {}
			}
		}
		
		
 
}
