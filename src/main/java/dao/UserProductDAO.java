package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import context.DbContext;
import model.UserProduct;
import model.UserProductDetail;

public class UserProductDAO {
	Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
//    
    public List<UserProduct> getProductUser(int idA) {
        List<UserProduct> list = new ArrayList<UserProduct>();
        String query = "SELECT Product.IdP, [Order].idO, Product.NameP, [Order].CreatedDate, [OrderDetails].[Status]\r\n"
        		+ "FROM Product\r\n"
        		+ "INNER JOIN OrderDetails ON Product.IdP = OrderDetails.IdP\r\n"
        		+ "INNER JOIN [Order] ON OrderDetails.IdO = [Order].IdO\r\n"
        		+ "WHERE [Order].IdA = ?";
        try {
            conn = new DbContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setInt(1, idA);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new UserProduct(rs.getInt(1),
                		rs.getInt(2),
                        rs.getString(3),
                        rs.getDate(4),
                        rs.getInt(5)));
            }
            conn.close();
            ps.close();
            rs.close();
        } catch (Exception e) {
        }
        
        return list;
    }
    public UserProductDetail getProductUserDetail(int idP, int idO) {
       
        String query = "SELECT Product.idp, Product.NameP, Product.Origin, OrderDetails.IdO, OrderDetails.Amount, OrderDetails.Price, Product.imageP\r\n"
        		+ "FROM Product\r\n"
        		+ "INNER JOIN OrderDetails ON Product.IdP = OrderDetails.IdP\r\n"
        		+ "WHERE OrderDetails.IdO = ? and OrderDetails.IdP = ?";
        try {
            conn = new DbContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setInt(1, idO);
            ps.setInt(2, idP);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new UserProductDetail(rs.getInt(1),
                		rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getInt(5),
                        rs.getInt(6),
                        rs.getString(7));
            }
            conn.close();
            ps.close();
            rs.close();
        } catch (Exception e) {
        }
        
        return new UserProductDetail();
    }
    
    public static void main(String[] args) {
		UserProductDAO dao = new UserProductDAO();
		UserProductDetail u = dao.getProductUserDetail(2, 2);
		System.out.println(u);
	}
}
