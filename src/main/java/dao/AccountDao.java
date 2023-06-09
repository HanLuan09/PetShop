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
import model.OrderAddress;
import model.OrderDetails;
import model.Payment;
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
  	public int postAccount(String username, String password) {
  		int result = 0;
  		String query = "INSERT INTO Account([imageA], [Username], [Password], [isAdmin]) VALUES(?, ? , ?, ?)";
	      try {
	          conn = new DbContext().getConnection();//mo ket noi voi sql
	          ps = conn.prepareStatement(query);
	          ps.setString(1,"anhuserpetshop.png");
	          ps.setString(2, username);
	          ps.setString(3, password);
	          ps.setInt(4, 0);
	          result = ps.executeUpdate();
	          
	          conn.close();
	          ps.close();
	          rs.close();
	      } catch (Exception e) {
	      }
	      return result;
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
  	public int addAddress(int id, String name , String phone, String address) {
  		int result = 0;
  		String query = "INSERT INTO DBO.[Address]([IdA], [Name], [Phone], [Address]) VALUES(?, ?, ?, ?)";
	      try {
	          conn = new DbContext().getConnection();//mo ket noi voi sql
	          ps = conn.prepareStatement(query);
	          ps.setInt(1, id);
	          ps.setString(2, name);
	          ps.setString(3, phone);
	          ps.setString(4, address);
	          result = ps.executeUpdate();
	          
	          conn.close();
	          ps.close();
	      } catch (Exception e) {
	      }
	     return result;
  	}
  	public int updateAddress(int id, String name , String phone, String address) {
  		int result = 0;
  		String query = "UPDATE DBO.[Address] SET [Name] =?, [Phone] =?, [Address] =? WHERE IdA = ?";
	      try {
	          conn = new DbContext().getConnection();//mo ket noi voi sql
	          ps = conn.prepareStatement(query);
	          ps.setString(1, name);
	          ps.setString(2, phone);
	          ps.setString(3, address);
	          ps.setInt(4, id);
	          result = ps.executeUpdate();
	          
	          conn.close();
	          ps.close();
	      } catch (Exception e) {
	      }
	     return result;
  	}
//  	
  	public int addOrder (Date date, int idA) {
    	int ido =0;
    	String query = "DECLARE @InsertedIds TABLE (IdO int);\r\n"
    			+ "INSERT INTO dbo.[Order] ([CreatedDate], [IdA])\r\n"
    			+ "OUTPUT INSERTED.IdO INTO @InsertedIds\r\n"
    			+ "VALUES (?, ?);\r\n"
    			+ "SELECT IdO FROM @InsertedIds;";
    	try {
    		conn = new DbContext().getConnection();//mo ket noi voi sql
    		ps = conn.prepareStatement(query);
    		ps.setDate(1, date);
	        ps.setInt(2, idA);
    		ps.executeUpdate();
    		rs = ps.getGeneratedKeys();
    		if (rs.next()) {
    		    ido = rs.getInt(1);
    		}
    		ps.close();
    		conn.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
    	return ido;
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
  	public int getOrderAccount (String idO) {
  		String query = "select IdA from dbo.[Order] where IdO = ?";
	      try {
	          conn = new DbContext().getConnection();//mo ket noi voi sql
	          ps = conn.prepareStatement(query);
	          ps.setString(1, idO);
	          rs = ps.executeQuery();
	          while(rs.next()) {
	        	  return rs.getInt(1);
	          }
	          conn.close();
	          ps.close();
	      } catch (Exception e) {
	      }
	      return 0;
  	}
  	public int setStauts(String idO) {
  		int result = 0;
  		String query = "UPDATE dbo.OrderDetails SET Status =1 WHERE ido = ? AND Status = 0";
	      try {
	          conn = new DbContext().getConnection();//mo ket noi voi sql
	          ps = conn.prepareStatement(query);
	          ps.setString(1, idO);
	          result = ps.executeUpdate();
	          conn.close();
	          ps.close();
	      } catch (Exception e) {
	      }
	      return result;
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
  	public int removeOrderDetails (String idO, String idP) {
  		int result = 0;
  		String query = "DELETE FROM dbo.OrderDetails where ido = ? AND idp = ?";
	      try {
	          conn = new DbContext().getConnection();//mo ket noi voi sql
	          ps = conn.prepareStatement(query);
	          ps.setString(1, idO);
	          ps.setString(2, idP);
	          result = ps.executeUpdate();
	          conn.close();
	          ps.close();
	      } catch (Exception e) {
	      }
	     return result;
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
		        			  rs.getInt(4),
		        			  rs.getString(5),
		        			  rs.getDate(6),
		        			  rs.getString(7),
		        			  rs.getString(8)));
	    		}
	          conn.close();
	          ps.close();
	      } catch (Exception e) {
	      }
	      return list;
  	}
  	public int putImageAcount(String image, int idA){
  		int result = 0;
  		String query = "UPDATE Account SET [imageA] = ? where idA =?";
	      try {
	          conn = new DbContext().getConnection();//mo ket noi voi sql
	          ps = conn.prepareStatement(query);
	          ps.setString(1, image);
	          ps.setInt(2, idA);
	          result = ps.executeUpdate();
	          
	          conn.close();
	          ps.close();
	      } catch (Exception e) {
	      }
	     return result;
  	}
  	public int addOrderAddress(int idO, String name , String phone, String address) {
  		int result = 0;
  		String query = "INSERT INTO DBO.[OrderAdderss]([IdO], [Name], [Phone], [Address]) VALUES( ?, ?, ?, ?)";
	      try {
	          conn = new DbContext().getConnection();//mo ket noi voi sql
	          ps = conn.prepareStatement(query);
	          ps.setInt(1, idO);
	          ps.setString(2, name);
	          ps.setString(3, phone);
	          ps.setString(4, address);
	          result = ps.executeUpdate();
	          
	          conn.close();
	          ps.close();
	      } catch (Exception e) {
	      }
	     return result;
  	}
  	public OrderAddress getOrderAddress(int idO) {
  		String query = "select * from dbo.OrderAdderss where IdO = ?";
	      try {
	          conn = new DbContext().getConnection();//mo ket noi voi sql
	          ps = conn.prepareStatement(query);
	          ps.setInt(1, idO);
	          rs = ps.executeQuery();
	          while(rs.next()){
	        	  return new OrderAddress(rs.getInt(1),        			  
	        			  rs.getString(2),
	        			  rs.getString(3),
	        			  rs.getString(4));
	          }
	          conn.close();
	          ps.close();
	          rs.close();
	      } catch (Exception e) {
	      }
	      return null;
  	}
  	public int paymentProduct(Payment p) {
    	int result =0;
    	String query = "INSERT INTO dbo.Payment([IdO], [bankcode], [priceBank], [priceSum], [OrderInfo], [payDate]) VALUES(?, ?, ?, ?, ?, ?)";
	      try {
	          conn = new DbContext().getConnection();//mo ket noi voi sql
	          ps = conn.prepareStatement(query);
	          ps.setInt(1, p.getIdO());
	          ps.setString(2, p.getBankcode());
	          ps.setLong(3, p.getPriceBank());
	          ps.setLong(4, p.getPriceSum());
	          ps.setString(5, p.getOrderInfo());
	          ps.setDate(6, p.getPayDate());
	          result = ps.executeUpdate();
	          
	          conn.close();
	          ps.close();
	          rs.close();
	          
	      } catch (Exception e) {
	      }
	      return result;
    }
  	public List<Payment> getPayment (int idO) {
  		List<Payment> list = new ArrayList<>();
  		String query = "SELECT * FROM dbo.Payment WHERE idO = ?";
	      try {
	          conn = new DbContext().getConnection();//mo ket noi voi sql
	          ps = conn.prepareStatement(query);
	          ps.setInt(1, idO);
	          rs = ps.executeQuery();
	          while(rs.next()){
	        	  list.add(new Payment(rs.getInt(1),        			  
	        			  rs.getString(2),
	        			  rs.getLong(3),
	        			  rs.getLong(4),
	        			  rs.getString(5),
	        			  rs.getDate(6)));
	          }
	          conn.close();
	          ps.close();
	          rs.close();
	      } catch (Exception e) {
	      }
	      return list;
  	}
  	public static void main(String[] args) {
  		AccountDao dao = new AccountDao();
		System.out.println(dao.getOrderAccount("8"));
	}
}
