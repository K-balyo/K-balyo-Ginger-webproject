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
import webapp.DBAction;

@Component("productDao")
public class ProductDao {
	private static ProductDao instance = new ProductDao();
	public static ProductDao getInstance() {
		return instance;
	}
	private DataSource ds;
	public void setDataSource(DataSource ds) {
		this.ds = ds;
	}
	// new 랑 best 바뀜
	public ArrayList<GingerProduct> listNewProduct() throws Exception{
		ArrayList<GingerProduct> productList2 = new ArrayList<GingerProduct>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM NEW_PRO_VIEW";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				GingerProduct product = new GingerProduct();
				product.setPseq(rs.getInt("pseq"));
				product.setName(rs.getString("name"));
				product.setImage(rs.getString("image"));
				product.setState(rs.getInt("state"));
				product.setAddress(rs.getString("address"));
				product.setKind(rs.getString("kind"));
				product.setTag(rs.getString("tag"));
				product.setPrice(rs.getInt("price1"));
				product.setPrice2(rs.getInt("price2"));
				product.setPrice3(rs.getInt("price3"));
				productList2.add(product);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) rs.close();
				if(conn != null) conn.close();
				if(pstmt != null) pstmt.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return productList2;
		
	}
	
	public ArrayList<GingerProduct> listBestProduct(){
		ArrayList<GingerProduct> productList = new ArrayList<GingerProduct>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM BEST_PRO_VIEW ";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				GingerProduct product = new GingerProduct();
				product.setPseq(rs.getInt("pseq"));
				product.setName(rs.getString("name"));
				product.setImage(rs.getString("image"));
				product.setState(rs.getInt("state"));
				product.setAddress(rs.getString("address"));
				product.setKind(rs.getString("kind"));
				product.setTag(rs.getString("tag"));
				product.setPrice(rs.getInt("price1"));
				product.setPrice2(rs.getInt("price2"));
				product.setPrice3(rs.getInt("price3"));
				productList.add(product);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) rs.close();
				if(conn != null) conn.close();
				if(pstmt != null) pstmt.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return productList;
	}
	// 종목별 아이템 리스트 
	public ArrayList<GingerProduct> listitem(String kind){
		ArrayList<GingerProduct> productList = new ArrayList<GingerProduct>();
		PreparedStatement pstmt = null;
		Connection conn = null;
		ResultSet rs = null;
		try {
			conn = ds.getConnection();
			String sql = "SELECT * FROM product where kind=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, kind);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				GingerProduct product = new GingerProduct();
				product.setPseq(rs.getInt("pseq"));
				product.setName(rs.getString("name"));
				product.setImage(rs.getString("image"));
				product.setState(rs.getInt("state"));
				product.setKind(rs.getString("kind"));
				product.setTag(rs.getString("tag"));
				product.setCreateDate(rs.getDate("cre_date"));
				product.setModifiedDate(rs.getDate("mod_date"));
				product.setContent(rs.getString("content"));
				product.setPrice(rs.getInt("price1"));
				product.setPrice2(rs.getInt("price2"));
				product.setPrice3(rs.getInt("price3"));
				product.setAddress(rs.getString("address"));
				productList.add(product);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) rs.close();
				if(conn != null) conn.close();
				if(pstmt != null) pstmt.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return productList;
	}
	//물품 상세 
	public GingerProduct detail(int pseq){
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "SELECT * FROM product where pseq=?";
			connection = ds.getConnection();
			pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, pseq);
			rs = pstmt.executeQuery();
			if(rs.next()){
				GingerProduct product = new GingerProduct();
				product.setPseq(rs.getInt("pseq"));
				product.setName(rs.getString("name"));
				product.setImage(rs.getString("image"));
				product.setState(rs.getInt("state"));
				product.setAddress(rs.getString("address"));
				product.setKind(rs.getString("kind"));
				product.setTag(rs.getString("tag"));
				product.setCreateDate(rs.getDate("cre_date"));
				product.setModifiedDate(rs.getDate("mod_date"));
				product.setContent(rs.getString("content"));
				product.setPrice(rs.getInt("price1"));
				product.setPrice2(rs.getInt("price2"));
				product.setPrice3(rs.getInt("price3"));
				return product;
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
	public GingerProduct insertProduct(GingerProduct product) {
		return null;
		
	}
	//좋아요 
	
	// 좋아요 취소
	public int deletelike(String pseq) {
		String sql = "DELETE FROM PRODUCT WHERE pseq=?";
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
	
	//주소검색 
	public List<GingerProduct> listAD(String add) throws Exception {
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM PRODUCT WHERE ADDRESS LIKE '%" + add + "%'";
		List<GingerProduct> address = new ArrayList<>();
		try {
			Connection conn = ds.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				address.add(new GingerProduct().setPseq(rs.getInt(1))
						.setName(rs.getString(2))
						.setKind(rs.getString(3))
						.setPrice(rs.getInt(4))
						.setPrice2(rs.getInt(5))
						.setPrice3(rs.getInt(6))
						.setTag(rs.getString(7))
						.setContent(rs.getString(8))
						.setState(rs.getInt(9))
						.setAddress(rs.getString(10))
						.setUseyn(rs.getString(12))
						.setBestyn(rs.getString(13))
						.setCreateDate(rs.getDate(14))
						.setModifiedDate(rs.getDate(15))
						.setImage(rs.getString(11)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
			} catch (Exception e) {
			}
		}
		return address;
	}

	//관리자 물품 전체 리스트
	public ArrayList<GingerProduct> alllistitem() throws Exception{
		Connection connection = null;
	    Statement stmt = null;
	    ResultSet rs = null;
		try {
			connection = ds.getConnection();
	    	stmt = connection.createStatement();
	    	rs = stmt.executeQuery("SELECT * FROM product ORDER BY PSEQ ASC");
			ArrayList<GingerProduct> productList = new ArrayList<GingerProduct>();
			while(rs.next()) {
				productList.add(new GingerProduct()
				.setPseq(rs.getInt("pseq"))
				.setName(rs.getString("name"))
				.setImage(rs.getString("image"))
				.setState(rs.getInt("state"))
				.setKind(rs.getString("kind"))
				.setTag(rs.getString("tag"))
				.setCreateDate(rs.getDate("cre_date"))
				.setModifiedDate(rs.getDate("mod_date"))
				.setContent(rs.getString("content"))
				.setPrice(rs.getInt("price1"))
				.setPrice2(rs.getInt("price2"))
				.setPrice3(rs.getInt("price3"))
				.setAddress(rs.getString("address")));
			}
			return productList;
		}catch(Exception e) {
			throw e;
	    }finally {
	    	try {if(rs != null) rs.close();}catch(Exception e) {}
	    	try {if(stmt != null) stmt.close();}catch(Exception e) {}
	    	try {if(connection != null) connection.close();}catch(Exception e) {}
	    }
	}
	    //관리자 물품 카운트
	    public int selectCnt() {
			int result = 0;
			PreparedStatement pstmt = null;
			Connection connection = null;
			ResultSet rs = null;
			String sql = "SELECT COUNT(*) FROM PRODUCT";
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
		//관리자 물품 페이지 
		public Vector<GingerProduct> selectPage(String table, int start, int pageCnt){
			ResultSet rs = null;
			PreparedStatement pstmt = null;
			Connection connection = null;
			String sql = "SELECT * FROM PRODUCT LIMIT ?, ?";
			Vector<GingerProduct> ap = new Vector<GingerProduct>();
			try {
				connection = DBAction.getInstance().getConnection();
				pstmt = connection.prepareStatement(sql);
				pstmt.setInt(1, start);
				pstmt.setInt(2, pageCnt);
				rs = pstmt.executeQuery();
				while(rs.next()){
					GingerProduct productList = new GingerProduct();
					productList.setPseq(rs.getInt("pseq"));
					productList.setName(rs.getString("name"));
					productList.setImage(rs.getString("image"));
					productList.setState(rs.getInt("state"));
					productList.setKind(rs.getString("kind"));
					productList.setTag(rs.getString("tag"));
					productList.setCreateDate(rs.getDate("cre_date"));
					productList.setModifiedDate(rs.getDate("mod_date"));
					productList.setContent(rs.getString("content"));
					productList.setPrice(rs.getInt("price1"));
					productList.setPrice2(rs.getInt("price2"));
					productList.setPrice3(rs.getInt("price3"));
					productList.setAddress(rs.getString("address"));
							ap.add(productList);
				}
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				try {if(rs != null)rs.close();}catch(SQLException e) {}
				try {if(pstmt != null)pstmt.close();}catch(SQLException e) {}
			}
			return ap;
			
		}

		public GingerProduct selectOne(int pseq) {
			Connection connection = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				String sql = "SELECT * FROM product where pseq=?";
				connection = ds.getConnection();
				pstmt = connection.prepareStatement(sql);
				pstmt.setInt(1, pseq);
				rs = pstmt.executeQuery();
				if(rs.next()){
					GingerProduct product = new GingerProduct();
					product.setPseq(rs.getInt("pseq"));
					product.setName(rs.getString("name"));
					product.setImage(rs.getString("image"));
					product.setState(rs.getInt("state"));
					product.setAddress(rs.getString("address"));
					product.setKind(rs.getString("kind"));
					product.setTag(rs.getString("tag"));
					product.setCreateDate(rs.getDate("cre_date"));
					product.setModifiedDate(rs.getDate("mod_date"));
					product.setContent(rs.getString("content"));
					product.setPrice(rs.getInt("price1"));
					product.setPrice2(rs.getInt("price2"));
					product.setPrice3(rs.getInt("price3"));
					return product;
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

		public int update(GingerProduct product) throws Exception{
			Connection connection = null;
			PreparedStatement stmt = null;
			try {
				connection = ds.getConnection();
				stmt = connection.prepareStatement(
						"UPDATE PRODUCT SET NAME=?, ADDRESS=? ,KIND=? , CONTENT=?, PRICE1=?, PRICE2=?, PRICE3=?, bestyn=?, MOD_DATE=now()"
						+ " WHERE PSEQ=?");
				stmt.setString(1, product.getName());
				stmt.setString(2, product.getAddress());
				stmt.setString(3, product.getKind());
				stmt.setString(4, product.getContent());
				stmt.setInt(5, product.getPrice());
				stmt.setInt(6, product.getPrice2());
				stmt.setInt(7, product.getPrice3());
				stmt.setString(8, product.getBestyn());
				stmt.setInt(9, product.getPseq());
				return stmt.executeUpdate();
			}catch(Exception e) {
				throw e;
			}finally {
				try {if(stmt != null) stmt.close();}catch(Exception e) {}
				try {if(connection != null) connection.close();}catch(Exception e) {}
				
			}
			
		}
}
