package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import context.DbContext;
import model.Product;

public class ProductSortDao {
	Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
//  Lấy tất cả sản phẩm có số lượng bán
    public List<Product> getAllProductSumPrice() {
	      List<Product> list = new ArrayList<Product>();
	      String query = "SELECT Product.*, SUM(OrderDetails.Amount) As sumP\r\n"
	        		+ "FROM Product\r\n"
	        		+ "LEFT JOIN OrderDetails ON Product.IdP = OrderDetails.IdP\r\n"
	        		+ "GROUP BY Product.NameP, Product.ImageP, Product.IdP, Product.Origin, Product.Describe ,Product.Discount,  Product.Price, Product.Amount, Product.cateId\r\n";
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
	                      rs.getInt(9),
	                      rs.getInt(10)));
	          }
	          conn.close();
	          ps.close();
	          rs.close();
	      } catch (Exception e) {
	      }
	      
	      return list;
    }
//  Lấy tất cả sản phẩm theo cate
	  public List<Product> getAllProductCid(String cid) {
	      List<Product> list = new ArrayList<Product>();
	      String query = "SELECT Product.*, SUM(OrderDetails.Amount) As sumP\r\n"
	      		+ "FROM Product\r\n"
	      		+ "LEFT JOIN OrderDetails ON Product.IdP = OrderDetails.IdP\r\n"
	      		+ "where Product.CateID = ?\r\n"
	      		+ "GROUP BY Product.NameP, Product.ImageP, Product.IdP, Product.Origin, Product.Describe ,Product.Discount,  Product.Price, Product.Amount, Product.cateId\r\n"
	      		+ "ORDER BY SUM(OrderDetails.Amount) DESC";
	      try {
	          conn = new DbContext().getConnection();//mo ket noi voi sql
	          ps = conn.prepareStatement(query);
	          ps.setString(1, cid);
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
	                      rs.getInt(9),
	                      rs.getInt(10)));
	          }
	          conn.close();
	          ps.close();
	          rs.close();
	      } catch (Exception e) {
	      }
	      return list;
	  }
    //phổ biên
	public List<Product> getAllProductPopular() {
        List<Product> list = new ArrayList<Product>();
        String query = "SELECT Product.*, SUM(OrderDetails.Amount) As sumP\r\n"
        		+ "FROM Product\r\n"
        		+ "LEFT JOIN OrderDetails ON Product.IdP = OrderDetails.IdP\r\n"
        		+ "GROUP BY Product.NameP, Product.ImageP, Product.IdP, Product.Origin, Product.Describe ,Product.Discount,  Product.Price, Product.Amount, Product.cateId\r\n"
        		+ "ORDER BY SUM(OrderDetails.Amount) DESC";
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
                        rs.getInt(9),
                        rs.getInt(10)));
                
            }
            conn.close();
            ps.close();
            rs.close();
        } catch (Exception e) {
        }
        
        return list;
    }
//	Bán chạy
	public List<Product> getAllProductSelling() {
        List<Product> list = new ArrayList<Product>();
        String query = "SELECT p.*, SUM(od.Amount), (SUM(od.Amount) * 1.0 / p.Amount) as SalesRatio\r\n"
        		+ "FROM Product p\r\n"
        		+ "LEFT JOIN OrderDetails od ON p.IdP = od.IdP\r\n"
        		+ "GROUP BY p.IdP, p.NameP, p.ImageP, p.Describe, p.Origin, p.Amount, p.Discount, p.Price, p.CateID\r\n"
        		+ "ORDER BY SalesRatio DESC";
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
                        rs.getInt(9),
                        rs.getInt(10)));
            }
            conn.close();
            ps.close();
            rs.close();
        } catch (Exception e) {
        }
        
        return list;
    }
//	mới nhất
	public List<Product> getAllProductLatest() {
        List<Product> list = new ArrayList<Product>();
        
        String query = "SELECT p.*, SUM(od.Amount)\r\n"
        		+ "FROM Product p\r\n"
        		+ "LEFT JOIN OrderDetails od ON p.IdP = od.IdP\r\n"
        		+ "GROUP BY p.IdP, p.NameP, p.ImageP, p.Describe, p.Origin, p.Amount, p.Discount, p.Price, p.CateID\r\n"
        		+ "ORDER BY p.idP DESC";
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
                        rs.getInt(9),
                        rs.getInt(10)));
            }
            conn.close();
            ps.close();
            rs.close();
        } catch (Exception e) {
        }
        
        return list;
    }
//	giá từ thấp đến cao
	public List<Product> getAllProductLowtoHigh() {
        List<Product> list = new ArrayList<Product>();
        
        String query = "SELECT p.*, SUM(od.Amount)\r\n"
        		+ "FROM Product p\r\n"
        		+ "LEFT JOIN OrderDetails od ON p.IdP = od.IdP\r\n"
        		+ "GROUP BY p.IdP, p.NameP, p.ImageP, p.Describe, p.Origin, p.Amount, p.Discount, p.Price, p.CateID\r\n"
        		+ "ORDER BY (p.Price - (p.Price * (p.Discount / 100.0)))";
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
                        rs.getInt(9),
                        rs.getInt(10)));
            }
            conn.close();
            ps.close();
            rs.close();
        } catch (Exception e) {
        }
        
        return list;
    }
//	cao đến thấp
	public List<Product> getAllProductHightoLow() {
        List<Product> list = new ArrayList<Product>();
        
        String query = "SELECT p.*, SUM(od.Amount)\r\n"
        		+ "FROM Product p\r\n"
        		+ "LEFT JOIN OrderDetails od ON p.IdP = od.IdP\r\n"
        		+ "GROUP BY p.IdP, p.NameP, p.ImageP, p.Describe, p.Origin, p.Amount, p.Discount, p.Price, p.CateID\r\n"
        		+ "ORDER BY (p.Price - (p.Price * (p.Discount / 100.0))) DESC";
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
                        rs.getInt(9),
                        rs.getInt(10)));
            }
            conn.close();
            ps.close();
            rs.close();
        } catch (Exception e) {
        }
        
        return list;
    }
	
	public static void main(String[] args) {
		
	}
}
