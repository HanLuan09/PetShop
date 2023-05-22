package controller.admin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import dao.DAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Account;
import model.Category;
import model.Product;

@WebServlet(name = "EditControl", urlPatterns = {"/edit"})
public class EditControl extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//    	trang chi tiết sản phẩm của Admin
    	HttpSession session = request.getSession();
    	Account a = (Account) session.getAttribute("account");
    	if(a==null) {
    		response.sendRedirect("login");
    		return;
    	}else if(a.getIsAdmin()!=1) {
    		response.sendRedirect("login");
    		return;
    	}
        response.setContentType("text/html;charset=UTF-8");
        //b1: get data from dao
        try {
			
        	String id = request.getParameter("pid");
        	DAO dao = new DAO();
        	Product p = dao.getProductById(id);
        	if(p==null) p = new Product();
        	
        	List<Category> listC = new ArrayList<>();
        	listC= dao.getCategoryExecpt(p.getCateId()+"");
        	
        	request.setAttribute("idProduct", id);
        	request.setAttribute("productId", p);
        	request.setAttribute("listCate", listC);
        	request.getRequestDispatcher("manager_detail.jsp").forward(request, response);
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
