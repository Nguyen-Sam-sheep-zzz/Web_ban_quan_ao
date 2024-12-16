package com.example.web_ban_quan_ao.Model;

public class Image {
    private int idImage;
    private int idProduct;
    private String link;

    public Image(int idImage, int idProduct, String link) {
        this.idImage = idImage;
        this.idProduct = idProduct;
        this.link = link;
    }

    public Image() {
    }

    public int getIdImage() {
        return idImage;
    }

    public void setIdImage(int idImage) {
        this.idImage = idImage;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Override
    public String toString() {
        return "Image{" +
                "idImage=" + idImage +
                ", idProduct=" + idProduct +
                ", link='" + link + '\'' +
                '}';
    }
}
