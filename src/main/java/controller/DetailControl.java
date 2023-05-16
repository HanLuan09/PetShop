package controller;

import java.io.IOException;
import java.util.*;

import model.*;
import sevice.CartSumList;
import sevice.SessionService;
import dao.AccountDao;
import dao.DAO;
import dao.ProductSortDao;
import dao.RatingDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(name = "DetailControl", urlPatterns = {"/detail"})
public class DetailControl extends HttpServlet{
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
//      hiển thị cart  
        	CartSumList cSumList = new CartSumList();
        	cSumList.viewCart(request);
//    	lấy url
        	SessionService sessionService = new SessionService();
        	sessionService.sesionURLService(request, response);
        	
        	String id = request.getParameter("pid");
        	String cateId = request.getParameter("cid");
        	DAO dao = new DAO();
        	AccountDao daoA = new AccountDao();
        	RatingDao daoR = new RatingDao(); // lấy cho  Rating Count
        	ProductSortDao daoP = new ProductSortDao();
        	ProductDetails p = dao.getProductDetailById(id);
        	List<ProductDetails> listP = daoP.getAllProductCid(cateId);
        	Collections.sort(listP);
        	List<Category> listC = dao.getAllCategory();
        	List<RatingAccount> listRatingAccounts = daoA.getAllRatingAcount(id);
        	Collections.sort(listRatingAccounts);
        	List<RatingCount> listRatingCounts = daoR.getRatingCountProduct(id);
        	
        	request.setAttribute("remaining", dao.remainingProducts(Integer.parseInt(id)));
        	request.setAttribute("detail", p);
        	request.setAttribute("listCC", listC);
        	request.setAttribute("listP", listP);
        	request.setAttribute("listRA", listRatingAccounts);
        	request.setAttribute("listRCount", listRatingCounts);
        	request.getRequestDispatcher("product_details.jsp").forward(request, response);
			
		} catch (Exception e) {
			response.sendRedirect("error.jsp");
		}
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
