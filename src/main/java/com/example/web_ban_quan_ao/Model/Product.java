package com.example.web_ban_quan_ao.Model;

public class Product {
    private int idProduct;
    private String nameProduct;
    private String descriptionProduct;
    private String size;
    private double price;
    private String status;
    private int quantity;
    public Product(int idProduct, String nameProduct, String descriptionProduct, String size, double price, String status, int quantity) {
        this.idProduct = idProduct;
        this.nameProduct = nameProduct;
        this.descriptionProduct = descriptionProduct;
        this.size = size;
        this.price = price;
        this.status = status;
        this.quantity = quantity;
    }

    public Product() {
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public String getDescriptionProduct() {
        return descriptionProduct;
    }

    public void setDescriptionProduct(String descriptionProduct) {
        this.descriptionProduct = descriptionProduct;
    }

    public String getColor() {
        return size;
    }

    public void setColor(String size) {
        this.size = size;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Product{" +
                "idProduct=" + idProduct +
                ", nameProduct='" + nameProduct + '\'' +
                ", descriptionProduct='" + descriptionProduct + '\'' +
                ", color='" + size + '\'' +
                ", price=" + price +
                ", status='" + status + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
