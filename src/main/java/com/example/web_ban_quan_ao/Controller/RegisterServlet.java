package com.example.web_ban_quan_ao.Controller;

import com.example.web_ban_quan_ao.Service.Register.RegisterImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RegisterServlet", value = "/registerServlet")
public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private RegisterImpl registerImpl;

    public void init() {
        registerImpl = new RegisterImpl();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        handleRegister(req, resp);
    }

    public void handleRegister(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String fullName = req.getParameter("fullname");
        String Rpassword = req.getParameter("Rpassword");

        if (username.isEmpty() || password.isEmpty() || fullName.isEmpty()) {
            req.setAttribute("errorMessage", "Please fill in the registration information completely");
            req.getRequestDispatcher("view/register.jsp").forward(req, resp);
            return;
        }
        if (username.length() < 6) {
            req.setAttribute("errorMessage", "Username must be at least 6 characters");
            req.getRequestDispatcher("view/register.jsp").forward(req, resp);
            return;
        }
        if (username.length() > 30) {
            req.setAttribute("errorMessage", "Username cannot exceed 30 characters");
            req.getRequestDispatcher("view/register.jsp").forward(req, resp);
            return;
        }
        if (!validateUsernameRegister(username)) {
            req.setAttribute("errorMessage", "Spaces and diacritics cannot exist in username");
            req.getRequestDispatcher("view/register.jsp").forward(req, resp);
            return;
        }
        if (!password.equals(Rpassword)) {
            req.setAttribute("errorMessage", "Passwords do not match, please re-enter your password");
            req.getRequestDispatcher("view/register.jsp").forward(req, resp);
            return;
        }
        if (password.length() < 6) {
            req.setAttribute("errorMessage", "Password must be at least 6 characters");
            req.getRequestDispatcher("view/register.jsp").forward(req, resp);
            return;
        }
        if (password.length() > 100) {
            req.setAttribute("errorMessage", "Password limit 100 characters");
            req.getRequestDispatcher("view/register.jsp").forward(req, resp);
            return;
        }
        if (!password.matches(".*[0-9].*")) {
            req.setAttribute("errorMessage", "");
            req.getRequestDispatcher("view/register.jsp").forward(req, resp);
            return;
        }

        if (fullName.length() > 100) {
            req.setAttribute("errorMessage", "Your full name cannot exceed 100 characters");
            req.getRequestDispatcher("view/register.jsp").forward(req, resp);
            return;
        }
        if (!validateUFullName(fullName)) {
            req.setAttribute("errorMessage", "You cannot have numbers in your full name");
            req.getRequestDispatcher("view/register.jsp").forward(req, resp);
            return;
        }
        if (registerImpl.registerUser(username, password, fullName)) {
            req.setAttribute("successMessage", "Account created successfully!");
            req.getRequestDispatcher("view/login.jsp").forward(req, resp);
        } else {
            req.setAttribute("errorMessage", "Username already exists. Please choose another name");
            req.getRequestDispatcher("view/register.jsp").forward(req, resp);
        }
    }


    private boolean validateUFullName(String fullName) {
        String regex = "^[^0-9]*$";
        return fullName.matches(regex);
    }

    private boolean validateUsernameRegister(String username) {
        String regex = "^[a-zA-Z0-9]*$";
        return username.matches(regex);
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
                    System.out.println(action);
                    break;
                default:
                    registerView(req, resp);
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
