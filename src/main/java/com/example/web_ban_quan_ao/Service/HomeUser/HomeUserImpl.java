package com.example.web_ban_quan_ao.Service.HomeUser;

import com.example.web_ban_quan_ao.ConnectionDB.ConnectionDB;
import com.example.web_ban_quan_ao.Model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class HomeUserImpl implements HomeUserService {
    private static final String SELECT_PRODUCTS_BY_CATEGORY =
            "SELECT i.link, p.nameProduct, p.productDescription, p.price, p.status, p.category, p.idProduct, i.idImage " +
                    "FROM Products p " +
                    "JOIN images i ON p.idProduct = i.idProduct " +
                    "WHERE p.category = ? ";

    private static final String SELECT_ALL_PRODUCTS_DISPLAY = "SELECT i.link, p.nameProduct, p.productDescription, p.price, p.status, p.category, p.idProduct, i.idImage " +
            "FROM Products p " +
            "JOIN images i ON p.idProduct = i.idProduct";

    private static final String SEARCH_PRODUCT_BY_NAME =
            "SELECT i.link, p.nameProduct, p.productDescription, p.price, p.status, p.category, p.idProduct, i.idImage " +
                    "FROM Products p " +
                    "JOIN images i ON p.idProduct = i.idProduct " +
                    "WHERE p.nameProduct LIKE ? ";


    private ConnectionDB connectionDB = new ConnectionDB();

    @Override
    public List<Product> getAllProductDisplayUser() {
        List<Product> products = new ArrayList<>();
        PreparedStatement preparedStatement;
        try {
            Connection connection = connectionDB.getConnection();
            preparedStatement = connection.prepareStatement(SELECT_ALL_PRODUCTS_DISPLAY);

            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getResultSet();
            while (resultSet.next()) {
                String link = resultSet.getString("link");
                String nameProduct = resultSet.getString("nameProduct");
                String descriptionProduct = resultSet.getString("productDescription");
                double price = resultSet.getDouble("price");
                String status = resultSet.getString("status");
                String category = resultSet.getString("category");
                int idProduct = resultSet.getInt("idProduct");
                int idImage = resultSet.getInt("idImage");
                Product product = new Product(link, nameProduct, descriptionProduct, price, status, category, idProduct, idImage);
                products.add(product);
            }
            return products;
        } catch (Exception e) {
            e.printStackTrace();
            return products;
        }
    }

    @Override
    public List<Product> getAllProductCategories(String choice) {
        List<Product> products = new ArrayList<>();
        PreparedStatement preparedStatement;
        try {
            Connection connection = connectionDB.getConnection();
            preparedStatement = connection.prepareStatement(SELECT_PRODUCTS_BY_CATEGORY);
            preparedStatement.setString(1, choice);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String link = resultSet.getString("link");
                String nameProduct = resultSet.getString("nameProduct");
                String descriptionProduct = resultSet.getString("productDescription");
                double price = resultSet.getDouble("price");
                String status = resultSet.getString("status");
                String category = resultSet.getString("category");
                int idProduct = resultSet.getInt("idProduct");
                int idImage = resultSet.getInt("idImage");
                Product product = new Product(link, nameProduct, descriptionProduct, price, status, category, idProduct, idImage);
                products.add(product);
            }
            return products;
        } catch (Exception e) {
            e.printStackTrace();
            return products;
        }
    }

    @Override
    public List<Product> searchProductByName(String name) {
        List<Product> products = new ArrayList<>();
        PreparedStatement preparedStatement;
        try {
            Connection connection = connectionDB.getConnection();
            preparedStatement = connection.prepareStatement(SEARCH_PRODUCT_BY_NAME);
            preparedStatement.setString(1, "%" + name + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String link = resultSet.getString("link");
                String nameProduct = resultSet.getString("nameProduct");
                String descriptionProduct = resultSet.getString("productDescription");
                double price = resultSet.getDouble("price");
                String status = resultSet.getString("status");
                String category = resultSet.getString("category");
                int idProduct = resultSet.getInt("idProduct");
                int idImage = resultSet.getInt("idImage");
                Product product = new Product(link, nameProduct, descriptionProduct, price, status, category, idProduct, idImage);
                products.add(product);
            }
            return products;
        } catch (Exception e) {
            e.printStackTrace();
            return products;
        }
    }

}
