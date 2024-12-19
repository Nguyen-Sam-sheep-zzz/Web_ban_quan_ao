package com.example.web_ban_quan_ao.Service.Login;

import java.sql.*;

public class LoginImpl implements LoginService {
    private String url = "jdbc:mysql://localhost:3306/Web_ban_quan_ao?useSSL=true&serverTimezone=UTC";

    private String jdbcUsername = "root";
//    private String jdbcPassword = "123456";
    private String jdbcPassword = "khanhanhanmiu";

    private static final String loginCheck = "select * from users where LOWER(username) = LOWER(?) and password = ?";

    public LoginImpl() {

    }

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }

    @Override
    public String[] checkLoginDB(String username, String password) {
        Connection connection = getConnection();
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
