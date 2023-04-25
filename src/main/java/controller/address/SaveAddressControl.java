package controller.address;

import java.io.IOException;
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

@WebServlet(name="SaveAddressControl", urlPatterns = {"/save-address"})
public class SaveAddressControl extends HttpServlet {
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	response.setContentType("text/html;charset=UTF-8");
        
    }  
    @Override 
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	HttpSession session = request.getSession();
    	Account a = (Account) session.getAttribute("account");
    	if(a == null) {
    		
    		response.sendRedirect("login");
    	}
    	int idA = a.getIdA();
    	try { 
    		String name = request.getParameter("name");
    		String phone = request.getParameter("phone");
    		String nameAddress = request.getParameter("address");
    		AccountDao daoAccount = new AccountDao();
    		daoAccount.updateAddress(idA, name, phone, nameAddress);
    		try {
    			AccountDao daoA = new AccountDao();
    			CartSevice cartSevice = new CartSevice();
    			List<CartItem> listCartItems = cartSevice.getCartItemsFromCookiesAccount(idA, request);
    			List<CartItem> listCItemsNot = cartSevice.getCartItemsFromCookiesNotAccount(idA, request);
    			LocalDate localDate = LocalDate.now();
		        Date date = java.sql.Date.valueOf(localDate);
		        // thêm vào giỏ hàng
		        synchronized (daoA) {
		        	try {
		        		daoA.addOrder(date, idA);
		        		//mua ngay 
		                String pay_idp = (String)session.getAttribute("pay-idp");
		                String pay_quantity = (String)session.getAttribute("pay-quantity");
		                if(pay_idp!= null && pay_quantity!=null && !pay_idp.equals("") && !pay_quantity.equals("")) {
		                	try {
								
		                		DAO dao = new DAO();
		                		Product product = dao.getProductById(pay_idp);
		                		Order order = daoA.getOrderOneTop();
		                		OrderDetails orderDetails = new OrderDetails();
		                		orderDetails.setIdO(order.getIdO());
		                		orderDetails.setIdP(product.getIdP());
		                		orderDetails.setPrice(product.getPriceNew());
		                		orderDetails.setAmount(Integer.parseInt(pay_quantity));
		                		daoA.addOrderDetails(orderDetails);
							} catch (Exception e) {
							
							}
		                	
		                }else {
		                	
		                	for(CartItem i: listCartItems) {
		                		try {
		                			Order order = daoA.getOrderOneTop();
		                			OrderDetails orderDetails = new OrderDetails();
		                			orderDetails.setIdO(order.getIdO());
		                			orderDetails.setIdP(i.getProduct().getIdP());
		                			orderDetails.setPrice(i.getProduct().getPriceNew());
		                			orderDetails.setAmount(i.getQuantity());
		                			daoA.addOrderDetails(orderDetails);
		                			cartSevice.removeCookies(response);
		                			cartSevice.saveCartItemsToCookies(response, listCItemsNot);
		                		} catch (Exception e) {
		                			
		                		}
		                	}
		                }
		        		
		        		response.sendRedirect("home");
		        	} catch (Exception e) {
		        		
		        	}
		        	
		        }
    		}catch (Exception e) {
				
			}
    		
		} catch (Exception e) {
			request.setAttribute("messAddress", "Không thể thay đổi địa chỉ!");
			request.getRequestDispatcher("address").forward(request, response);
		}
    	
    }

}

