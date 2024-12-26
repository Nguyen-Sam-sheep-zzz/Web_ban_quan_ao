package com.example.web_ban_quan_ao.Service.Admin;

import com.example.web_ban_quan_ao.Model.User;

import java.util.List;

public interface IDAOUser {
    List<User> getAllUser();
    void addUser(User user);
    void updateUser(User user);
    void deleteUser(int id);
    User getUserById(int id);
    List<User> getUserByName(String name);
}
