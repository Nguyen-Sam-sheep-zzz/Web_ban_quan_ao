package com.example.web_ban_quan_ao.Service.Admin;

import com.example.web_ban_quan_ao.ConnectionDB.ConnectionDB;
import com.example.web_ban_quan_ao.Model.User;

import java.sql.PreparedStatement;
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
        return new ArrayList<>();
    }

    @Override
    public void addUser(User user) {

    }

    @Override
    public void updateUser(User user) {

    }

    @Override
    public void deleteUser(int id) {

    }

    @Override
    public User getUserById(int id) {
        return null;
    }

    @Override
    public List<User> getUserByName(String name) {
        return null;
    }
}
