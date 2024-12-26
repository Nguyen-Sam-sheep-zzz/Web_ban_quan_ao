package com.example.web_ban_quan_ao.Controller;

import com.example.web_ban_quan_ao.Service.Login.LoginImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/loginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private LoginImpl loginImpl;

    public void init() {
        loginImpl = new LoginImpl();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        handleLogin(req, resp);
    }

    private void handleLogin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String[] loginInfo = loginImpl.checkLoginDB(username, password);

        if (username.isEmpty() || password.isEmpty()) {
            req.setAttribute("errorMessage", "Fields cannot be left blank!");
            req.getRequestDispatcher("view/login.jsp").forward(req, resp);
        }

        if (loginInfo != null) {
            String role = loginInfo[0];
            String status = loginInfo[1];
            String name = loginInfo[2];
            String id = loginInfo[3];
            if ("active".equalsIgnoreCase(status)) {
                HttpSession session = req.getSession();
                session.setAttribute("userId", id);
                if (role.equalsIgnoreCase("admin")) {
                    resp.sendRedirect("/home_admin");
                } else if (role.equalsIgnoreCase("user")) {
                    resp.sendRedirect("/homeUserServlet");
                }
            } else {
                req.setAttribute("errorMessage", "Account locked!");
                req.getRequestDispatcher("view/login.jsp").forward(req, resp);
            }
        } else {
            req.setAttribute("errorMessage", "Wrong username or password, please log in again!");
            req.getRequestDispatcher("view/login.jsp").forward(req, resp);
        }
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }

        try {
            switch (action) {
                case "login":
                    loginView(req, resp);
                    break;
                case "register":
                    registerView(req, resp);
                    break;
                default:
                    loginView(req, resp);
                    break;
            }
        } catch (ServletException e) {
            throw new RuntimeException(e);
        }
    }

    private void registerView(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("view/register.jsp");
        dispatcher.forward(req, resp);
    }

    private void loginView(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("view/login.jsp");
        dispatcher.forward(req, resp);
        HttpSession session = req.getSession();
        session.invalidate();
    }
}
