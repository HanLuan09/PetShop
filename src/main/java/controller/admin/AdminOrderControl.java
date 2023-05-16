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

@WebServlet(name = "AdminOrderControl", urlPatterns = {"/order-confirm"})
public class AdminOrderControl extends HttpServlet {
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
    	Account a = (Account) session.getAttribute("account");
    	if(a==null) {
    		response.sendRedirect("login");
    	}
        try {
			
        	String idO = request.getParameter("dio");
        	AccountDao daoAccountDao = new AccountDao();
        	int idA = daoAccountDao.getOrderAccount(idO);
        	Address aRess = daoAccountDao.getAddress(idA);
        	UserProductDAO daoU = new UserProductDAO();
        	
        	List<AccountProduct> listODetails = daoU.getProductAdminOrderDetail(idO);
        	request.setAttribute("listODetails", listODetails);
        	request.setAttribute("address", aRess);
        	request.setAttribute("ido", idO);
        	AccountProduct aP = new AccountProduct();
        	request.setAttribute("sumPrice", aP.getTongPrice(listODetails));
        	request.getRequestDispatcher("order_confirmation.jsp").forward(request, response);
		} catch (Exception e) {
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}
        
    }

}
