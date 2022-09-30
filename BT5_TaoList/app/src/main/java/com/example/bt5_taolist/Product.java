package com.example.bt5_taolist;

public class Product {
    int productID;
    int img;
    String name;
    long price;
    String status;
    int sale;

    public Product(int id, int img, String name, long price, String status,int sale ) {
        this.productID=id;
        this.img = img;
        this.name = name;
        this.price = price;
        this.status= status;
        this.sale = sale;
    }


}
