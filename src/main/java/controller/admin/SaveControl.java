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
@WebServlet(name = "SaveControl", urlPatterns = {"/save"})
public class SaveControl extends HttpServlet {
    
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
	}
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
    	String id= request.getParameter("idP");
        String name = request.getParameter("nameP");
        Product p = dao.getProductById(id);
        Product checkP = dao.checkNameProduct(name, Integer.parseInt(id));
        
        if(checkP!=null) {
        	request.setAttribute("errorMess", "Tên sản phẩm đã tồn tại");
    		request.getRequestDispatcher("edit?pid=" + id).forward(request, response);
        }else {
        	Part part = request.getPart("image");
			String fileName = Path.of(part.getSubmittedFileName()).getFileName().toString();
        	// kiểm tra xem có thay đổi file hay không
        	if(fileName == null || fileName.equals("")) {
        		
        	}
        	else {
    			try {
        			String  readPath = request.getServletContext().getRealPath("/upload");
    				
    				if(!Files.exists(Path.of(readPath))) {
    					Files.createDirectories(Path.of(readPath));
    				}	
    				part.write(readPath+"/"+fileName);
    				p.setImageP(fileName);
    				
        		} catch (Exception e) {
        			request.getRequestDispatcher("error.jsp").forward(request, response);
        		}
        	}
        	// set lại product
        	try {

            	p.setNameP(request.getParameter("nameP"));
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
			} catch (Exception e) {
				request.getRequestDispatcher("error.jsp").forward(request, response);
			}
        	
        }
        
    }
}



