package controller;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import dao.DAO;
import dao.ProductSortDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Account;
import model.CartItem;
import model.Category;
import model.ProductDetails;
import sevice.CartSevice;
import sevice.CartSumList;

@WebServlet(name = "CategoryControl", urlPatterns = {"/category"})
public class CategoryControl extends HttpServlet{

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
    	
        //da lay dc category id ve roi
        String cateId = request.getParameter("cid");
        DAO dao = new DAO();
        ProductSortDao daoP = new ProductSortDao();
        List<Category> listC = dao.getAllCategory();
        List<ProductDetails> listP = daoP.getAllProductCid(cateId);
        Collections.sort(listP);
        request.setAttribute("listCC", listC);
        // list all p theo cid vẫn đẩy theo listP
        request.setAttribute("listP", listP);
        request.setAttribute("active", cateId);
        request.getRequestDispatcher("category_product.jsp").forward(request, response);
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