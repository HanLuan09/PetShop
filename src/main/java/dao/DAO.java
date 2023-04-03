package dao;

import java.sql.*;
import java.util.*;
import model.*;
import context.*;

public class DAO {
	Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
//    Lấy tất cả sản phẩm
    public List<Product> getAllProduct() {
        List<Product> list = new ArrayList<Product>();
        String query = "select * from Product";
        try {
            conn = new DbContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getInt(7),
                        rs.getInt(8),
                        rs.getInt(9), 0));
            }
            conn.close();
            ps.close();
            rs.close();
        } catch (Exception e) {
        }
        
        return list;
    }

//  Lấy tất cả chó cưng
	  public List<Product> getAllProductDog() {
	      List<Product> list = new ArrayList<Product>();
	      String query = "select * from Product where CateID=1";
	      try {
	          conn = new DbContext().getConnection();//mo ket noi voi sql
	          ps = conn.prepareStatement(query);
	          rs = ps.executeQuery();
	          while (rs.next()) {
	              list.add(new Product(rs.getInt(1),
	                      rs.getString(2),
	                      rs.getString(3),
	                      rs.getString(4),
	                      rs.getString(5),
	                      rs.getInt(6),
	                      rs.getInt(7),
	                      rs.getInt(8),
	                      rs.getInt(9), 0));
	          }
	          conn.close();
	          ps.close();
	          rs.close();
	      } catch (Exception e) {
	      }
	      
	      return list;
	  }
//    Lấy tất cả sản phẩm Cat
	    public List<Product> getAllProductCat() {
	        List<Product> list = new ArrayList<Product>();
	        String query = "select * from Product where CateID=2";
	        try {
	            conn = new DbContext().getConnection();//mo ket noi voi sql
	            ps = conn.prepareStatement(query);
	            rs = ps.executeQuery();
	            while (rs.next()) {
	                list.add(new Product(rs.getInt(1),
	                        rs.getString(2),
	                        rs.getString(3),
	                        rs.getString(4),
	                        rs.getString(5),
	                        rs.getInt(6),
	                        rs.getInt(7),
	                        rs.getInt(8),
	                        rs.getInt(9), 0));
	            }
	            conn.close();
	            ps.close();
	            rs.close();
	        } catch (Exception e) {
	        }
	        
	        return list;
	    }
//	    Lấy tất cả sản phẩm còn lại 
	    public List<Product> getAllProductRemaining() {
	        List<Product> list = new ArrayList<Product>();
	        String query = "select * from Product\r\n"
	        		+ "EXCEPT select * from Product where CateID=1\r\n"
	        		+ "EXCEPT select * from Product where CateID=2";
	        try {
	            conn = new DbContext().getConnection();//mo ket noi voi sql
	            ps = conn.prepareStatement(query);
	            rs = ps.executeQuery();
	            while (rs.next()) {
	                list.add(new Product(rs.getInt(1),
	                        rs.getString(2),
	                        rs.getString(3),
	                        rs.getString(4),
	                        rs.getString(5),
	                        rs.getInt(6),
	                        rs.getInt(7),
	                        rs.getInt(8),
	                        rs.getInt(9), 0));
	            }
	            conn.close();
	            ps.close();
	            rs.close();
	        } catch (Exception e) {
	        }
	        
	        return list;
	    }

//    end lấy tất cả sản phẩm
	  
//    Lấy tất cả danh mục
    public List<Category> getAllCategory() {
        List<Category> list = new ArrayList<Category>();
        String query = "select * from Category";
        try {
            conn = new DbContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Category(rs.getInt(1),
                        rs.getString(2)));
            }
        } catch (Exception e) {
        }
        return list;
    }
    public List<Category> getCategoryExecpt(String cate) {
    	List<Category> list = new ArrayList<Category>();
    	String query = "SELECT *\r\n"
    			+ "FROM Category\r\n"
    			+ "ORDER BY \r\n"
    			+ "	CASE \r\n"
    			+ "		WHEN CateID = ? THEN 0\r\n"
    			+ "		ELSE 1 \r\n"
    			+ "	END, CateID";
    	try {
    		conn = new DbContext().getConnection();//mo ket noi voi sql
    		ps = conn.prepareStatement(query);
    		ps.setString(1, cate);
    		rs = ps.executeQuery();
    		while (rs.next()) {
    			list.add(new Category(rs.getInt(1), rs.getString(2)));
    		}
    	} catch (Exception e) {
    	}
    	return list;
	}
//    end lấy tất cả danh mục
//    Lấy 1 sản phẩm
    public Product getProductById(String id) {
    	String query = "select * from product\n"
                + "where idp = ?";
        try {
            conn = new DbContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getInt(7),
                        rs.getInt(8),
                        rs.getInt(9), 0);
            }
            conn.close();
            ps.close();
            rs.close();
        } catch (Exception e) {
        }
        return null;
    }
