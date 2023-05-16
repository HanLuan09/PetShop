package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import context.DbContext;
import model.Product;
import model.ProductDetails;

public class ProductSortDao {
	Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
//  Lấy tất cả sản phẩm có số lượng bán
    public List<ProductDetails> getAllProductSumPrice() {
	      List<ProductDetails> list = new ArrayList<ProductDetails>();
	      String query = "SELECT Product.IdP ,\r\n"
		      		+ "	Product.NameP ,\r\n"
		      		+ "	Product.ImageP ,\r\n"
		      		+ "	Product.Describe ,\r\n"
		      		+ "	Product.Origin , \r\n"
		      		+ "	Product.Amount,\r\n"
		      		+ "	Product.Discount,\r\n"
		      		+ "	Product.Price,\r\n"
		      		+ "	Product.CateID,"
	      			+ "SUM(OrderDetails.Amount) As sumP\r\n"
	        		+ "FROM Product\r\n"
	        		+ "LEFT JOIN OrderDetails ON Product.IdP = OrderDetails.IdP\r\n"
	        		+ "GROUP BY Product.NameP, Product.ImageP, Product.IdP, Product.Origin, Product.Describe ,Product.Discount,  Product.Price, Product.Amount, Product.cateId\r\n";
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
	                      rs.getInt(10),0, 0));
	          }
	          conn.close();
	          ps.close();
	          rs.close();
	      } catch (Exception e) {
	      }
	      
	      return list;
    }
//  Lấy tất cả sản phẩm theo cate
	  public List<ProductDetails> getAllProductCid(String cid) {
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
	      		+ "SUM(od.Amount) AS TotalSold, CAST(AVG(rating * 1.0) AS DECIMAL(10, 1)) AS AverageRating , COUNT(pr.rating) AS TotalRating\r\n"
	      		+ "FROM Product p\r\n"
	      		+ "LEFT JOIN OrderDetails od ON p.IdP = od.IdP\r\n"
	      		+ "LEFT JOIN [Order] o ON o.IdO = od.IdO\r\n"
	      		+ "LEFT JOIN ProductRating pr ON pr.IdP = p.IdP AND pr.IdA = o.IdA and pr.idO =od.IdO\r\n"
	      		+ "where p.CateID = ?\r\n"
	      		+ "GROUP BY p.NameP, p.ImageP, p.IdP, p.Origin, p.Describe , p.Discount,  p.Price, p.Amount, p.cateId";
	      try {
	          conn = new DbContext().getConnection();//mo ket noi voi sql
	          ps = conn.prepareStatement(query);
	          ps.setString(1, cid);
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
	//  Lấy tất cả sản phẩm theo cate
		  public List<ProductDetails> getAllProductSearch(String search) {
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
		      		+ "LEFT JOIN Category ca ON ca.cateId = p.cateId\r\n"
		      		+ "where p.NameP like ? or ca.nameC like ?\r\n"
		      		+ "GROUP BY p.NameP, p.ImageP, p.IdP, p.Origin, p.Describe , p.Discount,  p.Price, p.Amount, p.cateId";
		      try {
		          conn = new DbContext().getConnection();//mo ket noi voi sql
		          ps = conn.prepareStatement(query);
		          ps.setString(1, "%"+search+"%");
		          ps.setString(2, "%"+search+"%");
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
    
//	Bán chạy
	public List<ProductDetails> getAllProductSelling() {
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
        		+ "SUM(od.Amount), CAST(AVG(rating * 1.0) AS DECIMAL(10, 1)) AS AverageRating, COUNT(pr.rating) AS TotalRating, (SUM(od.Amount) * 1.0 / p.Amount) as SalesRatio\r\n"
        		+ "FROM Product p\r\n"
        		+ "LEFT JOIN OrderDetails od ON p.IdP = od.IdP\r\n"
        		+ "LEFT JOIN [Order] o ON o.IdO = od.IdO\r\n"
        		+ "LEFT JOIN ProductRating pr ON pr.IdP = p.IdP AND pr.IdA = o.IdA and pr.idO =od.IdO\r\n"
        		+ "GROUP BY p.IdP, p.NameP, p.ImageP, p.Describe, p.Origin, p.Amount, p.Discount, p.Price, p.CateID\r\n"
        		+ "ORDER BY SalesRatio DESC";
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
//	mới nhất
	public List<ProductDetails> getAllProductLatest() {
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
        		+ "SUM(od.Amount), CAST(AVG(rating * 1.0) AS DECIMAL(10, 1)) AS AverageRating, COUNT(pr.rating) AS TotalRating\r\n"
        		+ "FROM Product p\r\n"
        		+ "LEFT JOIN OrderDetails od ON p.IdP = od.IdP\r\n"
        		+ "LEFT JOIN [Order] o ON o.IdO = od.IdO\r\n"
        		+ "LEFT JOIN ProductRating pr ON pr.IdP = p.IdP AND pr.IdA = o.IdA and pr.idO =od.IdO\r\n"
        		+ "GROUP BY p.IdP, p.NameP, p.ImageP, p.Describe, p.Origin, p.Amount, p.Discount, p.Price, p.CateID\r\n"
        		+ "ORDER BY p.idP DESC";
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
	
	public static void main(String[] args) {
		ProductSortDao dao= new ProductSortDao();
		List<ProductDetails> list = dao.getAllProductSearch("chó");
		for(ProductDetails o: list)
		System.out.println(o);
	}
}
