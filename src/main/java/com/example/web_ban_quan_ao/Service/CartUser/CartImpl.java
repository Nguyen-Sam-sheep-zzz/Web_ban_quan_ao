package com.example.web_ban_quan_ao.Service.CartUser;

import com.example.web_ban_quan_ao.ConnectionDB.ConnectionDB;
import com.example.web_ban_quan_ao.Model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CartImpl implements CartService {
    private ConnectionDB connectionDB = new ConnectionDB();
    private static final String SELECT_ALL_USER = "select * from users where idUser = ?" ;
    @Override
    public User getUserById(int id) {
        User user = null;
        PreparedStatement preparedStatement;
        try {
            Connection connection = connectionDB.getConnection();
            preparedStatement = connection.prepareStatement(SELECT_ALL_USER);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
               int idUser = resultSet.getInt("idUser");
               String username = resultSet.getString("username");
               String password = resultSet.getString("password");
               String name = resultSet.getString("name");
               String role = resultSet.getString("role");
               String status = resultSet.getString("status");
               String address = resultSet.getString("address");
               user = new User(idUser, username, password, name, role, status, address);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }
}
