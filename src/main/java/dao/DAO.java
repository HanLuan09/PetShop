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
        String query = "select * from Product WHERE [status] = 1";
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
                        rs.getInt(9)));
            }
            conn.close();
            ps.close();
            rs.close();
        } catch (Exception e) {
        }
        
        return list;
    }

//  Lấy tất cả chó mèo cưng
	  public List<Product> getAllProductDogCat() {
	      List<Product> list = new ArrayList<Product>();
	      String query = "select * from Product WHERE [status] = 1 and (CateID=1 or CateID=2)";
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
	                      rs.getInt(9)));
	          }
	          conn.close();
	          ps.close();
	          rs.close();
	      } catch (Exception e) {
	      }
	      
	      return list;
	  }

//	    Lấy tất cả sản phẩm còn lại 
	    public List<ProductDetails> getAllProductRemaining() {
	        List<ProductDetails> list = new ArrayList<ProductDetails>();
	        String query = "SELECT p.IdP ,\r\n"
	        		+ "	p.NameP ,\r\n"
	        		+ "	p.ImageP ,\r\n"
	        		+ "	p.Describe ,\r\n"
	        		+ "	p.Origin , \r\n"
	        		+ "	p.Amount,\r\n"
	        		+ "	p.Discount,\r\n"
	        		+ "	p.Price,\r\n"
	        		+ "	p.CateID,"
	        		+ "SUM(od.Amount) AS TotalSold, CAST(AVG(rating * 1.0) AS DECIMAL(10, 1)) AS AverageRating, COUNT(pr.rating) AS TotalRating\r\n"
	        		+ "FROM Product p\r\n"
	        		+ "LEFT JOIN OrderDetails od ON p.IdP = od.IdP\r\n"
	        		+ "LEFT JOIN [Order] o ON o.IdO = od.IdO\r\n"
	        		+ "LEFT JOIN ProductRating pr ON pr.IdP = p.IdP AND pr.IdA = o.IdA and pr.idO =od.IdO\r\n"
	        		+ "WHERE p.[status] = 1\r\n"
	        		+ "GROUP BY p.NameP, p.ImageP, p.IdP, p.Origin, p.Describe , p.Discount,  p.Price, p.Amount, p.cateId";
	        try {
	            conn = new DbContext().getConnection();//mo ket noi voi sql
	            ps = conn.prepareStatement(query);
	            rs = ps.executeQuery();
	            while (rs.next()) {
	                list.add(new ProductDetails(rs.getInt(1),
	                        rs.getString(2),
	                        rs.getString(3),
	                        rs.getString(4),
	                        rs.getString(5),
	                        rs.getInt(6),
	                        rs.getInt(7),
	                        rs.getInt(8),
	                        rs.getInt(9),
	                        rs.getInt(10),
	                        rs.getFloat(11),
	                        rs.getInt(12)));
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
    	String query = "SELECT * FROM Product where [status] = 1 and idp = ?";
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
                        rs.getInt(9));
            }
            conn.close();
            ps.close();
            rs.close();
        } catch (Exception e) {
        }
        return null;
    }
    public ProductDetails getProductDetailById(String id) {
    	String query = "SELECT p.IdP,\r\n"
    			+ "	p.NameP ,\r\n"
    			+ "	p.ImageP ,\r\n"
    			+ "	p.Describe ,\r\n"
    			+ "	p.Origin , \r\n"
    			+ "	p.Amount,\r\n"
    			+ "	p.Discount,\r\n"
    			+ "	p.Price,\r\n"
    			+ "	p.CateID, "
    			+ "SUM(od.Amount) AS TotalSold, CAST(AVG(rating * 1.0) AS DECIMAL(10, 1)) AS AverageRating, COUNT(pr.rating) AS TotalRating\r\n"
    			+ "FROM Product p\r\n"
    			+ "LEFT JOIN OrderDetails od ON p.IdP = od.IdP\r\n"
    			+ "LEFT JOIN [Order] o ON o.IdO = od.IdO\r\n"
    			+ "LEFT JOIN ProductRating pr ON pr.IdP = p.IdP AND pr.IdA = o.IdA and pr.idO =od.IdO\r\n"
    			+ "WHERE p.[status] = 1 and p.idp = ?\r\n"
    			+ "GROUP BY p.NameP, p.ImageP, p.IdP, p.Origin, p.Describe , p.Discount, p.Price, p.Amount, p.cateId";
    	
        try {
            conn = new DbContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new ProductDetails(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getInt(7),
                        rs.getInt(8),
                        rs.getInt(9),
                        rs.getInt(10),
                        rs.getFloat(11),
                        rs.getInt(12));
            }
            conn.close();
            ps.close();
            rs.close();
        } catch (Exception e) {
        }
        return null;
    }
//    end lấy 1 sản phẩm

//    thêm mới
    public int addProduct(Product p) {
    	int result = 0;
    	String query = "INSERT INTO DBO.Product([NameP], [ImageP], [Describe], [Origin], [Amount], [Discount], [Price], [CateID], [status]) \r\n"
    			+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?, 1)";
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
    public void removeProduct(String id) {
    	String query = "UPDATE dbo.Product SET [status] = 0 WHERE IdP =?";
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
	  public int countProduct() {
	  	String query = "select count(idp) from Product WHERE [status] = 1";
		      try {
		          conn = new DbContext().getConnection();//mo ket noi voi sql
		          ps = conn.prepareStatement(query);
		        
		          rs = ps.executeQuery();
		          while(rs.next()) {
		        	  return rs.getInt(1);
		          }
		          conn.close();
		          ps.close();
		          rs.close();
		          
		      } catch (Exception e) {
		      }
		      return 0;
	  }
//    check tên sản phẩm có trùng không
    public Product checkNameProduct(String name, int id) {
    	String query = "select * from Product where NameP = ? and idP <> ?";
	      try {
	          conn = new DbContext().getConnection();//mo ket noi voi sql
	          ps = conn.prepareStatement(query);
	          ps.setString(1, name);
	          ps.setInt(2, id);
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
	                        rs.getInt(9));
	          }
	          conn.close();
	          ps.close();
	          rs.close();
	      } catch (Exception e) {
	      }
	      return null;
    }
    public int remainingProducts(int idP) {
    	String query = "SELECT P.Amount - COALESCE(SUM(OD.Amount), 0) AS Remaining\r\n"
    			+ "FROM Product AS P\r\n"
    			+ "LEFT JOIN OrderDetails AS OD ON P.IdP = OD.IdP\r\n"
    			+ "WHERE P.[status] = 1 and P.IdP = ?\r\n"
    			+ "GROUP BY P.Amount;";
	      try {
	          conn = new DbContext().getConnection();//mo ket noi voi sql
	          ps = conn.prepareStatement(query);
	          ps.setInt(1, idP);
	          rs = ps.executeQuery();
	          while(rs.next()) {
	        	  return rs.getInt(1);
	          }
	          conn.close();
	          ps.close();
	          rs.close();
	          
	      } catch (Exception e) {
	      }
	      return 0;
    }
    
    public static void main(String[] args) {
        DAO dao = new DAO();
        
        List<ProductDetails> listp = dao.getAllProductRemaining();
        for(ProductDetails o : listp) {
        	System.out.println(o);
        }
        
    }
}
