package controller.account;

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
import model.Address;
import model.UserProduct;


@WebServlet(name = "OrderControl", urlPatterns = {"/order"})
public class OrderControl extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	response.setContentType("text/html;charset=UTF-8");
    	HttpSession session = request.getSession();
    	Account a = (Account) session.getAttribute("account");
    	if(a == null) {
    		response.sendRedirect("login");
    	}
    	int idA = a.getIdA();
    	AccountDao daoA = new AccountDao();
    	UserProductDAO daoUser = new UserProductDAO();
    	List<UserProduct> listUserProducts = daoUser.getProductUser(idA);
    	Account account = daoA.checkAccount(a.getUsername());
    	Address address = daoA.getAddress(idA);
    	request.setAttribute("listUserProducts", listUserProducts);
    	request.setAttribute("account", account);
    	request.setAttribute("address", address);
		request.getRequestDispatcher("user_product.jsp").forward(request, response);
    	
    }
    
}


