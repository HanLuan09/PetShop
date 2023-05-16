package controller.account;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dao.AccountDao;
import dao.UserProductDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Account;
import model.Address;
import model.UserProduct;


@WebServlet(name = "OrderControl", urlPatterns = {"/order"})
public class OrderControl extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	response.setContentType("text/html;charset=UTF-8");
    	HttpSession session = request.getSession();
    	Account a = (Account) session.getAttribute("account");
    	if(a == null) {
    		response.sendRedirect("login");
    	}
    	int idA = a.getIdA();
    	AccountDao daoA = new AccountDao();
    	UserProductDAO daoUser = new UserProductDAO();
    	List<UserProduct> listUserProducts = daoUser.getProductUser(idA);
    	Map<Integer, List<UserProduct>> map = new HashMap<>();

    	for (UserProduct o : listUserProducts) {
    	    if (map.containsKey(o.getIdO())) {
    	        // Nếu khóa đã tồn tại trong map, thêm đối tượng UserProduct vào danh sách tương ứng
    	        map.get(o.getIdO()).add(o);
    	    } else {
    	        // Nếu khóa chưa tồn tại trong map, tạo danh sách mới và thêm đối tượng UserProduct vào danh sách đó
    	        List<UserProduct> newList = new ArrayList<>();
    	        newList.add(o);
    	        map.put(o.getIdO(), newList);
    	    }
    	}
    	Account account = daoA.checkAccount(a.getUsername());
    	Address address = daoA.getAddress(idA);
    	request.setAttribute("mapProducts", map);
    	request.setAttribute("listUserProducts", listUserProducts);
    	request.setAttribute("account", account);
    	request.setAttribute("address", address);
		request.getRequestDispatcher("user_product.jsp").forward(request, response);
    	
    }
    
}


