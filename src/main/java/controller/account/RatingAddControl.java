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
import model.UserProduct;


@WebServlet(name = "RatingAddControl", urlPatterns = {"/rating-add"})
public class RatingAddControl extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	response.setContentType("text/html;charset=UTF-8");
    	HttpSession session = request.getSession();
    	Account a = (Account) session.getAttribute("account");
    	if(a == null) {
    		response.sendRedirect("login");
    	}else {
    		String idO = request.getParameter("ido");
    		int idP = Integer.parseInt(request.getParameter("idp"));
    		try {
    			int idA = a.getIdA();
    			int rating = Integer.parseInt(request.getParameter("rating"));
    			String comment = request.getParameter("comment");
    			if(0 >= rating || rating >5) rating = 0;
    			if(!comment.trim().equals("")) {
    				RatingDao daoRating = new RatingDao();
    				daoRating.addRatingProduct(idP, idA, rating, comment);
    			}
    		} catch (Exception e) {
    			
    		}
    		response.sendRedirect("order-detail?idp="+idP+"&ido="+idO);
    	}
    	
    }
    
}



