package com.example.web_ban_quan_ao.Service.HomeUser;

import com.example.web_ban_quan_ao.Model.Product;
import com.example.web_ban_quan_ao.Model.User;

import java.util.List;

public interface HomeUserService {
    List<Product> getAllProductDisplayUser();

    List<Product> getAllProductCategories(String choice);

    List<Product> searchProductByName(String name);
}
