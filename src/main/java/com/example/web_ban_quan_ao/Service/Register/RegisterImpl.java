package com.example.web_ban_quan_ao.Service.Register;

import com.example.web_ban_quan_ao.Service.ConnectDB;

import java.sql.*;

public class RegisterImpl implements RegisterService {

    private ConnectDB connectDB = new ConnectDB();
    private final String register = "insert into users (username, password, name, role, status) values (?,?,?,?,?)";
    private final String checkUser = "select * from users where username = ?";

    public RegisterImpl() {

    }

    public boolean registerUser(String username, String password, String uFullname) {
        Connection connection = connectDB.getConnection();
        PreparedStatement preparedStatement;

        if (checkUsername(username)) {
            return false;
        }

        try {
            preparedStatement = connection.prepareStatement(register);

            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            preparedStatement.setString(3, uFullname);
            preparedStatement.setString(4, "user");
            preparedStatement.setString(5, "active");

            int row = preparedStatement.executeUpdate();

            if (row > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return false;
    }

    @Override
    public boolean checkUsername(String username) {
        Connection connection = connectDB.getConnection();
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(checkUser);

            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int count = resultSet.getInt(1);
                if (count > 0) {
                    return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return false;
    }
}
