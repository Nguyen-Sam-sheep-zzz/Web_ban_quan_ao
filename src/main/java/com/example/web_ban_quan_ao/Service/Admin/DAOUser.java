package com.example.web_ban_quan_ao.Service.Admin;

import com.example.web_ban_quan_ao.ConnectionDB.ConnectionDB;
import com.example.web_ban_quan_ao.Model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DAOUser implements IDAOUser {
    ConnectionDB connectionDB = new ConnectionDB();

    String get_all_user = "select * from users";
    String get_user_by_id = "select * from users where idUser = ?";
    String get_user_by_name = "select * from users where username = ?";
    String add_user = "insert into users(username, password, name, role, status) values(?, ?, ?, ?, ?)";
    String update_user = "update users set username = ?, password = ?,name = ?, role = ?, status = ? where idUser = ?";

    @Override
    public List<User> getAllUser() {
        Connection connection = connectionDB.getConnection();
        PreparedStatement preparedStatement = null;
        List<User> users = new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement(get_all_user);
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getResultSet();
            while (resultSet.next()) {
                int idUser = resultSet.getInt("idUser");
                String userName = resultSet.getString("username");
                String password = resultSet.getString("password");
                String name = resultSet.getString("name");
                String role = resultSet.getString("role");
                String status = resultSet.getString("status");
                User user = new User(idUser, userName, password, name, role, status);
                users.add(user);
            }
            return users;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void addUser(User user) {
        Connection connection = connectionDB.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(add_user);
            preparedStatement.setString(1, user.getUserName());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getName());
            preparedStatement.setString(4, user.getRole());
            preparedStatement.setString(5, user.getStatus());
            preparedStatement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateUser(User user) {
        Connection connection = connectionDB.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(update_user);
            preparedStatement.setString(1, user.getUserName());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getName());
            preparedStatement.setString(4, user.getRole());
            preparedStatement.setString(5, user.getStatus());
            preparedStatement.setInt(6, user.getIdUser());
            preparedStatement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public User getUserById(int id) {
        Connection connection = connectionDB.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(get_user_by_id);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getResultSet();
            while (resultSet.next()) {
                int idUser = resultSet.getInt("idUser");
                String userName = resultSet.getString("username");
                String password = resultSet.getString("password");
                String name = resultSet.getString("name");
                String role = resultSet.getString("role");
                String status = resultSet.getString("status");
                User user = new User(idUser, userName, password, name, role, status);
                return user;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<User> getUserByName(String name) {
        Connection connection = connectionDB.getConnection();
        PreparedStatement preparedStatement = null;
        List<User> users = new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement(get_user_by_name);
            preparedStatement.setString(1, name);
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getResultSet();
            while (resultSet.next()) {
                int idUser = resultSet.getInt("idUser");
                String userName = resultSet.getString("username");
                String password = resultSet.getString("password");
                String name1 = resultSet.getString("name");
                String role = resultSet.getString("role");
                String status = resultSet.getString("status");
                User user = new User(idUser, userName, password, name1, role, status);
                users.add(user);
            }
            return users;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
