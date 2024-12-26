package com.example.web_ban_quan_ao.Service.Login;

import com.example.web_ban_quan_ao.ConnectionDB.ConnectionDB;
import com.example.web_ban_quan_ao.Service.ConnectDB;

import java.sql.*;

public class LoginImpl implements LoginService {

    private static final String loginCheck = "select * from users where LOWER(username) = LOWER(?) and password = ?";

    public LoginImpl() {

    }

    private ConnectionDB connectDB = new ConnectionDB();

    @Override
    public String[] checkLoginDB(String username, String password) {
        Connection connection = connectDB.getConnection();
        System.out.println(connection);
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(loginCheck);

            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                String role = resultSet.getString("role");
                String status = resultSet.getString("status");
                String name = resultSet.getString("name");
                String id = resultSet.getString("idUser");
                return new String[]{role, status, name, id};
            } else {
                return null;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
