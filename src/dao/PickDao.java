package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.sql.DataSource;

import dto.GingerPick;
import webapp.Component;
@Component("pickDao")
public class PickDao {
	private DataSource ds;
	public void setDataSource(DataSource ds) {
		this.ds = ds;
	}
	
	public ArrayList<GingerPick> pickList(String id) {
		ArrayList<GingerPick> pickList = new ArrayList<GingerPick>();
		PreparedStatement pstmt = null;
		Connection connection = null;
	    ResultSet rs = null;
	    try {
	    	connection = ds.getConnection();
	    	pstmt = connection.prepareStatement(
	    			"SELECT * FROM PICK_VIEW WHERE ID=?"
	    		+ " ORDER BY CSEQ DESC"	);
	    	pstmt.setString(1, id);
	    	rs = pstmt.executeQuery();
	    	while(rs.next()) {
	    		GingerPick pick = new GingerPick();
	    		pick.setCseq(rs.getInt("cseq"));
	    		pick.setId(rs.getString("id"));
	    		pick.setPseq(rs.getInt("pseq"));
	    		pick.setAddress(rs.getString("address"));
	    		pick.setState(rs.getInt("state"));
	    		pick.setResult(rs.getString("result"));
	    		pick.setCreateDate(rs.getDate("CRE_DATE"));
	    		pick.setImage(rs.getString("image"));
	    		pick.setPname(rs.getString("pname"));
	    		pick.setMname(rs.getString("mname"));
	    		pick.setKind(rs.getString("kind"));
	    		
	    		pickList.add(pick);
	    	}
	    }catch(Exception e) {
	    	e.printStackTrace();
	    }finally {
	    	try {if(rs != null) rs.close();}catch(Exception e) {}
	    	try {if(pstmt != null) pstmt.close();}catch(Exception e) {}
	    	try {if(connection != null) connection.close();}catch(Exception e) {}
	    }
	    return pickList;
	}

	public int pickup(int pseq, String id) {
		Connection connection = null;
		PreparedStatement pstmt = null;
		try {
			connection = ds.getConnection();
			pstmt = connection.prepareStatement(
					"INSERT INTO PICK(ID,PSEQ,CRE_DATE) VALUES(?,?,now())");
			pstmt.setString(1, id);
			pstmt.setInt(2, pseq);
			return pstmt.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)pstmt.close();
			} catch (Exception e) {
			}
			try {
				if (connection != null)connection.close();
			} catch (Exception e) {
			}
		}
		return -1;
	}
	
	public int deletepickup(int pseq, String id) {
	     Connection connection = null;
	     PreparedStatement pstmt= null;
	     try {
	    	 connection = ds.getConnection();
	    	 pstmt = connection.prepareStatement("DELETE FROM PICK WHERE pseq=? AND ID=?");
	    	 pstmt.setInt(1, pseq);
	    	 pstmt.setString(2, id);
	    	 return pstmt.executeUpdate();
	     }catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {if (connection != null) connection.close();} catch (Exception e) {}
				try {if (pstmt != null) pstmt.close();} catch (Exception e) {}
			}
			return -1; //  추천 중복 오류
			
	}

	

}
