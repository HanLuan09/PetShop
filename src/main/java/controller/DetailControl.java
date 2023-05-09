package controller;

import java.io.IOException;
import java.util.*;

import model.*;
import sevice.CartSumList;
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
        
//      hiển thị cart  
        CartSumList cSumList = new CartSumList();
        cSumList.viewCart(request);
        
//    	lấy url
        HttpSession session = request.getSession();
    	String previousUrl = (String) session.getAttribute("previousUrl");
    	if (previousUrl != null && !previousUrl.isEmpty()) {
    	    // Xóa URL trước đó khỏi session
    	    session.removeAttribute("previousUrl");
    	} 
//    	String previousNewUrl = request.getRequestURI();
    	String previousNewUrl = request.getRequestURI() + "?" + request.getQueryString();
    	session.setAttribute("previousUrl", previousNewUrl);
    	
//    	
        String id = request.getParameter("pid");
        String cateId = request.getParameter("cid");
        DAO dao = new DAO();
        AccountDao daoA = new AccountDao();
        RatingDao daoR = new RatingDao(); // lấy cho  Rating Count
        ProductSortDao daoP = new ProductSortDao();
        RatingCount rCount = new RatingCount();
        ProductDetails p = dao.getProductDetailById(id);
        List<ProductDetails> listP = daoP.getAllProductCid(cateId);
        Collections.sort(listP);
        List<Size> listSizes = dao.getSizes(id);
        List<Color> listColors = dao.getColors(id);
        List<Category> listC = dao.getAllCategory();
        List<RatingAccount> listRatingAccounts = daoA.getAllRatingAcount(id);
        List<RatingCount> listRatingCounts = daoR.getRatingCountProduct(id);
        
        request.setAttribute("detail", p);
        request.setAttribute("listCC", listC);
        request.setAttribute("listSize", listSizes);
        request.setAttribute("listColor", listColors);
        request.setAttribute("listP", listP);
        request.setAttribute("listRA", listRatingAccounts);
        request.setAttribute("listRCount", listRatingCounts);
        request.setAttribute("countRating", rCount.countRating(listRatingCounts));
        request.getRequestDispatcher("product_details.jsp").forward(request, response);
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
