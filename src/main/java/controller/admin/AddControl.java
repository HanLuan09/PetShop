package controller.admin;

import java.io.IOException;

import dao.DAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Product;

@WebServlet(name = "AddControl", urlPatterns = {"/add"})
public class AddControl extends HttpServlet {
    

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	response.setContentType("text/html;charset=UTF-8");
        //b1: get data from dao
    	DAO dao = new DAO();
    	Product checkP = dao.checkNameProduct(request.getParameter("nameP"));
    	if(checkP == null) {
    		Product p = new Product();
    		p.setNameP(request.getParameter("nameP"));
    		p.setImageP(request.getParameter("image"));
    		p.setDescribe(request.getParameter("describe"));
    		p.setAmount(Integer.parseInt(request.getParameter("amount")));
    		p.setDiscount(Integer.parseInt(request.getParameter("discount")));
    		p.setOrigin(request.getParameter("origin"));
    		p.setPrice(Integer.parseInt(request.getParameter("price")));
    		p.setCateId(Integer.parseInt(request.getParameter("cateid")));
    		
    		if(dao.addProduct(p)!=0) {
    			response.sendRedirect("manager");
    		}
    		else {
    			response.sendRedirect("edit?pid=-1");
    		}
    	}
    	else {
    		request.setAttribute("errorMess", "Tên sản phẩm đã tồn tại");
    		request.getRequestDispatcher("edit?pid=-1").forward(request, response);
    	}
    }

    
}


