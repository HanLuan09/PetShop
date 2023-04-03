package controller;

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

@WebServlet(name = "CategoryControl", urlPatterns = {"/category"})
public class CategoryControl extends HttpServlet{

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
      
        //da lay dc category id ve roi
        String cateId = request.getParameter("cid");
        DAO dao = new DAO();
        ProductSortDao daoP = new ProductSortDao();
        List<Category> listC = dao.getAllCategory();
        List<Product> listP = daoP.getAllProductCid(cateId);
        request.setAttribute("listCC", listC);
        // list all p theo cid vẫn đẩy theo listP
        request.setAttribute("listP", listP);
        request.setAttribute("active", cateId);
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