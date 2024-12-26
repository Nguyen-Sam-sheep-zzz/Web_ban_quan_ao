package com.example.web_ban_quan_ao.Service.Admin;

import com.example.web_ban_quan_ao.ConnectionDB.ConnectionDB;
import com.example.web_ban_quan_ao.Model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DAOProduct implements IDAOProduct {
    ConnectionDB connectionDB = new ConnectionDB();
    private String get_all_product = "SELECT products.*, images.link " +
            "FROM web_ban_quan_ao.products " +
            "LEFT JOIN web_ban_quan_ao.images " +
            "ON products.idProduct = images.idProduct";
    private String add_product = "insert into products (nameProduct, productDescription, size, price, status, quantity, category) values (?, ?, ?, ?, ?, ?,?);";
    private String add_image = "insert into images (idProduct, link) values (?, ?);";
    private String update_product = "update products set nameProduct = ?, productDescription = ?, size = ?, price = ?, status = ?, quantity = ? where idProduct = ?";

    private String update_product_image = "update images set link = ? where idProduct = ?";
    private String delete_product = "delete from products where idProduct = ?" +
            "delete from images where idProduct = ?";
    private String get_all_product_by_id = "SELECT products.*, images.link " +
            "from web_ban_quan_ao.products " +
            "LEFT JOIN web_ban_quan_ao.images " +
            "ON products.idProduct = images.idProduct " +
            "WHERE web_ban_quan_ao.products.idProduct = ?";
    private String get_all_product_by_name = "SELECT products.*, images.link " +
            "from web_ban_quan_ao.products " +
            "LEFT JOIN web_ban_quan_ao.images " +
            "on products.idProduct = images.idProduct " +
            "WHERE web_ban_quan_ao.products.nameProduct like '%' ? '%'";
    private String Change_status_product = "update products set status = ? where idProduct = ?";

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
                String urlImage = resultSet.getString("link");
                Product product = new Product(urlImage, idProduct, nameProduct, descriptionProduct, size, price, status, quantity, type);
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
        ResultSet generatedKeys = null;
        int idProduct = 0;
        try {
            Connection connection = connectionDB.getConnection();
            preparedStatement = connection.prepareStatement(add_product);
            preparedStatement.setString(1, product.getNameProduct());
            preparedStatement.setString(2, product.getDescriptionProduct());
            preparedStatement.setString(3, product.getSize());
            preparedStatement.setDouble(4, product.getPrice());
            preparedStatement.setString(5, product.getStatus());
            preparedStatement.setInt(6, product.getQuantity());
            preparedStatement.setString(7, product.getChoice());
            preparedStatement.execute();
            generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                idProduct = generatedKeys.getInt(1);
            }
            preparedStatement = connection.prepareStatement(add_image);
            preparedStatement.setInt(1, idProduct);
            preparedStatement.setString(2, product.getUrlImage());
            preparedStatement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateProduct(Product product) {
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
            preparedStatement.setInt(7, product.getIdProduct());
            preparedStatement.execute();
            preparedStatement = connection.prepareStatement(update_product_image);
            preparedStatement.setString(1, product.getUrlImage());
            preparedStatement.setInt(2, product.getIdProduct());
            preparedStatement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public Product getProductById(int id) {
        Product product = null;
        PreparedStatement preparedStatement = null;
        try {
            Connection connection = connectionDB.getConnection();
            preparedStatement = connection.prepareStatement(get_all_product_by_id);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getResultSet();
            while (resultSet.next()) {
                String nameProduct = resultSet.getString("nameProduct");
                String descriptionProduct = resultSet.getString("productDescription");
                String size = resultSet.getString("size");
                double price = resultSet.getDouble("price");
                String status = resultSet.getString("status");
                int quantity = resultSet.getInt("quantity");
                String type = resultSet.getString("category");
                String urlImage = resultSet.getString("link");
                product = new Product(urlImage, id, nameProduct, descriptionProduct, size, price, status, quantity, type);
            }
            return product;
        } catch (Exception e) {
            e.printStackTrace();
            return product;
        }
    }

    @Override
    public List<Product> getProductByName(String name) {
        List<Product> products = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        try {
            Connection connection = connectionDB.getConnection();
            preparedStatement = connection.prepareStatement(get_all_product_by_name);
            preparedStatement.setString(1, name);
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
                String urlImage = resultSet.getString("link");
                Product product = new Product(urlImage, idProduct, nameProduct, descriptionProduct, size, price, status, quantity, type);
                products.add(product);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return products;
    }

}
