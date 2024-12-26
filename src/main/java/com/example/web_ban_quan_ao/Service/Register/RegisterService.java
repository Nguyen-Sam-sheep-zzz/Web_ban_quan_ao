package com.example.web_ban_quan_ao.Service.Register;

public interface RegisterService {
    boolean checkUsername(String username);
    boolean registerUser(String username, String password, String uFullname);
}
