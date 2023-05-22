package controller;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicReference;

import dao.AccountDao;
import dao.DAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Account;

@WebServlet(name="RegisterControl", urlPatterns = {"/register"})
public class RegisterControl extends HttpServlet {
    private AtomicReference<String> usernameRef = new AtomicReference<>();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String name = request.getParameter("fullname");
        String pass = request.getParameter("password");
        String passComfi = request.getParameter("password_comfirmation");
        if(name == null || pass == null || passComfi == null || !pass.equals(passComfi)) {
            request.setAttribute("messregister", "Đăng nhập không thành công!");
            request.getRequestDispatcher("login_register.jsp").forward(request, response);
            return;
        } else {
        	synchronized (this) {
           
            if (!usernameRef.compareAndSet(null, name)) {             
            	request.setAttribute("messregister", "Tên đăng nhập đã tồn tại!");
                request.getRequestDispatcher("login_register.jsp").forward(request, response);
                return;
            }

            try {
                AccountDao dao = new AccountDao();
                Account a = dao.checkAccount(name);
                if(a == null) {
                    int result = dao.postAccount(name, pass);
                    if(result == 0) {
                    	response.sendRedirect("error.jsp");
                    	return;
                    }
                    response.sendRedirect("login");
                } else {                	
                    request.setAttribute("messregister", "Tên đăng nhập đã tồn tại!");
                    request.getRequestDispatcher("login_register.jsp").forward(request, response);
                    return;
                }
                
            } 
            finally {
                // Clear username reference after registration is complete
                usernameRef.set(null);
            }
        	}
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
}
