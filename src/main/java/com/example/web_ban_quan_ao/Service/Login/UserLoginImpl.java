package com.example.web_ban_quan_ao.Service.Login;

import com.example.web_ban_quan_ao.Model.User;
import com.example.web_ban_quan_ao.Service.Login.IUserLogin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class UserLoginImpl implements IUserLogin {
    private String url = "jdbc:mysql://localhost:3306/web_ban_quan_ao";
    private String user = "root";
    private String password = "khanhanhanmiu";

    private static final String SELECT_USER_BY_ID = "SELECT idUser, userName, password, name, role, status FROM user WHERE userName = ? and password = ?";

    UserLoginImpl() {
    }

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }

    @Override
    public boolean checkLogin(String userName, String password) {
        Connection connection = getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);
            preparedStatement.setString(1, userName);
            preparedStatement.setString(2, password);
            if (preparedStatement.executeQuery().next()) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
