package com.example.web_ban_quan_ao.Controller;

import com.example.web_ban_quan_ao.Model.Product;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ProductCartUserServlet", value = "/productCartUserServlet")
public class ProductCartUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        List<Product> cart = (List<Product>) session.getAttribute("cart");
        System.out.println(cart.size());
        String id = req.getParameter("deleteP");
        System.out.println(id);

        for (Product p : cart) {
            if (p.getIdProduct() == Integer.parseInt(id)) {
                cart.remove(p);
                session.setAttribute("cart", cart);
                RequestDispatcher dispatcher = req.getRequestDispatcher("view/cart_user.jsp");
                dispatcher.forward(req, resp);
            }
        }
    }
}

