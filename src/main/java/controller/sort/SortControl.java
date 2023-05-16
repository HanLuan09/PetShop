package controller.sort;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import dao.DAO;
import dao.ProductSortDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Category;
import model.ProductDetails;
import model.sort.*;
import sevice.CartSumList;

@WebServlet(name = "SortControl", urlPatterns = {"/sort-product"})
public class SortControl extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
//      hiên carat 
        CartSumList cSumList = new CartSumList();
        cSumList.viewCart(request);
		DAO dao = new DAO();
		ProductSortDao daoP = new ProductSortDao();
		int sort;
		try {
			sort = Integer.parseInt(request.getParameter("sort"));
		} catch (Exception e) {
			sort = 0;
		}
				
		List<Category> listC = dao.getAllCategory();
        List<ProductDetails> list = new ArrayList<>();
        //phổ biến
		if(sort == 1) {
			list = dao.getAllProductRemaining();
			Collections.sort(list, new SortByPopularity());
		}else if(sort ==2) {
			list = daoP.getAllProductLatest();
		}else if(sort ==3) {
			list = daoP.getAllProductSelling();
		}else if(sort ==4) {
			list = dao.getAllProductRemaining();
			Collections.sort(list, new SortLowtoHigh());
		}else if(sort ==5) {
			list = dao.getAllProductRemaining();
			Collections.sort(list, new SortHightoLow());
		}
		else {
			list = dao.getAllProductRemaining();
			Collections.sort(list);
		}
		request.setAttribute("listCC", listC);
        request.setAttribute("listP", list);
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