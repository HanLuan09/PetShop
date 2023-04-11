package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import context.DbContext;
import model.Account;
import model.Address;
import model.Order;
import model.OrderDetails;

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
	            		  rs.getInt(4));
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
	            		  rs.getInt(4));
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
  		String query = "INSERT INTO Account([Username], [Password], [isAdmin]) VALUES( ? , ?, ?)";
	      try {
	          conn = new DbContext().getConnection();//mo ket noi voi sql
	          ps = conn.prepareStatement(query);
	          ps.setString(1, username);
	          ps.setString(2, password);
	          ps.setInt(3, 0);
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
//  	
  	public void addOrder (Order o) {
  		int result = 0;
  		String query = "INSERT INTO DBO.[Order]([CreatedDate], [IdA], [Status]) VALUES(?, ?, ?)";
	      try {
	          conn = new DbContext().getConnection();//mo ket noi voi sql
	          ps = conn.prepareStatement(query);
	          ps.setDate(1, o.getCreatedDate());
	          ps.setInt(2, o.getIdA());
	          ps.setInt(3, 0);
	          result = ps.executeUpdate();
	          
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
	        			  rs.getInt(3),
	        			  rs.getInt(4)));
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
  		String query = "INSERT INTO DBO.OrderDetails([IdO], [IdP], [Amount], [Price]) VALUES(? , ?, ?, ?)";
	      try {
	          conn = new DbContext().getConnection();//mo ket noi voi sql
	          ps = conn.prepareStatement(query);
	          ps.setInt(1, o.getIdO());
	          ps.setInt(2, o.getIdP());
	          ps.setInt(3, o.getAmount());
	          ps.setInt(4, o.getPrice());
	          result = ps.executeUpdate();
	          
	          conn.close();
	          ps.close();
	      } catch (Exception e) {
	      }
	      return result;
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
	        			  rs.getInt(4)));
	          }
	          conn.close();
	          ps.close();
	      } catch (Exception e) {
	      }
	      return list;
  	}
  	public static void main(String[] args) {
  		AccountDao dao = new AccountDao();
		Address a = dao.getAddress(2);
		System.out.println(a);
	}
}
