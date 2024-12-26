package com.example.web_ban_quan_ao.Model;

public class Order {
    private int idOrder;
    private String idUser;
    private String orderDate;
    private String paymentStatus;

    public Order(int idOrder, String idUser, String orderDate, String paymentStatus) {
        this.idOrder = idOrder;
        this.idUser = idUser;
        this.orderDate = orderDate;
        this.paymentStatus = paymentStatus;
    }

    public Order() {
    }

    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    @Override
    public String toString() {
        return "Order{" +
                "idOrder=" + idOrder +
                ", idUser='" + idUser + '\'' +
                ", orderDate='" + orderDate + '\'' +
                ", paymentStatus='" + paymentStatus + '\'' +
                '}';
    }
}
