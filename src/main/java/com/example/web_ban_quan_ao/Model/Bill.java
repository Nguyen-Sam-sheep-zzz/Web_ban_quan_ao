package com.example.web_ban_quan_ao.Model;

public class Bill {
    private int idBill;
    private String idOrder;
    private String idUser;
    private String issueDate;
    private double total_amount;

    public Bill(int idBill, String idOrder, String idUser, String issueDate, double total_amount) {
        this.idBill = idBill;
        this.idOrder = idOrder;
        this.idUser = idUser;
        this.issueDate = issueDate;
        this.total_amount = total_amount;
    }

    public int getIdBill() {
        return idBill;
    }

    public void setIdBill(int idBill) {
        this.idBill = idBill;
    }

    public String getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(String idOrder) {
        this.idOrder = idOrder;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(String issueDate) {
        this.issueDate = issueDate;
    }

    public double getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(double total_amount) {
        this.total_amount = total_amount;
    }

    public Bill() {
    }

    @Override
    public String toString() {
        return "Bill{" +
                "idBill=" + idBill +
                ", idOrder='" + idOrder + '\'' +
                ", idUser='" + idUser + '\'' +
                ", issueDate='" + issueDate + '\'' +
                ", total_amount=" + total_amount +
                '}';
    }
}
