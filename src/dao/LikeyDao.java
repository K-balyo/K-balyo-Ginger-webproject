package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import dto.GingerBoardLikey;
import dto.GingerLikey;
import webapp.Component;
@Component("likeyDao")
public class LikeyDao {
	private DataSource ds;
	public void setDataSource(DataSource ds) {
		this.ds = ds;
	}
	
	// product like 부분
	
	public int dolike(String id, String pseq) {
	     String sql = "INSERT INTO LIKEY VALUES(?,?)";
	     Connection connection = null;
	     PreparedStatement pstmt= null;
	     ResultSet rs = null;
	     try {
	    	 connection = ds.getConnection();
	    	 pstmt = connection.prepareStatement(sql);
	    	 pstmt.setString(1, id);
	    	 pstmt.setString(2, pseq);
	    	 return pstmt.executeUpdate();
	     }catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {if (connection != null) connection.close();} catch (Exception e) {}
				try {if (pstmt != null) pstmt.close();} catch (Exception e) {}
				try {if (rs != null) rs.close();} catch (Exception e) {}
			}
			return -1; //  추천 중복 오류
			
		}
	public int dodislike(String id, String pseq) {
	     String sql = "DELETE FROM LIKEY WHERE pseq=? AND ID=?";
	     Connection connection = null;
	     PreparedStatement pstmt= null;
	     ResultSet rs = null;
	     try {
	    	 connection = ds.getConnection();
	    	 pstmt = connection.prepareStatement(sql);
	    	 pstmt.setInt(1, Integer.parseInt(pseq));
	    	 pstmt.setString(2, id);
	    	 return pstmt.executeUpdate();
	     }catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {if (connection != null) connection.close();} catch (Exception e) {}
				try {if (pstmt != null) pstmt.close();} catch (Exception e) {}
				try {if (rs != null) rs.close();} catch (Exception e) {}
			}
			return -1; //  추천 중복 오류
			
		}
	public int like(String pseq) {
		String sql = "UPDATE PRODUCT SET STATE=STATE+1 WHERE pseq=?";
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs= null;
		try {
			connection = ds.getConnection();
			pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(pseq));
			return pstmt.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != connection)
					connection.close();
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
			} catch (Exception e) {
			}
		}
		return -1;
	}
	public int dislike(String pseq) {
		String sql = "UPDATE PRODUCT SET STATE=STATE-1 WHERE pseq=?";
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs= null;
		try {
			connection = ds.getConnection();
			pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(pseq));
			return pstmt.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != connection)
					connection.close();
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
			} catch (Exception e) {
			}
		}
		return -1;
	}
	
	public ArrayList<GingerLikey> likeList(String id){
		ArrayList<GingerLikey> likeList = new ArrayList<GingerLikey>();
		PreparedStatement pstmt = null;
		Connection connection = null;
		ResultSet rs = null;
		try {
			connection = ds.getConnection();
			pstmt = connection.prepareStatement(
					"SELECT * FROM likey WHERE ID=?"
					);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				GingerLikey like = new GingerLikey();
				like.setId(rs.getString("id"));
				like.setPseq(rs.getInt("pseq"));
				likeList.add(like);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
	    	try {if(rs != null) rs.close();}catch(Exception e) {}
	    	try {if(pstmt != null) pstmt.close();}catch(Exception e) {}
	    	try {if(connection != null) connection.close();}catch(Exception e) {}
	    }
		return likeList;
	}
	
	
	
	// board like 부분
	
	public int boarddolike(String id, String bseq) {
	     String sql = "INSERT INTO BOARDLIKEY VALUES(?,?)";
	     Connection connection = null;
	     PreparedStatement pstmt= null;
	     ResultSet rs = null;
	     try {
	    	 connection = ds.getConnection();
	    	 pstmt = connection.prepareStatement(sql);
	    	 pstmt.setString(1, id);
	    	 pstmt.setString(2, bseq);
	    	 return pstmt.executeUpdate();
	     }catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {if (connection != null) connection.close();} catch (Exception e) {}
				try {if (pstmt != null) pstmt.close();} catch (Exception e) {}
				try {if (rs != null) rs.close();} catch (Exception e) {}
			}
			return -1; //  추천 중복 오류
			
		}
	public int boarddodislike(String id, String bseq) {
	     String sql = "DELETE FROM BOARDLIKEY WHERE bseq=? AND ID=?";
	     Connection connection = null;
	     PreparedStatement pstmt= null;
	     ResultSet rs = null;
	     try {
	    	 connection = ds.getConnection();
	    	 pstmt = connection.prepareStatement(sql);
	    	 pstmt.setInt(1, Integer.parseInt(bseq));
	    	 pstmt.setString(2, id);
	    	 return pstmt.executeUpdate();
	     }catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {if (connection != null) connection.close();} catch (Exception e) {}
				try {if (pstmt != null) pstmt.close();} catch (Exception e) {}
				try {if (rs != null) rs.close();} catch (Exception e) {}
			}
			return -1; //  추천 중복 오류
			
		}
	public int boardlike(String bseq) {
		String sql = "UPDATE board SET likey=likey+1 WHERE bseq=?";
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs= null;
		try {
			connection = ds.getConnection();
			pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(bseq));
			return pstmt.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != connection)
					connection.close();
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
			} catch (Exception e) {
			}
		}
		return -1;
	}
	public int boarddislike(String bseq) {
		String sql = "UPDATE BOARD SET likey=likey-1 WHERE bseq=?";
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs= null;
		try {
			connection = ds.getConnection();
			pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(bseq));
			return pstmt.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != connection)
					connection.close();
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
			} catch (Exception e) {
			}
		}
		return -1;
	}
	
	public ArrayList<GingerBoardLikey> boardlikeList(String id){
		ArrayList<GingerBoardLikey> boardlikeList = new ArrayList<GingerBoardLikey>();
		PreparedStatement pstmt = null;
		Connection connection = null;
		ResultSet rs = null;
		try {
			connection = ds.getConnection();
			pstmt = connection.prepareStatement(
					"SELECT * FROM boardlikey WHERE ID=?"
					);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				GingerBoardLikey like = new GingerBoardLikey();
				like.setId(rs.getString("id"));
				like.setBseq(rs.getInt("bseq"));
				boardlikeList.add(like);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
	    	try {if(rs != null) rs.close();}catch(Exception e) {}
	    	try {if(pstmt != null) pstmt.close();}catch(Exception e) {}
	    	try {if(connection != null) connection.close();}catch(Exception e) {}
	    }
		return boardlikeList;
	}
	
	// 자유게시판 조회수 
	public int boardlook(int bseq) {
		String sql = "UPDATE BOARD SET rep=rep+1 WHERE bseq=?";
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs= null;
		try {
			connection = ds.getConnection();
			pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, bseq);
			return pstmt.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != connection)
					connection.close();
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
			} catch (Exception e) {
			}
		}
		return -1;
	}
	

}
