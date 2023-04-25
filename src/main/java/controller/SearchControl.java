package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import petshop.ProductSearchEngine;
import petshop.KeyWordProduct;

@WebServlet(name = "SearchControl", urlPatterns = {"/search-name"})
public class SearchControl extends HttpServlet {
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String search= request.getParameter("search");
        //b1: get data from dao
        KeyWordProduct keyWordProduct = new KeyWordProduct();
        List<String> listA = new ArrayList<>();
        PrintWriter out = response.getWriter();
        Set<String> set = new HashSet<>();
        set = keyWordProduct.getKey();
        listA.addAll(set);
        
        ProductSearchEngine p = new ProductSearchEngine();
        List<String> listB = p.serach(search, listA);
        for(String a: listB) {
        	out.println("<li class=\"header__search-history-item\"><a href=\"\">"+a+"</a></li>");
        }
    }
}


