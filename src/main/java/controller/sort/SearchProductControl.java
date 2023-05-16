package controller.sort;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import dao.AdminDao;
import dao.DAO;
import dao.ProductSortDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Category;
import model.ProductDetails;
import sevice.CartSumList;
import sevice.SessionService;

@WebServlet(name = "SearchProductControl", urlPatterns = {"/search"})
public class SearchProductControl extends HttpServlet {
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        
//      hiển thị cart  
        CartSumList cSumList = new CartSumList();
        cSumList.viewCart(request);
      
//    	lấy url
        SessionService sessionService = new SessionService();
        sessionService.sesionURLService(request, response);
//    	search
        String searchUrl= request.getParameter("search");
        String search = searchUrl.replaceAll("%20", " ");
        
        DAO dao = new DAO();
        ProductSortDao daoP = new ProductSortDao();
        List<Category> listC = dao.getAllCategory();
        List<ProductDetails> listP = daoP.getAllProductSearch(search);
        Collections.sort(listP);
        request.setAttribute("listCC", listC);
        // list all p theo cid vẫn đẩy theo listP
        request.setAttribute("listP", listP);
        request.getRequestDispatcher("category_product.jsp").forward(request, response);
        
    }
}
