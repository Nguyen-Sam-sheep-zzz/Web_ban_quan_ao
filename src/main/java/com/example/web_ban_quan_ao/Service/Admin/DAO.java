package com.example.web_ban_quan_ao.Service.Admin;

import com.example.web_ban_quan_ao.ConnectionDB.ConnectionDB;
import com.example.web_ban_quan_ao.Model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DAO implements IDAO {
    ConnectionDB connectionDB = new ConnectionDB();
    private String get_all_product = "select * from web_ban_quan_ao.products";
    private String add_product = "insert into products (nameProduct, productDescription, size, price, status, quantity) values (?, ?, ?, ?, ?, ?)";
    private String add_img = "insert into images (link, idProduct) values (?, ?)";
    private String update_img = "update images set link = ? where idProduct = ?";
    private String update_product = "update products set nameProduct = ?, productDescription = ?, size = ?, price = ?, status = ?, quantity = ? where idProduct = ?";
    private String delete_product = "delete from products where idProduct = ?";
    private String get_product_by_id = "select * from products where idProduct = ?";
    private String get_product_by_name = "select * from products where nameProduct LIKE '%' ? '%'";

    @Override
    public List<Product> getAllProduct() {
        List<Product> products = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        try {
            Connection connection = connectionDB.getConnection();
            preparedStatement = connection.prepareStatement(get_all_product);
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getResultSet();
            while (resultSet.next()) {
                int idProduct = resultSet.getInt("idProduct");
                String nameProduct = resultSet.getString("nameProduct");
                String descriptionProduct = resultSet.getString("productDescription");
                String size = resultSet.getString("size");
                double price = resultSet.getDouble("price");
                String status = resultSet.getString("status");
                int quantity = resultSet.getInt("quantity");
                String type = resultSet.getString("category");
                Product product = new Product(idProduct, nameProduct, descriptionProduct, size, price, status, quantity);
                products.add(product);
            }
            return products;
        } catch (Exception e) {
            e.printStackTrace();
            return products;
        }
    }

    @Override
    public void addProduct(Product product) {
        PreparedStatement preparedStatement = null;
        try {
            Connection connection = connectionDB.getConnection();
            preparedStatement = connection.prepareStatement(add_product);
            preparedStatement.setString(1, product.getNameProduct());
            preparedStatement.setString(2, product.getDescriptionProduct());
            preparedStatement.setString(3, product.getSize());
            preparedStatement.setDouble(4, product.getPrice());
            preparedStatement.setString(5, product.getStatus());
            preparedStatement.setInt(6, product.getQuantity());
            preparedStatement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateProduct(Product product, int id) {
        PreparedStatement preparedStatement = null;
        try {
            Connection connection = connectionDB.getConnection();
            preparedStatement = connection.prepareStatement(update_product);
            preparedStatement.setString(1, product.getNameProduct());
            preparedStatement.setString(2, product.getDescriptionProduct());
            preparedStatement.setString(3, product.getSize());
            preparedStatement.setDouble(4, product.getPrice());
            preparedStatement.setString(5, product.getStatus());
            preparedStatement.setInt(6, product.getQuantity());
            preparedStatement.setInt(7, id);
            preparedStatement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteProduct(int id) {
        PreparedStatement preparedStatement = null;
        try {
            Connection connection = connectionDB.getConnection();
            preparedStatement = connection.prepareStatement(delete_product);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Product getProductById(int id) {
        return null;
    }

    @Override
    public Product getProductByName(String name) {
        return null;
    }
}
