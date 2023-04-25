package controller.sort;

import java.io.IOException;
import java.util.List;

import dao.DAO;
import dao.ProductSortDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Category;
import model.Product;
import model.ProductDetails;
import sevice.CartSumList;


@WebServlet(name = "HightoLowControl", urlPatterns = {"/sort-high"})
public class HightoLowControl extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
//        hiên carat 
        CartSumList cSumList = new CartSumList();
        cSumList.viewCart(request);
        
        ProductSortDao daoP = new ProductSortDao();
		DAO dao = new DAO();
		List<Category> listC = dao.getAllCategory();
        request.setAttribute("listCC", listC);
        List<ProductDetails> list = daoP.getAllProductHightoLow();
        request.setAttribute("listP", list);
        request.getRequestDispatcher("category_product.jsp").forward(request, response);
       
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



