package controller.account;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
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
//    	Thêm mới đánh giá
    	request.removeAttribute("sussmess");
    	response.setContentType("text/html;charset=UTF-8");
    	HttpSession session = request.getSession();
    	Account a = (Account) session.getAttribute("account");
    	if(a == null) {
    		response.sendRedirect("login");
    		return;
    	}else {
    		int idO = Integer.parseInt(request.getParameter("ido"));
    		int idP = Integer.parseInt(request.getParameter("idp"));
    		
    		try {
    			LocalDate localDate = LocalDate.now();
		        Date date = java.sql.Date.valueOf(localDate);
    			int idA = a.getIdA();
    			String checkR = request.getParameter("rating");
    			if(checkR == null || checkR.equals("")) {
    				request.setAttribute("mess", "lỗi");
    				response.sendRedirect("order-detail?idp="+idP+"&ido="+idO);
    				return;
    			}
    			int rating = Integer.parseInt(checkR);
    			String comment = request.getParameter("comment");
    			if(rating >0) {
    				RatingDao daoRating = new RatingDao();
    				int res = daoRating.addRatingProduct(idP, idA, idO, rating, comment, date);
    				if(res == 0) {
    					response.sendRedirect("error.jsp");
    					return;
    				}
    			}
    		} catch (Exception e) {
    			response.sendRedirect("error.jsp");
    		}
    		request.setAttribute("sussmess", "Bạn đã đánh giá sản phẩm");
    		response.sendRedirect("order-detail?idp="+idP+"&ido="+idO);
    	}
    	
    }
    
}



