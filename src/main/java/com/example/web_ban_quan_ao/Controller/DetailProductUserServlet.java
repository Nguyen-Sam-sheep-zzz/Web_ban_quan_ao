package com.example.web_ban_quan_ao.Controller;

import com.example.web_ban_quan_ao.Model.Product;
import com.example.web_ban_quan_ao.Service.DetailUser.DetailProductImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DetailProductUserServlet" , value = "/detailProductUserServlet")
public class DetailProductUserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private DetailProductImpl detailProductImpl = new DetailProductImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("pid");
        Product p = detailProductImpl.getDetailProductById(Integer.parseInt(id));
        req.setAttribute("detailProduct", p);
        req.getRequestDispatcher("view/product_user.jsp").forward(req, resp);
    }
}
