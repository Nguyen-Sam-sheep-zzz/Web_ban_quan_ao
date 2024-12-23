package com.example.web_ban_quan_ao.Service.Detail;

import com.example.web_ban_quan_ao.ConnectionDB.ConnectionDB;
import com.example.web_ban_quan_ao.Model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class DetailProductImpl implements DetailProductService {
    private ConnectionDB connectionDB = new ConnectionDB();
    private static final String SELECT_PRODUCTS_BY_ID =
            "SELECT i.link, p.nameProduct, p.productDescription, p.price, p.status, p.category, p.idProduct, i.idImage " +
                    "FROM Products p " +
                    "JOIN images i ON p.idProduct = i.idProduct " +
                    "WHERE p.idProduct = ? ";

    @Override
    public Product getDetailProductById(int id) {
        Product product = null;
        PreparedStatement preparedStatement;
        try {
            Connection connection = connectionDB.getConnection();
            preparedStatement = connection.prepareStatement(SELECT_PRODUCTS_BY_ID);
            preparedStatement.setInt(1, id);
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
                product = new Product(link, nameProduct, descriptionProduct, price, status, category, idProduct, idImage);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return product;
    }
}
