package controller.admin;

import java.io.IOException;

import dao.DAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Account;

@WebServlet(name = "DeleteControl", urlPatterns = {"/delete"})
public class DeleteControl extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	 request.removeAttribute("succesMess");
    	 HttpSession session = request.getSession();
         Account a = (Account) session.getAttribute("account");
         if (a == null) {
             response.sendRedirect("login");
             return;
         }else if(a.getIsAdmin()!=1) {
     		response.sendRedirect("login");
     		return;
     	}
        response.setContentType("text/html;charset=UTF-8");
        //b1: get data from dao
        try {
        	String id = request.getParameter("productId");
        	DAO dao = new DAO();
        	//dao.deleteProduct(id);
        	int res = dao.removeProduct(id);
        	if(res == 0) {
        		response.sendRedirect("error.jsp");
        	}else {
        		request.setAttribute("succesMess", "Xóa sản phẩm thành công");
//            	response.sendRedirect("manager");
                request.getRequestDispatcher("manager").forward(request, response);  
        	}
        
			
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