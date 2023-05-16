package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import context.DbContext;
import model.RatingCount;
import model.RatingProduct;

public class RatingDao {
	Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

//  Get 
    public RatingProduct getRatingProduct(int idP, int idA, int idO) {
    	String query = "select * from ProductRating where ida = ? and idp = ? and idO = ?";
	      try {
	          conn = new DbContext().getConnection();//mo ket noi voi sql
	          ps = conn.prepareStatement(query);
	          ps.setInt(1, idA);
	          ps.setInt(2, idP);
	          ps.setInt(3, idO);
	          rs = ps.executeQuery();
	          while (rs.next()) {
	              return new RatingProduct(rs.getInt(1),
	            		  rs.getInt(2),
	            		  rs.getInt(3),
	            		  rs.getInt(4),
	            		  rs.getString(5),
	            		  rs.getDate(6));
	          }
	          conn.close();
	          ps.close();
	          rs.close();
	      } catch (Exception e) {
	      }
	      return new RatingProduct() ;
    }
//    thêm 
    public void addRatingProduct(int idP, int idA, int idO, int rating, String comment, Date date) {
    	String query = "insert into ProductRating([idA], [idP], [idO], [rating], [comment], [dateRating]) values(?, ?, ?, ?, ?, ?)";
	      try {
	          conn = new DbContext().getConnection();//mo ket noi voi sql
	          ps = conn.prepareStatement(query);
	          ps.setInt(1, idA);
	          ps.setInt(2, idP);
	          ps.setInt(3, idO);
	          ps.setInt(4, rating);
	          ps.setString(5, comment);
	          ps.setDate(6, date);
	          ps.executeUpdate();
	          conn.close();
	          ps.close();
	         
	      } catch (Exception e) {
	      }
    }
//  sửa
	  public void saveRatingProduct(int idP, int idA, String idO, int rating, String comment, Date date) {
	  	String query = "UPDATE dbo.ProductRating SET [rating] = ?, [comment] = ?, [dateRating] = ? where [idA]= ? and [idP]= ? and [idO] = ?";
		      try {
		          conn = new DbContext().getConnection();//mo ket noi voi sql
		          ps = conn.prepareStatement(query);
		          ps.setInt(1, rating);
		          ps.setString(2, comment);
		          ps.setDate(3, date);
		          ps.setInt(4, idA);
		          ps.setInt(5, idP);
		          ps.setString(6, idO);
		          ps.executeUpdate();
		          conn.close();
		          ps.close();
		         
		      } catch (Exception e) {
		      }
	  }
	  public List<RatingCount> getRatingCountProduct(String idP) {
		  	List<RatingCount> list = new ArrayList<>();
		  	String query = "WITH Ratings AS (\r\n"
		  			+ "SELECT rating FROM (VALUES (5), (4), (3), (2), (1)) AS R(rating)\r\n"
		  			+ ")\r\n"
		  			+ "SELECT Ratings.rating, COUNT(ProductRating.rating) AS Count\r\n"
		  			+ "FROM Ratings\r\n"
		  			+ "LEFT JOIN ProductRating ON Ratings.rating = ProductRating.rating AND ProductRating.IdP = ?\r\n"
		  			+ "GROUP BY Ratings.rating;";
			try {
			          conn = new DbContext().getConnection();//mo ket noi voi sql
			          ps = conn.prepareStatement(query);
			          ps.setString(1, idP);
			          rs = ps.executeQuery();
			          while(rs.next()) {
			        	  list.add(new RatingCount(rs.getInt(1), rs.getInt(2)));
			          }
			          conn.close();
			          ps.close();
			          rs.close();
			         
			} catch (Exception e) {
			}
			return list;
	  }
	  public static void main(String[] args) {
		  RatingDao RDao = new RatingDao();
		RatingProduct rP = RDao.getRatingProduct(11, 2, 7);
		System.out.println(rP);
		
	}
}
