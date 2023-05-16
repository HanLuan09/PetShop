package controller.admin;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import dao.AdminDao;
import dao.DAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.AdminProduct;

@WebServlet(name = "ManagerControl", urlPatterns = {"/manager"})
public class ManagerControl extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        //b1: get data from dao
        
    	try {
    		DAO dao = new DAO();
    		AdminDao adminDao = new AdminDao();
    		int count = dao.countProduct();
    		
    		List<AdminProduct> list = adminDao.getAllProductCate();
    		Collections.sort(list);
//        Collections.sort(list, new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return o2.compareTo(o1);
//            }
//        });
    		request.setAttribute("count", count);
    		request.setAttribute("listAminP", list);
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
