package com.example.web_ban_quan_ao.Controller;

import com.example.web_ban_quan_ao.Service.HelloServlet;
import com.example.web_ban_quan_ao.Service.Login.LoginImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/loginServlet")
public class LoginServlet extends HelloServlet {
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

        if (loginInfo != null) {
            String role = loginInfo[0];
            String status = loginInfo[1];
            String name = loginInfo[2];
            String id = loginInfo[3];
            if ("active".equalsIgnoreCase(status)) {
                HttpSession session = req.getSession();
                session.setAttribute("userId", id);
                if (role.equalsIgnoreCase("admin")) {
                    RequestDispatcher dispatcher = req.getRequestDispatcher("view/home_admin.jsp");
                    dispatcher.forward(req, resp);
                } else if (role.equalsIgnoreCase("user")) {
                    RequestDispatcher dispatcher = req.getRequestDispatcher("view/home_user.jsp");
                    dispatcher.forward(req, resp);
                } else {
                    req.setAttribute("errorMessage", "Tài khoản bị khóa!");
                    req.getRequestDispatcher("view/login.jsp").forward(req, resp);
                }
            }
        } else {
            req.setAttribute("errorMessage", "Sai tên đăng nhập hoặc mật khẩu, vui lòng đăng nhập lại!");
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
                case "register":
                    registerView(req, resp);
                    System.out.println(action);
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
    }
}
