package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import context.DbContext;
import model.AccountProduct;
import model.UserProduct;
import model.UserProductDetail;

public class UserProductDAO {
	Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
//    
    public List<UserProduct> getProductUser(int idA) {
        List<UserProduct> list = new ArrayList<UserProduct>();
        String query = "SELECT Product.IdP, [Order].idO, Product.NameP, Product.ImageP, [Order].CreatedDate, [OrderDetails].[Status], dbo.OrderDetails.Price, dbo.OrderDetails.Amount\r\n"
        		+ "FROM Product\r\n"
        		+ "JOIN OrderDetails ON Product.IdP = OrderDetails.IdP\r\n"
        		+ "JOIN [Order] ON OrderDetails.IdO = [Order].IdO\r\n"
        		+ "WHERE Product.[status] = 1 and [Order].IdA = ?";
        try {
            conn = new DbContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setInt(1, idA);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new UserProduct(rs.getInt(1),
                		rs.getInt(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getDate(5),
                        rs.getInt(6),
                        rs.getInt(7),
                        rs.getInt(8)));
            }
            conn.close();
            ps.close();
            rs.close();
        } catch (Exception e) {
        }
        
        return list;
    }
    public List<AccountProduct> getProductAdmin() {
        List<AccountProduct> list = new ArrayList<>();
        String query = "SELECT Product.IdP, [Order].idO, Product.NameP, Product.ImageP, [Order].CreatedDate, [OrderDetails].[Status], dbo.OrderDetails.Price, dbo.OrderDetails.Amount, Account.IdA\r\n"
        		+ "FROM Product\r\n"
        		+ "JOIN OrderDetails ON Product.IdP = OrderDetails.IdP\r\n"
        		+ "JOIN [Order] ON OrderDetails.IdO = [Order].IdO\r\n"
        		+ "JOIN dbo.Account ON Account.IdA = [Order].IdA\r\n"
        		+ "WHERE Product.[status] = 1 and OrderDetails.Status = 0 \r\n"
        		+ "ORDER BY Account.IdA";
        try {
            conn = new DbContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            //ps.setInt(1, idA);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new AccountProduct(rs.getInt(1),
                		rs.getInt(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getDate(5),
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
    public List<AccountProduct> getProductAdminOrderDetail(String idO) {
        List<AccountProduct> list = new ArrayList<>();
        String query = "SELECT Product.IdP, [Order].idO, Product.NameP, Product.ImageP, [Order].CreatedDate, [OrderDetails].[Status], dbo.OrderDetails.Price, dbo.OrderDetails.Amount, Account.IdA\r\n"
        		+ "FROM Product\r\n"
        		+ "JOIN OrderDetails ON Product.IdP = OrderDetails.IdP\r\n"
        		+ "JOIN [Order] ON OrderDetails.IdO = [Order].IdO and OrderDetails.Status =0\r\n"
        		+ "JOIN dbo.Account ON Account.IdA = [Order].IdA\r\n"
        		+ "WHERE Product.[status] = 1 and [Order].idO = ? \r\n";
        try {
            conn = new DbContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, idO);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new AccountProduct(rs.getInt(1),
                		rs.getInt(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getDate(5),
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
    public UserProductDetail getProductUserDetail(int idP, int idO) {
       
        String query = "SELECT Product.idp, Product.NameP, Product.Origin, OrderDetails.IdO, OrderDetails.Amount, OrderDetails.Price, Product.imageP, [OrderDetails].[Status]\r\n"
        		+ "FROM Product\r\n"
        		+ "INNER JOIN OrderDetails ON Product.IdP = OrderDetails.IdP\r\n"
        		+ "WHERE Product.[status] = 1 and OrderDetails.IdO = ? and OrderDetails.IdP = ?";
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
                        rs.getString(7),
                        rs.getInt(8));
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
