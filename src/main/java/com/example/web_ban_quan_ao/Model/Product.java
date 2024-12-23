package com.example.web_ban_quan_ao.Model;

public class Product {
    private int idProduct;
    private String nameProduct;
    private String descriptionProduct;
    private String size;
    private double price;
    private String status;
    private int quantity;
    private String image;
    private String type;

    public Product(int idProduct, String nameProduct, String descriptionProduct, String size, double price, String status, int quantity, String type) {
        this.idProduct = idProduct;
        this.nameProduct = nameProduct;
        this.descriptionProduct = descriptionProduct;
        this.size = size;
        this.price = price;
        this.status = status;
        this.quantity = quantity;
        this.type = type;
    }

    public Product( String nameProduct, String descriptionProduct, String size, double price, String status, int quantity, String image, String type) {
        this.nameProduct = nameProduct;
        this.descriptionProduct = descriptionProduct;
        this.size = size;
        this.price = price;
        this.status = status;
        this.quantity = quantity;
        this.image = image;
        this.type = type;
    }

    public Product(String nameProduct, String descriptionProduct, String size, double price, String status, int quantity, String type) {
        this.nameProduct = nameProduct;
        this.descriptionProduct = descriptionProduct;
        this.size = size;
        this.price = price;
        this.status = status;
        this.quantity = quantity;
        this.type = type;
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

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Product{" +
                "idProduct=" + idProduct +
                ", nameProduct='" + nameProduct + '\'' +
                ", descriptionProduct='" + descriptionProduct + '\'' +
                ", size='" + size + '\'' +
                ", price=" + price +
                ", status='" + status + '\'' +
                ", quantity=" + quantity +
                '}';
    }


}
