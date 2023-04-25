package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import context.DbContext;
import model.Account;
import model.Address;
import model.Order;
import model.OrderDetails;
import model.RatingAccount;

public class AccountDao {
	Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
//  Account
//  Get Account
    public Account getAccount(String username, String password) {
    	String query = "select * from Account where Username = ? and [Password] = ?";
	      try {
	          conn = new DbContext().getConnection();//mo ket noi voi sql
	          ps = conn.prepareStatement(query);
	          ps.setString(1, username);
	          ps.setString(2, password);
	          rs = ps.executeQuery();
	          while (rs.next()) {
	              return new Account(rs.getInt(1),
	            		  rs.getString(2),
	            		  rs.getString(3),
	            		  rs.getString(4),
	            		  rs.getInt(5));
	          }
	          conn.close();
	          ps.close();
	          rs.close();
	      } catch (Exception e) {
	      }
	      return null;
    }
//  check Account
    public Account checkAccount(String username) {
    	String query = "select * from Account where Username = ?";
	      try {
	          conn = new DbContext().getConnection();//mo ket noi voi sql
	          ps = conn.prepareStatement(query);
	          ps.setString(1, username);
	          rs = ps.executeQuery();
	          while (rs.next()) {
	              return new Account(rs.getInt(1),
	            		  rs.getString(2),
	            		  rs.getString(3),
	            		  rs.getString(4),
	            		  rs.getInt(5));
	          }
	          conn.close();
	          ps.close();
	          rs.close();
	      } catch (Exception e) {
	      }
	      return null;
    }
//  Post Account
  	public void postAccount(String username, String password) {
  		String query = "INSERT INTO Account([imageA], [Username], [Password], [isAdmin]) VALUES(?, ? , ?, ?)";
	      try {
	          conn = new DbContext().getConnection();//mo ket noi voi sql
	          ps = conn.prepareStatement(query);
	          ps.setString(1,"anhuserpetshop.png");
	          ps.setString(2, username);
	          ps.setString(3, password);
	          ps.setInt(4, 0);
	          ps.executeUpdate();
	          
	          conn.close();
	          ps.close();
	          rs.close();
	      } catch (Exception e) {
	      }
  	}
//  end account
  	public Address getAddress(int id) {
  		String query = "select * from Address where IdA = ?";
	      try {
	          conn = new DbContext().getConnection();//mo ket noi voi sql
	          ps = conn.prepareStatement(query);
	          ps.setInt(1, id);
	          rs = ps.executeQuery();
	          while(rs.next()){
	        	  return new Address(rs.getInt(1),
	        			  rs.getInt(2),
	        			  rs.getString(3),
	        			  rs.getString(4),
	        			  rs.getString(5));
	          }
	          conn.close();
	          ps.close();
	          rs.close();
	      } catch (Exception e) {
	      }
	      return null;
  	}
  	public void addAddress(int id, String name , String phone, String address) {
  		String query = "INSERT INTO DBO.[Address]([IdA], [Name], [Phone], [Address]) VALUES(?, ?, ?, ?)";
	      try {
	          conn = new DbContext().getConnection();//mo ket noi voi sql
	          ps = conn.prepareStatement(query);
	          ps.setInt(1, id);
	          ps.setString(2, name);
	          ps.setString(3, phone);
	          ps.setString(4, address);
	          ps.executeUpdate();
	          
	          conn.close();
	          ps.close();
	      } catch (Exception e) {
	      }
	     
  	}
  	public void updateAddress(int id, String name , String phone, String address) {
  		String query = "UPDATE DBO.[Address] SET [Name] =?, [Phone] =?, [Address] =? WHERE IdA = ?";
	      try {
	          conn = new DbContext().getConnection();//mo ket noi voi sql
	          ps = conn.prepareStatement(query);
	          ps.setString(1, name);
	          ps.setString(2, phone);
	          ps.setString(3, address);
	          ps.setInt(4, id);
	          ps.executeUpdate();
	          
	          conn.close();
	          ps.close();
	      } catch (Exception e) {
	      }
	     
  	}
//  	
  	public void addOrder (Date date, int idA) {
  		String query = "INSERT INTO DBO.[Order]([CreatedDate], [IdA]) VALUES(?, ?)";
	      try {
	          conn = new DbContext().getConnection();//mo ket noi voi sql
	          ps = conn.prepareStatement(query);
	          ps.setDate(1, date);
	          ps.setInt(2, idA);
	          ps.executeUpdate();
	          
	          conn.close();
	          ps.close();
	      } catch (Exception e) {
	      }
  	}
  	public List<Order> getOrder (String idA) {
  		List<Order> list = new ArrayList<>();
  		String query = "select * from Order where IdA = ?";
	      try {
	          conn = new DbContext().getConnection();//mo ket noi voi sql
	          ps = conn.prepareStatement(query);
	          ps.setString(1, idA);
	          rs = ps.executeQuery();
	          while(rs.next()) {
	        	  list.add(new Order(rs.getInt(1),
	        			  rs.getDate(2),
	        			  rs.getInt(3)));
	          }
	          conn.close();
	          ps.close();
	      } catch (Exception e) {
	      }
	      return list;
  	}
//  	
  	public int addOrderDetails (OrderDetails o) {
  		int result = 0;
  		String query = "INSERT INTO DBO.OrderDetails([IdO], [IdP], [Amount], [Price], [Status]) VALUES(?, ?, ?, ?, ?)";
	      try {
	          conn = new DbContext().getConnection();//mo ket noi voi sql
	          ps = conn.prepareStatement(query);
	          ps.setInt(1, o.getIdO());
	          ps.setInt(2, o.getIdP());
	          ps.setInt(3, o.getAmount());
	          ps.setInt(4, o.getPrice());
	          ps.setInt(5, 0);
	          result = ps.executeUpdate();
	          
	          conn.close();
	          ps.close();
	      } catch (Exception e) {
	      }
	      return result;
  	}
  	public Order getOrderOneTop () {
  		String query = "SELECT * FROM [Order] WHERE idO = (SELECT MAX(idO) FROM [Order])";
  		
	      try {
	          conn = new DbContext().getConnection();//mo ket noi voi sql
	          ps = conn.prepareStatement(query);
	          rs = ps.executeQuery();
	          while(rs.next()) {
	        	  return new Order(rs.getInt(1),
	        			  rs.getDate(2),
	        			  rs.getInt(3));
	          }
	          conn.close();
	          ps.close();
	      } catch (Exception e) {
	      }
	      return null;
  	}
  	public List<OrderDetails> getOrderDetails (String idO) {
  		List<OrderDetails> list = new ArrayList<>();
  		String query = "select * from OrderDetails where IdO = ?";
	      try {
	          conn = new DbContext().getConnection();//mo ket noi voi sql
	          ps = conn.prepareStatement(query);
	          ps.setString(1, idO);
	          rs = ps.executeQuery();
	          while(rs.next()) {
	        	  list.add(new OrderDetails(rs.getInt(1),
	        			  rs.getInt(2),
	        			  rs.getInt(3),
	        			  rs.getInt(4),
	        			  rs.getInt(5)));
	          }
	          conn.close();
	          ps.close();
	      } catch (Exception e) {
	      }
	      return list;
  	}
//  	
  	public List<RatingAccount> getAllRatingAcount(String idP){
  		List<RatingAccount> list = new ArrayList<>();
  		String query = "select PR.*, A.imageA, A.Username\r\n"
  				+ "from ProductRating AS PR\r\n"
  				+ "LEFT JOIN Account AS A ON A.IdA = PR.IdA\r\n"
  				+ "WHERE PR.IdP = ?";
	      try {
	          conn = new DbContext().getConnection();//mo ket noi voi sql
	          ps = conn.prepareStatement(query);
	          ps.setString(1, idP);
	          rs = ps.executeQuery();
	          while(rs.next()) {
	        	  list.add(new RatingAccount(rs.getInt(1),
	        			  rs.getInt(2),
	        			  rs.getInt(3),
	        			  rs.getString(4),
	        			  rs.getString(5),
	        			  rs.getString(6)));
	          }
	          conn.close();
	          ps.close();
	      } catch (Exception e) {
	      }
	      return list;
  	}
  	public void putImageAcount(String image, int idA){
  		
  		String query = "UPDATE Account SET [imageA] = ? where idA =?";
	      try {
	          conn = new DbContext().getConnection();//mo ket noi voi sql
	          ps = conn.prepareStatement(query);
	          ps.setString(1, image);
	          ps.setInt(2, idA);
	          ps.executeUpdate();
	          
	          conn.close();
	          ps.close();
	      } catch (Exception e) {
	      }
	     
  	}
  	public static void main(String[] args) {
  		AccountDao dao = new AccountDao();
		Address a = dao.getAddress(2);
		Order o = dao.getOrderOneTop();
		System.out.println(o);
	}
}