//    end lấy 1 sản phẩm
//    số sản phẩm đã bán
    public int getNumberOfProductsSold(String idP) {
    	String query = "SELECT SUM(OrderDetails.Amount) AS 'sumPrice'\r\n"
    			+ "FROM Product\r\n"
    			+ "LEFT JOIN OrderDetails ON Product.IdP = OrderDetails.IdP\r\n"
    			+ "where  Product.IdP = ?";
        try {
            conn = new DbContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, idP);
            rs = ps.executeQuery();
            while (rs.next()) {
            	return rs.getInt(1);
            }
            conn.close();
            ps.close();
            rs.close();
        } catch (Exception e) {
        }
        return 0;
    }
//    thêm mới
    public int addProduct(Product p) {
    	int result = 0;
    	String query = "INSERT INTO DBO.Product([NameP], [ImageP], [Describe], [Origin], [Amount], [Discount], [Price], [CateID]) \r\n"
    			+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            conn = new DbContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, p.getNameP());
            ps.setString(2, p.getImageP());
            ps.setString(3, p.getDescribe());
            ps.setString(4, p.getOrigin());
            ps.setInt(5, p.getAmount());
            ps.setInt(6, p.getDiscount());
            ps.setInt(7, p.getPrice());
            ps.setInt(8, p.getCateId());
            result = ps.executeUpdate();
            
            conn.close();
            ps.close();
           
        } catch (Exception e) {
        }
        return result;
    }
//    update
    public int updateProduct(Product p) {
    	int result = 0;
    	String query = "UPDATE DBO.Product SET [NameP] = ?, [ImageP] = ?, [Describe] =?, [Origin] =?, [Amount] =?, [Discount] =?, [Price]= ?, [CateID] =? \r\n"
    			+ "WHERE idP =?";
        try {
            conn = new DbContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, p.getNameP());
            ps.setString(2, p.getImageP());
            ps.setString(3, p.getDescribe());
            ps.setString(4, p.getOrigin());
            ps.setInt(5, p.getAmount());
            ps.setInt(6, p.getDiscount());
            ps.setInt(7, p.getPrice());
            ps.setInt(8, p.getCateId());
            ps.setInt(9, p.getIdP());
            result = ps.executeUpdate();
            
            conn.close();
            ps.close();
           
        } catch (Exception e) {
        }
        return result;
    }
    
//    Size
    public List<Size> getSizes(String idP) {
    	List<Size> list = new ArrayList<Size>();
        String query = "select * from Size where idp = ?";
        try {
            conn = new DbContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, idP);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Size( rs.getInt(1), rs.getString(2), rs.getInt(3)));
            }
            conn.close();
            ps.close();
            rs.close();
        } catch (Exception e) {
        }
        return list;
    }
//    end size
//  Color
    public List<Color> getColors(String idP) {
	  	List<Color> list = new ArrayList<Color>();
	      String query = "select * from Color where IdP = ?";
	      try {
	          conn = new DbContext().getConnection();//mo ket noi voi sql
	          ps = conn.prepareStatement(query);
	          ps.setString(1, idP);
	          rs = ps.executeQuery();
	          while (rs.next()) {
	              list.add(new Color( rs.getInt(1), rs.getString(2), rs.getInt(3)));
	          }
	          conn.close();
	          ps.close();
	          rs.close();
	      } catch (Exception e) {
	      }
	      return list;
    }
//  end color
//    xóa sản phẩm
    public void deleteProduct(String id) {
    	String query = "DELETE from Product where idp = ?";
	      try {
	          conn = new DbContext().getConnection();//mo ket noi voi sql
	          ps = conn.prepareStatement(query);
	          ps.setString(1, id);
	          ps.executeUpdate();
	          
	          conn.close();
	          ps.close();
	          rs.close();
	          
	      } catch (Exception e) {
	      }
    }
//    check tên sản phẩm có trùng không
    public Product checkNameProduct(String name) {
    	String query = "select * from Product where NameP = ?";
	      try {
	          conn = new DbContext().getConnection();//mo ket noi voi sql
	          ps = conn.prepareStatement(query);
	          ps.setString(1, name);
	          rs = ps.executeQuery();
	          while (rs.next()) {
	        	  return new Product(rs.getInt(1),
	                        rs.getString(2),
	                        rs.getString(3),
	                        rs.getString(4),
	                        rs.getString(5),
	                        rs.getInt(6),
	                        rs.getInt(7),
	                        rs.getInt(8),
	                        rs.getInt(9), 0);
	          }
	          conn.close();
	          ps.close();
	          rs.close();
	      } catch (Exception e) {
	      }
	      return null;
    }
    public static void main(String[] args) {
        DAO dao = new DAO();
        
        Product p = dao.checkNameProduct("Chó Corgi");
        int x = dao.getNumberOfProductsSold("2");
        System.out.println(p);
//        for(Product o: listP) {
//        	System.out.println(o);
//        }
    }
}
