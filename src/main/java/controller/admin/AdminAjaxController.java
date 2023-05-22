package controller.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import dao.AdminDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.AdminProduct;

@WebServlet(name = "AdminAjaxController", urlPatterns = {"/manager-search"})
public class AdminAjaxController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json");
        request.setCharacterEncoding("UTF-8");
        
        String search = request.getParameter("search");
        
        AdminDao adminDao = new AdminDao();
        List<AdminProduct> list = new ArrayList<>();
        
        if (search != null) {
            list = adminDao.getAllProductSearch(search);
        } else {
            list = adminDao.getAllProductCate();
        }
        
        Collections.sort(list);
        
        String sp = request.getParameter("spbatdau");
        int spbatdau = 0;
        if (sp != null) {
            spbatdau = Integer.parseInt(sp);
        }
        
        List<AdminProduct> selectedProducts = new ArrayList<>();
        if (spbatdau + 12 <= list.size()) {
            selectedProducts = list.subList(spbatdau, spbatdau + 12);
        } else {
            selectedProducts = list.subList(spbatdau, list.size());
        }
        
        JsonArray jsonArray = new JsonArray();
        for (AdminProduct o : selectedProducts) {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("idP", o.getIdP());
            jsonObject.addProperty("nameP", o.getNameP());
            jsonObject.addProperty("cate", o.getCate());
            jsonObject.addProperty("amount", o.getAmount());
            jsonObject.addProperty("price", o.getPrice());
            jsonObject.addProperty("discount", o.getDiscount());
            jsonObject.addProperty("sumPrice", o.getSumPrice());
            jsonArray.add(jsonObject);
        }
        
        PrintWriter out = response.getWriter();
        out.println(jsonArray.toString());
    }
}

/*

 @WebServlet(name = "AdminSearchController", urlPatterns = {"/manager-search"})
public class AdminSearchController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        // Các phần xử lý khác...

        String html = "";
        for (AdminProduct o : selectedProducts) {
            html += "<tr>\r\n"     			
                    + "<td>PET" + o.getIdP()+ "</td>\r\n"
                    + "<td>" + o.getNameP()+ "</td>\r\n"
                    + "<td>" + o.getCate()+ "</td>\r\n"
                    + "<td>" + o.getAmount()+ "</td>\r\n"
                    + "<td>" + o.getPrice()+ "</td>\r\n"
                    + "<td>" + o.getDiscount()+ "%</td>\r\n"
                    + "<td>" + o.getSumPrice()+ "</td>\r\n"
                    + "<td>\r\n"
                    + "<a href=\"edit?pid=" + o.getIdP()+ "\"  class=\"btn blue-gradient\" data-toggle=\"modal\">Xem</a>\r\n"
                    + "<a href=\"#deleteEmployeeModal\" class=\"delete btn btn-dark\" data-toggle=\"modal\" data-p-id=" + o.getIdP()+ "\">Xóa</a>\r\n"
                    + "</td>\r\n"
                    + "</tr>";
        }

        PrintWriter out = response.getWriter();
        out.println(html);
    }
}

 */


