package com.example.web_ban_quan_ao.Service.Admin;

import com.example.web_ban_quan_ao.Model.Product;

import java.util.List;

public interface IDAO {
    List<Product> getAllProduct();
    void addProduct(Product product);
    void updateProduct(Product product, int id);
    void deleteProduct(int id);
    Product getProductById(int id);
    Product getProductByName(String name);
}
