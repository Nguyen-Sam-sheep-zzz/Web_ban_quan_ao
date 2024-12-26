package com.example.web_ban_quan_ao.Controller;

import com.example.web_ban_quan_ao.Model.Product;
import com.example.web_ban_quan_ao.Service.Admin.DAO;

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
    private DAO dao = new DAO();

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
            case "add":
                ShowAddProduct(request, response);
                break;
            case "edit":
                ShowEditProduct(request, response);
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
        RequestDispatcher dispatcher;
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "add":
                addProduct(request, response);
                break;
            case "search":
                searchProduct(request, response);
                break;
            case "edit":
                editProduct(request, response);
                break;
            case "logout":
                request.getSession().invalidate();
                dispatcher = request.getRequestDispatcher("/loginServlet");
                dispatcher.forward(request, response);
                break;
        }
    }

    private void editProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("nameProduct");
        int price = Integer.parseInt(request.getParameter("priceProduct"));
        String urlImage = request.getParameter("urlImage");
        int quantity = Integer.parseInt(request.getParameter("quantityProduct"));
        String description = request.getParameter("descriptionProduct");
        String size = request.getParameter("size");
        String status = "";
        if (quantity <= 0) {
            status = "Out of stock";
        } else {
            status = "Available";
        }
        String type = request.getParameter("category");
        Product product = new Product(urlImage, id, name, description, size, price, status, quantity, type);
        dao.updateProduct(product);
        productList(request, response);
    }

    private void ShowEditProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Product product = dao.getProductById(Integer.parseInt(request.getParameter("id")));
        System.out.println(product);
        request.setAttribute("editProduct", product);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/edit_product.jsp");
        dispatcher.forward(request, response);
    }

    private void searchProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String search = request.getParameter("search");
        List<Product> products = dao.getProductByName(search);
        request.setAttribute("productList", products);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/home_admin.jsp");
        dispatcher.forward(request, response);
    }

    private void addProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("nameProduct");
        int price = Integer.parseInt(request.getParameter("priceProduct"));
        int quantity = Integer.parseInt(request.getParameter("quantityProduct"));
        String description = request.getParameter("descriptionProduct");
        String size = request.getParameter("size");
        String status = "";
        if (quantity <= 0) {
            status = "Out of stock";
        } else {
            status = "Available";
        }
        String image = request.getParameter("urlImage");
        String type = request.getParameter("category");
        Product product = new Product(name, description, size, price, status, quantity, image, type);
        dao.addProduct(product);
        productList(request, response);
    }

    private void ShowAddProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/add_product.jsp");
        dispatcher.forward(request, response);
    }

    private void productList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> products = new DAO().getAllProduct();
        request.setAttribute("productList", products);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/home_admin.jsp");
        dispatcher.forward(request, response);
    }
}
