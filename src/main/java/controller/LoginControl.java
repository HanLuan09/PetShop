package controller;

import java.io.IOException;

import dao.AccountDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Account;

@WebServlet(name="LoginControl", urlPatterns = {"/login"})
public class LoginControl extends HttpServlet {
	
    @Override 
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
    	Cookie[] cookieArr = request.getCookies();
    	for(Cookie o : cookieArr) {
    		if(o.getName().equals("nameC")) {
    			request.setAttribute("cookieName", o.getValue());
    			
    		}
    		if(o.getName().equals("passC")) {
    			request.setAttribute("cookiePass", o.getValue());
    		}
    	}
    	request.getRequestDispatcher("login_register.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	String name = request.getParameter("name");
        String pass = request.getParameter("password");
        AccountDao dao = new AccountDao();
        Account a = dao.getAccount(name, pass);
        if(a == null) {
        	request.setAttribute("messlogin", "Người dùng đã tồn tại hoặc mật khẩu không chính xác!");
//        	response.sendRedirect("login_register.jsp");
        	request.getRequestDispatcher("login_register.jsp").forward(request, response);
        }else {
//        	tạo session
        	HttpSession session = request.getSession();
        	session.setAttribute("account", a);
//        	Lưu cookies
        	Cookie cookieName = new Cookie("nameC", name);
        	Cookie cookiePass = new Cookie("passC", pass);
//        	 xét thời gian tồn tại
        	cookieName.setMaxAge(60*60*24*90);
        	cookiePass.setMaxAge(60*60*24*90);
//        	lưu vào trình duyệt
        	response.addCookie(cookieName);
        	response.addCookie(cookiePass);

        	String previousUrl = (String) session.getAttribute("previousUrl");

        	if (previousUrl != null && !previousUrl.isEmpty()) {
        	    // Xóa URL trước đó khỏi session
        	    session.removeAttribute("previousUrl");
        	    
        	    // Chuyển hướng đến URL trước đó
        	    response.sendRedirect(previousUrl);
        	} else {
        	    // Chuyển hướng đến trang mặc định (ví dụ: trang home)
        	    response.sendRedirect("home");
        	}
//        	response.sendRedirect("home");
        }
        
    }

    

}
