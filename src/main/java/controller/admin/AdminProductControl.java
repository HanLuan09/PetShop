package controller.admin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import dao.AdminDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.AdminProduct;

@WebServlet(name = "AdminProductControl", urlPatterns = {"/manager"})
public class AdminProductControl extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        //b1: get data from dao
        
    	try {
    		String search= request.getParameter("search");
            AdminDao adminDao = new AdminDao();
            List<AdminProduct> list = new ArrayList<>();
            
            if(search!= null) {
            	list = adminDao.getAllProductSearch(search);
            }
            else {
            	list = adminDao.getAllProductCate();
            }
           
    		Collections.sort(list);
    		List<AdminProduct> selectedProducts = new ArrayList<>();
    		int count = 0;
    		if(list.size() > 0) {
    			selectedProducts = list.subList(0, 12);
        		count = list.size()/12;
        		if(list.size()%12 != 0) count++;
    		}
    		
    		request.setAttribute("count", count);
    		request.setAttribute("listAminP", selectedProducts);
    		request.setAttribute("hsearch", search);
    		request.getRequestDispatcher("manager_product.jsp").forward(request, response);
    		//404 -> url
    		//500 -> jsp properties
		} catch (Exception e) {
			request.getRequestDispatcher("error.jsp").forward(request, response);
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