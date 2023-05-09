package controller.admin;

import java.io.IOException;
import java.util.List;

import dao.AdminDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.AdminProduct;

@WebServlet(name = "AdminSearchController", urlPatterns = {"/manager-search"})
public class AdminSearchController extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String search= request.getParameter("search");
        //b1: get data from dao
        AdminDao adminDao = new AdminDao();
        List<AdminProduct> list = adminDao.getAllProductSearch(search);
        int count = list.size();
        request.setAttribute("count", count);
        request.setAttribute("listAminP", list);
        request.setAttribute("hsearch", search);
        request.getRequestDispatcher("manager_product.jsp").forward(request, response);
        //404 -> url
        //500 -> jsp properties
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

