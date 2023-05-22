package controller;

import dao.DAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Category;
import model.Product;
import model.ProductDetails;
import sevice.CartSumList;
import sevice.SessionService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

@WebServlet(name = "HomeControl", urlPatterns = {"/home"})
public class HomeControl extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//    	Trang chính
        response.setContentType("text/html;charset=UTF-8");
        try {	
//      hiển thị cart  
        	CartSumList cSumList = new CartSumList();
        	cSumList.viewCart(request);
//    	lấy url
        	SessionService sessionService = new SessionService();
        	sessionService.sesionURLService(request, response);
        	DAO dao = new DAO();
        	List<Category> listC = dao.getAllCategory();
        	request.setAttribute("listCC", listC);
        	List<ProductDetails> list = dao.getAllProductRemaining();
        	List<ProductDetails> randomProducts = new ArrayList<>(list); 
        	// Sử dụng đối tượng Random để lấy ngẫu nhiên các phần tử trong danh sách
        	Collections.shuffle(randomProducts, new Random());
        	// Lấy 16 sản phẩm đầu tiên trong danh sách đã được xáo trộn
        	List<ProductDetails> randomSelection = randomProducts.subList(0, 16);
        	
        	List<Product> listDogCat = dao.getAllProductDogCat();
        	Collections.sort(list);
//        //b2: set data to jsp
        	request.setAttribute("randomSelection", randomSelection);
        	request.setAttribute("listBest", listDogCat);
        	request.setAttribute("listP", list);
        	request.setAttribute("listDogCat", listDogCat);
        	request.getRequestDispatcher("index.jsp").forward(request, response);
        	//404 -> url
        	//500 -> jsp properties
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
}
