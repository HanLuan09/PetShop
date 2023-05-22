package controller.admin;

import java.io.IOException;
import java.util.List;

import dao.AccountDao;
import dao.UserProductDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Account;
import model.AccountProduct;
import model.Address;
import model.OrderAddress;
import model.Payment;

@WebServlet(name = "AdminOrderControl", urlPatterns = {"/order-confirm"})
public class AdminOrderControl extends HttpServlet {
	//Trang xem chi tiết mã đặt hàng
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
    	Account a = (Account) session.getAttribute("account");
    	if(a==null) {
    		response.sendRedirect("login");
    		return;
    	}else if(a.getIsAdmin()!=1) {
    		response.sendRedirect("login");
    		return;
    	}
        try {
			
        	String idO = request.getParameter("dio");
        	AccountDao daoAccountDao = new AccountDao();
        	//int idA = daoAccountDao.getOrderAccount(idO);
        	OrderAddress aRess = daoAccountDao.getOrderAddress(Integer.parseInt(idO));
        	UserProductDAO daoU = new UserProductDAO();
        	
        	List<Payment> payment = daoAccountDao.getPayment(Integer.parseInt(idO));        	
        	List<AccountProduct> listODetails = daoU.getProductAdminOrderDetail(idO);
        	AccountProduct aP = new AccountProduct();
        	long x = (new Payment()).sumOrderPrice(payment);
        	request.setAttribute("payment", x);
        	request.setAttribute("payments", aP.getTongPrice(listODetails) - x);
        	request.setAttribute("listODetails", listODetails);
        	request.setAttribute("address", aRess);
        	request.setAttribute("ido", idO);
        	
        	request.setAttribute("sumPrice", aP.getTongPrice(listODetails));
        	request.getRequestDispatcher("order_confirmation.jsp").forward(request, response);
		} catch (Exception e) {
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}
        
    }

}
