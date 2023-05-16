package controller.admin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import dao.AdminDao;
import dao.DAO;
import dao.UserProductDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Account;
import model.AccountProduct;
import model.AdminProduct;
import model.Pair;
import model.UserProduct;

@WebServlet(name = "AdminControl", urlPatterns = {"/admin"})
public class AdminControl extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        //b1: get data from dao
        HttpSession session = request.getSession();
    	Account a = (Account) session.getAttribute("account");
    	if(a==null) {
    		response.sendRedirect("login");
    	}
        try {
			
        	DAO dao = new DAO();
        	AdminDao adminDao = new AdminDao();
        	int count = dao.countProduct();
        	
        	UserProductDAO dProductDAO = new UserProductDAO();
        	List<AccountProduct> list = dProductDAO.getProductAdmin();
        	HashMap<Integer, List<Pair<Integer, List<AccountProduct>>>> map = new HashMap<>();
        	
        	for (AccountProduct o : list) {
        		int idA = o.getIdA();
        		
        		// Kiểm tra xem key idA đã tồn tại trong map hay chưa
        		if (map.containsKey(idA)) {
        			// Nếu key idA đã tồn tại trong map, lấy danh sách hiện tại
        			List<Pair<Integer, List<AccountProduct>>> pairList = map.get(idA);
        			boolean pairFound = false;
        			for (Pair<Integer, List<AccountProduct>> pair : pairList) {
        				if (pair.getFirst() == o.getIdO()) {
        					// Nếu đã có cặp có cùng idO, thêm AccountProduct vào danh sách trong cặp đó
        					pair.getSecond().add(o);
        					pairFound = true;
        					break;
        				}
        			}
        			if (!pairFound) {
        				// Nếu không tìm thấy cặp có cùng idO, tạo cặp mới và thêm vào danh sách
        				Pair<Integer, List<AccountProduct>> newPair = new Pair<>(o.getIdO(), new ArrayList<>());
        				newPair.getSecond().add(o);
        				pairList.add(newPair);
        			}
        		} else {
        			// Nếu key idA chưa tồn tại trong map, tạo danh sách mới và thêm cặp vào danh sách
        			List<Pair<Integer, List<AccountProduct>>> pairList = new ArrayList<>();
        			Pair<Integer, List<AccountProduct>> newPair = new Pair<>(o.getIdO(), new ArrayList<>());
        			newPair.getSecond().add(o);
        			pairList.add(newPair);
        			map.put(idA, pairList);
        		}
        	}
        	
        	request.setAttribute("count", count);
        	request.setAttribute("map", map);
        	request.setAttribute("listAminP", list);
        	request.getRequestDispatcher("admin.jsp").forward(request, response);
        	//404 -> url
        	//500 -> jsp properties
		} catch (Exception e) {
			request.getRequestDispatcher("error.jsp").forward(request, response);
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
