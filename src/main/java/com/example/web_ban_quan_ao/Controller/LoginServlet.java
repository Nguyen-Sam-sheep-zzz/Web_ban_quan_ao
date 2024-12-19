package com.example.web_ban_quan_ao.Controller;

import com.example.web_ban_quan_ao.Service.Admin.DAO;
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
    private DAO dao = new DAO();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        handleLogin(req, resp);
    }

    private void handleLogin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        System.out.println(username + " " + password);
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
                    req.setAttribute("productList", dao.getAllProduct());
                    System.out.println(dao.getAllProduct());
                    RequestDispatcher dispatcher = req.getRequestDispatcher("view/home_admin.jsp");
                    dispatcher.forward(req, resp);
                } else if (role.equalsIgnoreCase("user")) {
                    RequestDispatcher dispatcher = req.getRequestDispatcher("view/home_user.jsp");
                    dispatcher.forward(req, resp);
                }
                else {
                    System.out.println("bị ban rồi");
                }
            }
        }
        else {
            System.out.println("error ???");
        }
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

    }
}
