package controller.account;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;

import dao.AccountDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;
import model.Account;

@MultipartConfig
@WebServlet(name = "ImageAccountControl", urlPatterns = {"/image-account"})
public class ImageAccountControl extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	response.setContentType("text/html;charset=UTF-8");
    	HttpSession session = request.getSession();
    	Account a = (Account) session.getAttribute("account");
    	if(a == null) {
    		response.sendRedirect("login");
    	}
    	else {
    		
    		Part part = request.getPart("imageAccount");
			String fileName = Path.of(part.getSubmittedFileName()).getFileName().toString();
        	// kiểm tra xem có thay đổi file hay không
        	if(fileName == null || fileName.equals("")) {
        		response.sendRedirect("order");
        	}
        	else {
    			try {
        			String  readPath = request.getServletContext().getRealPath("/upload");
    				
    				if(!Files.exists(Path.of(readPath))) {
    					Files.createDirectories(Path.of(readPath));
    				}	
    				part.write(readPath+"/"+fileName);
    				
        		} catch (Exception e) {
        			
        			PrintWriter out = response.getWriter();
        			out.println("null");
        		}
    			
//        		xét lại account
    			try {
    				AccountDao daoA = new AccountDao();
    				daoA.putImageAcount(fileName, a.getIdA());
    				a.setImageA(fileName);
    				session.setAttribute("account", a);
    			} catch (Exception e) {
    				// TODO: handle exception
    			}
    			response.sendRedirect("order");
        	}
        }
    }
    
}



