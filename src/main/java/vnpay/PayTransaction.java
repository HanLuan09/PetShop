package vnpay;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import context.DbContext;
import dao.AccountDao;
import dao.DAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Account;
import model.Address;
import model.CartItem;
import model.OrderDetails;
import model.Payment;
import model.Product;
import sevice.CartSevice;

public class PayTransaction {
	public void processRequest(HttpServletRequest request, HttpServletResponse response, Date sqlDate,
		Long vnp_amount, String vnp_BankCode, int check, String vnp_OrderInfo) throws ServletException, IOException {
//    Mua hàng thêm vào csld
    	HttpSession session = request.getSession();
    	Account a = (Account) session.getAttribute("account");
    	if(a == null) {
    		response.sendRedirect("login");
    	}
    	else {
    		int idA = a.getIdA();
    		try {
    			AccountDao daoA = new AccountDao();
    			CartSevice cartSevice = new CartSevice();
    			LocalDate localDate = LocalDate.now();
		        Date date = java.sql.Date.valueOf(localDate);
		        Connection connection = new DbContext().getConnection();                
		        synchronized (this) {
		            try {
		                // Thêm đơn hàng mới vào database
		                int idO = daoA.addOrder(date, idA);
		                if(idO == 0) {
		                	connection.rollback();
		                	response.sendRedirect("error.jsp");
		                	return;
		                }
		                		                
		                Address aRess = daoA.getAddress(idA);
		                if(aRess == null) {
		                	response.sendRedirect("error.jsp");
		                	return;
		                }
		                //insert db
		                int res = daoA.addOrderAddress(idO, aRess.getName(), aRess.getPhone(), aRess.getAddress());
		                if(res == 0) {
		                	connection.rollback();
		                	response.sendRedirect("error.jsp");
		                	return;
		                }
		                long sumPrice =0;
		                
		                //mua ngay 
		                String pay_idp = (String)session.getAttribute("pay-idp");
		                String pay_quantity = (String)session.getAttribute("pay-quantity");
		                if(pay_idp!= null && pay_quantity!=null && !pay_idp.equals("") && !pay_quantity.equals("")) {
		                	try {							
		                		DAO dao = new DAO();
		                		Product product = dao.getProductById(pay_idp);
		                		
		                		OrderDetails orderDetails = new OrderDetails();
		                		orderDetails.setIdO(idO);
		                		orderDetails.setIdP(product.getIdP());
		                		orderDetails.setPrice(product.getPriceNew());
		                		orderDetails.setAmount(Integer.parseInt(pay_quantity));
		                		//insert db
		                		int resful = daoA.addOrderDetails(orderDetails);
		                		sumPrice  = product.getPriceNew() * Integer.parseInt(pay_quantity);
		                		if(resful == 0) {
				                	connection.rollback();
				                	response.sendRedirect("error.jsp");
				                	return;
				                }
							} catch (Exception e) {
								connection.rollback();
								response.sendRedirect("error.jsp");
								return;
							}
		                	
		                }else {
		                	List<CartItem> listCartItems = cartSevice.getCartItemsFromCookiesAccount(idA, request);
		        			List<CartItem> listCItemsNot = cartSevice.getCartItemsFromCookiesNotAccount(idA, request);
		        			CartItem cartItem = new CartItem();
		        			sumPrice = cartItem.getSumPrice(listCartItems);
		                	// Lặp qua các mục trong giỏ hàng và thêm chi tiết đơn hàng tương ứng vào database
		                	for(CartItem i: listCartItems) {
		                		try {
		                			
		                			OrderDetails orderDetails = new OrderDetails();
		                			orderDetails.setIdO(idO);
		                			orderDetails.setIdP(i.getProduct().getIdP());
		                			orderDetails.setPrice(i.getProduct().getPriceNew());
		                			orderDetails.setAmount(i.getQuantity());
		                			int ans = daoA.addOrderDetails(orderDetails);
		                			if(ans == 0 ) {
		                				connection.rollback();
			                			response.sendRedirect("error.jsp");
			                			return;
		                			}
		                			// Xóa giỏ hàng và lưu lại các mục chưa đặt hàng vào cookie
		                			cartSevice.removeCookies(response);
		                			cartSevice.saveCartItemsToCookies(response, listCItemsNot);
		                		} catch (Exception e) {
		                			connection.rollback();
		                			response.sendRedirect("error.jsp");
		                			return;
		                		}
		                	}
		                }
		                session.removeAttribute("pay-idp");
		                session.removeAttribute("pay-quantity");
		                if(check == 1) {
		                	Payment payment = new Payment(idO, vnp_BankCode, vnp_amount, sumPrice, vnp_OrderInfo, sqlDate);		            
		                	int checkPayment = daoA.paymentProduct(payment);
		                	if(checkPayment== 0) {
		                		connection.rollback();
	                			response.sendRedirect("error.jsp");
	                			return;
		                	}
		                }
		                connection.commit();
		                //
		                request.setAttribute("vnp_PayDate", sqlDate);
		                request.setAttribute("vnp_amount",vnp_amount);
		                request.setAttribute("vnp_BankCode",vnp_BankCode);
		                request.setAttribute("idO", idO);
		                request.setAttribute("check", check);
		                request.setAttribute("sumPrice", sumPrice);
		                request.setAttribute("sum", sumPrice - vnp_amount);
		                request.getRequestDispatcher("payment.jsp").forward(request, response);;
		            } catch (Exception e) {
		            	connection.rollback();
		            	response.sendRedirect("error.jsp");
		            	return;
		            }
		        }
		        
    		}catch (Exception e) {
    			response.sendRedirect("error.jsp");
			}
		} 
 
    }

}
