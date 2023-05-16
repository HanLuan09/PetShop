package controller.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;

import dao.DAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;
import model.Account;
import model.Product;

@MultipartConfig
@WebServlet(name = "AddControl", urlPatterns = {"/add"})
public class AddControl extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	response.setContentType("text/html;charset=UTF-8");
        //b1: get data from dao
    	HttpSession session = request.getSession();
    	Account a = (Account) session.getAttribute("account");
    	if(a==null) {
    		response.sendRedirect("login");
    	}
    	DAO dao = new DAO();
    	Product checkP = dao.checkNameProduct(request.getParameter("nameP"), 0);
    	if(checkP == null) {
    		try {
    			Part part = request.getPart("image");
            	String  readPath = request.getServletContext().getRealPath("/upload");
            	String fileName = Path.of(part.getSubmittedFileName()).getFileName().toString();
            	if(!Files.exists(Path.of(readPath))) {
            		Files.createDirectories(Path.of(readPath));
            	}
            	part.write(readPath+"/"+fileName);
            	
            	try {
            		Product p = new Product();
            		p.setNameP(request.getParameter("nameP"));
            		p.setImageP(fileName);
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
				} catch (Exception e) {
					request.getRequestDispatcher("error.jsp").forward(request, response);
				}
			} catch (Exception e) {
				request.getRequestDispatcher("error.jsp").forward(request, response);
			}
    		
    	}
    	else {
    		request.setAttribute("errorMess", "Tên sản phẩm đã tồn tại");
    		request.getRequestDispatcher("edit?pid=-1").forward(request, response);
    	}
    }

    
}


