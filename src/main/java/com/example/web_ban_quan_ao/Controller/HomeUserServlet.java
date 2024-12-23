package com.example.web_ban_quan_ao.Controller;

import com.example.web_ban_quan_ao.Model.Product;
import com.example.web_ban_quan_ao.Service.HomeUser.HomeUserImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "HomeUserServlet", value = "/homeUserServlet")

public class HomeUserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private HomeUserImpl homeUserImpl;

    public void init() {
        homeUserImpl = new HomeUserImpl();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String search = req.getParameter("search");
        searchProductByName(search,req,resp);
    }

    private void searchProductByName(String keyword, HttpServletRequest req, HttpServletResponse resp) {
        List<Product> products = homeUserImpl.searchProductByName(keyword);
        req.setAttribute("productList", products);
        RequestDispatcher dispatcher = req.getRequestDispatcher("view/home_user.jsp");
        try {
            dispatcher.forward(req, resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "All":
                productList(req, resp);
                break;
            case "Shirts":
                productListShirts("Shirts", req, resp);
                break;
            case "Pants":
                productListShirts("Pants", req, resp);
                break;
            case "Outwears":
                productListShirts("Outwears", req, resp);
                break;
            case "Accessories":
                productListShirts("ACCESSORIES", req, resp);
                break;
            default:
                productList(req, resp);
                break;
        }
    }

    private void productListShirts(String choice, HttpServletRequest req, HttpServletResponse resp) {
        List<Product> products = new HomeUserImpl().getAllProductCategories(choice);
        req.setAttribute("productList", products);
        RequestDispatcher dispatcher = req.getRequestDispatcher("view/home_user.jsp");
        try {
            dispatcher.forward(req, resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void productList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Product> products = new HomeUserImpl().getAllProductDisplayUser();
        req.setAttribute("productList", products);
        RequestDispatcher dispatcher = req.getRequestDispatcher("view/home_user.jsp");
        dispatcher.forward(req, resp);
    }
}
