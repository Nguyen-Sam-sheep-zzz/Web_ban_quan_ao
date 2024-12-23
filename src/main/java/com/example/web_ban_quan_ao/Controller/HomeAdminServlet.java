package com.example.web_ban_quan_ao.Controller;

import com.example.web_ban_quan_ao.Model.Product;
import com.example.web_ban_quan_ao.Service.Admin.DAO;
import com.example.web_ban_quan_ao.Service.HomeUser.HomeUserImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "HomeAdminServlet", value = "/home_admin")
public class HomeAdminServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private HomeUserImpl homeUserImpl = new HomeUserImpl();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "logout":
                request.getSession().invalidate();
                RequestDispatcher dispatcher = request.getRequestDispatcher("view/login.jsp");
                dispatcher.forward(request, response);
                break;
            default:
                productList(request, response);
                break;
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "logout":
                request.getSession().invalidate();
                RequestDispatcher dispatcher = request.getRequestDispatcher("/loginServlet");
                dispatcher.forward(request, response);
                break;
        }
    }

    private void productList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> products = new HomeUserImpl().getAllProductDisplayUser();
        request.setAttribute("productList", products);

        RequestDispatcher dispatcher = request.getRequestDispatcher("view/home_admin.jsp");
        dispatcher.forward(request, response);
    }
}
