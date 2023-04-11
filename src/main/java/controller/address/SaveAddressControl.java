package controller.address;

import java.io.IOException;
import dao.AccountDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Account;

@WebServlet(name="SaveAddressControl", urlPatterns = {"/save-address"})
public class SaveAddressControl extends HttpServlet {
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	response.setContentType("text/html;charset=UTF-8");
        
    }  
    @Override 
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	HttpSession session = request.getSession();
//    	PrintWriter out = response.getWriter();
    	Account a = (Account) session.getAttribute("account");
//		out.println(name+" "+ phone+" "+nameAddress);
    	int idA = a.getIdA();
    	try { 
    		String name = request.getParameter("name");
    		String phone = request.getParameter("phone");
    		String nameAddress = request.getParameter("address");
    		AccountDao daoAccount = new AccountDao();
    		daoAccount.addAddress(idA, name, phone, nameAddress);
//    		request.getRequestDispatcher("address").forward(request, response);
    		response.sendRedirect("address");
		} catch (Exception e) {
			request.setAttribute("messAddress", "Không thể thêm địa chỉ!");
//			request.getRequestDispatcher("address").forward(request, response);
		}
    	
//    	response.sendRedirect("address");
    	
    }

}

