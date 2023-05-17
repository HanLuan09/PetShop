package controller.account;

import java.io.IOException;
import java.util.List;

import dao.RatingDao;
import dao.UserProductDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Account;
import model.RatingProduct;
import model.UserProduct;
import model.UserProductDetail;


@WebServlet(name = "OrderDetailControl", urlPatterns = {"/order-detail"})
public class OrderDetailControl extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	response.setContentType("text/html;charset=UTF-8");
    	HttpSession session = request.getSession();
    	Account account = (Account) session.getAttribute("account");
    	if(account==null) {
    		response.sendRedirect("login");
    	}else {
    		int idA = account.getIdA();
    		int idP = Integer.parseInt(request.getParameter("idp"));
    		int idO = Integer.parseInt(request.getParameter("ido"));
    		RatingDao daoRating = new RatingDao();
    		UserProductDAO daoUser = new UserProductDAO();
    		UserProductDetail uDetail = daoUser.getProductUserDetail(idP, idO);
    		RatingProduct rProduct = daoRating.getRatingProduct(idP, idA, idO);
    		int timeR = daoRating.timeRating(idA, idO, idP);
    		request.setAttribute("timeR", timeR);
    		request.setAttribute("uDetail", uDetail);
    		request.setAttribute("rProduct", rProduct);
    		request.getRequestDispatcher("user_product_details.jsp").forward(request, response);
    	}
    	
    }
    
}


