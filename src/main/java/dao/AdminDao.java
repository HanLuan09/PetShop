package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import context.DbContext;
import model.AdminProduct;

public class AdminDao {
	Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
//    
    public List<AdminProduct> getAllProductCate() {
        List<AdminProduct> list = new ArrayList<AdminProduct>();
        String query = "SELECT Product.IdP AS 'pID',\r\n"
        		+ "        		Product.NameP AS 'pName',\r\n"
        		+ "        		Category.NameC AS 'cName',\r\n"
        		+ "        		Product.Amount AS 'pAmount',\r\n"
        		+ "        		Product.Price AS 'pPrice',\r\n"
        		+ "        		Product.Discount AS 'pDiscount',\r\n"
        		+ "        		SUM(OrderDetails.Amount) AS 'sumPrice'\r\n"
        		+ "        		FROM Product\r\n"
        		+ "        		INNER JOIN Category ON Product.CateID = Category.CateID\r\n"
        		+ "        		LEFT JOIN OrderDetails ON Product.IdP = OrderDetails.IdP\r\n"
        		+ "        		where Product.[status] = 1\r\n"
        		+ "        		GROUP BY Product.NameP, Product.IdP, Category.NameC, Product.Price, Product.Amount, Product.Discount";
        try {
            conn = new DbContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new AdminProduct(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getInt(5),
                        rs.getInt(6),
                        rs.getInt(7)));
            }
            conn.close();
            ps.close();
            rs.close();
        } catch (Exception e) {
        }
        
        return list;
    }
    
    public List<AdminProduct> getAllProductSearch(String s) {
        List<AdminProduct> list = new ArrayList<AdminProduct>();
        
        String query = "SELECT Product.IdP AS 'pID',\r\n"
        		+ "        		Product.NameP AS 'pName',\r\n"
        		+ "        		 Category.NameC AS 'cName',\r\n"
        		+ "        		Product.Amount AS 'pAmount',\r\n"
        		+ "        		Product.Price AS 'pPrice',\r\n"
        		+ "        		Product.Discount AS 'pDiscount',\r\n"
        		+ "        		SUM(OrderDetails.Amount) AS 'sumPrice'\r\n"
        		+ "        		FROM Product\r\n"
        		+ "        		INNER JOIN Category ON Product.CateID = Category.CateID\r\n"
        		+ "        		LEFT JOIN OrderDetails ON Product.IdP = OrderDetails.IdP\r\n"
        		+ "        		where Product.[status] = 1 and (Category.NameC like ? or  Product.NameP like ?)\r\n"
        		+ "        		GROUP BY Product.NameP, Product.IdP, Category.NameC, Product.Price, Product.Amount, Product.Discount";
   
        try {
            conn = new DbContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, "%"+s+"%");
            ps.setString(2, "%"+s+"%");
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new AdminProduct(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getInt(5),
                        rs.getInt(6),
                        rs.getInt(7)));
            }
            conn.close();
            ps.close();
            rs.close();
        } catch (Exception e) {
        }
        
        return list;
    } 
    
    public static void main(String[] args) {
		AdminDao dao = new AdminDao();
		List<AdminProduct> list = dao.getAllProductSearch("cho");
		
		for(AdminProduct o: list) {
			System.out.println(o);
		}
	}
}
