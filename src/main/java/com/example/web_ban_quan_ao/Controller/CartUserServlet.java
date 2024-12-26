package com.example.web_ban_quan_ao.Controller;

import com.example.web_ban_quan_ao.Model.Product;
import com.example.web_ban_quan_ao.Model.User;
import com.example.web_ban_quan_ao.Service.CartUser.CartImpl;
import com.example.web_ban_quan_ao.Service.DetailUser.DetailProductImpl;

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

@WebServlet(name = "CartUserServlet", value = "/cartUserServlet")
public class CartUserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private DetailProductImpl detailProductImpl = new DetailProductImpl();
    private CartImpl cartImpl = new CartImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");

        if (action == null) {
            action = "";
        }

        switch (action) {
            case "delete":
                HttpSession session = req.getSession();
                List<Product> cart = (List<Product>) session.getAttribute("cart");
                String id = req.getParameter("deleteP");
                for (Product p : cart) {
                    if (p.getIdProduct() == Integer.parseInt(id)) {
                        cart.remove(p);
                        session.setAttribute("cart", cart);
                        RequestDispatcher dispatcher = req.getRequestDispatcher("view/cart_user.jsp");
                        dispatcher.forward(req, resp);
                    }
                }
                break;
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");

        if (action == null) {
            action = "";
        }

        switch (action) {
            case "buy":
                HttpSession session = req.getSession();
                List<Product> cart = (List<Product>) session.getAttribute("cart");

                if (cart == null) {
                    cart = new ArrayList<>();
                }

                String userIDS = (String) session.getAttribute("userId");
                int userID = Integer.parseInt(userIDS);
                User user = cartImpl.getUserById(userID);

                String address = user.getAddress();
                session.setAttribute("addressUser", address);

                handleBuyAction(resp, req, cart, session);
                break;

            default:
                RequestDispatcher dispatcher = req.getRequestDispatcher("view/cart_user.jsp");
                dispatcher.forward(req, resp);
        }
    }

    private void handleBuyAction(HttpServletResponse resp, HttpServletRequest req, List<Product> cart, HttpSession session) throws ServletException, IOException {
        String id = req.getParameter("cid");
        Product p = detailProductImpl.getDetailProductById(Integer.parseInt(id));

        boolean found = false;
        for (Product product : cart) {
            if (product.getIdProduct() == Integer.parseInt(id)) {
                found = true;
                break;
            }
        }
        if (!found) {
            cart.add(p);
        }

        session.setAttribute("cart", cart);
        RequestDispatcher dispatcher = req.getRequestDispatcher("view/cart_user.jsp");
        dispatcher.forward(req, resp);
    }
}

