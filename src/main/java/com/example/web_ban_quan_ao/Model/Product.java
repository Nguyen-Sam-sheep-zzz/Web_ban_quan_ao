package com.example.web_ban_quan_ao.Model;

public class Product {
    private int idProduct;
    private int idImage;
    private String nameProduct;
    private String descriptionProduct;
    private String size;
    private double price;
    private String status;
    private int quantity;
    private String urlImage;
    private String choice;

    public String getChoice() {
        return choice;
    }

    public void setChoice(String choice) {
        this.choice = choice;
    }

    public Product(int idProduct, String nameProduct, String descriptionProduct, String size, double price, String status, int quantity) {
        this.idProduct = idProduct;
        this.nameProduct = nameProduct;
        this.descriptionProduct = descriptionProduct;
        this.size = size;
        this.price = price;
        this.status = status;
        this.quantity = quantity;
    }

    public int getIdImage() {
        return idImage;
    }

    public void setIdImage(int idImage) {
        this.idImage = idImage;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public Product(String urlImage, String nameProduct, String descriptionProduct, double price, String status, String choice ,int idProduct, int idImage) {
        this.urlImage = urlImage;
        this.nameProduct = nameProduct;
        this.descriptionProduct = descriptionProduct;
        this.price = price;
        this.status = status;
        this.choice = choice;
        this.idProduct = idProduct;
        this.idImage = idImage;
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

    @Override
    public String toString() {
        return "Product{" +
                "idProduct=" + idProduct +
                ", idImage=" + idImage +
                ", nameProduct='" + nameProduct + '\'' +
                ", descriptionProduct='" + descriptionProduct + '\'' +
                ", size='" + size + '\'' +
                ", price=" + price +
                ", status='" + status + '\'' +
                ", quantity=" + quantity +
                ", urlImage='" + urlImage + '\'' +
                '}';
    }
}
