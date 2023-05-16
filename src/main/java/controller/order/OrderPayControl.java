package controller.order;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import dao.AccountDao;
import dao.DAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Account;
import model.CartItem;
import model.Order;
import model.OrderDetails;
import model.Product;
import sevice.CartSevice;

@WebServlet(name="OrderPayControl", urlPatterns = {"/order-pay"})
public class OrderPayControl extends HttpServlet {
    @Override 
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
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
		        synchronized (this) {
		            try {
		                // Thêm đơn hàng mới vào database
		                int idO = daoA.addOrder(date, idA);
		                if(idO == 0) {
		                	request.getRequestDispatcher("error.jsp").forward(request, response);
		                	return;
		                }
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
		                		daoA.addOrderDetails(orderDetails);
							} catch (Exception e) {
								request.getRequestDispatcher("error.jsp").forward(request, response);
							}
		                	
		                }else {
		                	List<CartItem> listCartItems = cartSevice.getCartItemsFromCookiesAccount(idA, request);
		        			List<CartItem> listCItemsNot = cartSevice.getCartItemsFromCookiesNotAccount(idA, request);
		                	// Lặp qua các mục trong giỏ hàng và thêm chi tiết đơn hàng tương ứng vào database
		                	for(CartItem i: listCartItems) {
		                		try {
		                			
		                			OrderDetails orderDetails = new OrderDetails();
		                			orderDetails.setIdO(idO);
		                			orderDetails.setIdP(i.getProduct().getIdP());
		                			orderDetails.setPrice(i.getProduct().getPriceNew());
		                			orderDetails.setAmount(i.getQuantity());
		                			daoA.addOrderDetails(orderDetails);
		                			
		                			// Xóa giỏ hàng và lưu lại các mục chưa đặt hàng vào cookie
		                			cartSevice.removeCookies(response);
		                			cartSevice.saveCartItemsToCookies(response, listCItemsNot);
		                		} catch (Exception e) {
		                			request.getRequestDispatcher("error.jsp").forward(request, response);
		                		}
		                	}
		                }
		                session.removeAttribute("pay-idp");
		                session.removeAttribute("pay-quantity");
		                
		                response.sendRedirect("home");
		            } catch (Exception e) {
		            	request.getRequestDispatcher("error.jsp").forward(request, response);
		            }
		        }
		        
    		}catch (Exception e) {
    			request.getRequestDispatcher("error.jsp").forward(request, response);
			}
		} 
 
    }
}

