package controller.admin;

import java.io.IOException;
import java.io.PrintWriter;

import dao.DAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Product;

@WebServlet(name = "SaveControl", urlPatterns = {"/save"})
public class SaveControl extends HttpServlet {
    

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	response.setContentType("text/html;charset=UTF-8");
        //b1: get data from dao
    	DAO dao = new DAO();
    	String id= request.getParameter("idP");
        String name = request.getParameter("nameP");
        Product checkP = dao.checkNameProduct(name);
//        PrintWriter out = response.getWriter();
//        if(checkP ==null  ) {
//        	out.println(name+" "+ checkP.getNameP());
//        }
//        else {
//        	out.println("no"+" "+name+" "+ checkP.getNameP());
//        }
        if(checkP!=null && !name.toLowerCase().equals(checkP.getNameP().toLowerCase())) {
        	request.setAttribute("errorMess", "Tên sản phẩm đã tồn tại");
    		request.getRequestDispatcher("edit?pid=" + id).forward(request, response);
        }else {
        	Product p = new Product();
        	p.setNameP(request.getParameter("nameP"));
        	p.setImageP(request.getParameter("image"));
        	p.setDescribe(request.getParameter("describe"));
        	p.setAmount(Integer.parseInt(request.getParameter("amount")));
        	p.setDiscount(Integer.parseInt(request.getParameter("discount")));
        	p.setOrigin(request.getParameter("origin"));
        	p.setPrice(Integer.parseInt(request.getParameter("price")));
        	p.setCateId(Integer.parseInt(request.getParameter("cateid")));
        	p.setIdP(Integer.parseInt(id));
        	if(dao.updateProduct(p)!=0) {
        		response.sendRedirect("manager");
        	}
        	else {
        		response.sendRedirect("edit?pid=" + id);
        	}
        }
        
    }
}



