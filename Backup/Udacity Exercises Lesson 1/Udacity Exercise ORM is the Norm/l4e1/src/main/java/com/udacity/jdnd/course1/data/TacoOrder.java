package com.udacity.jdnd.course1.data;

public class TacoOrder {
   private int order_id;
   private String name;
   private double price;
   private int count;

    public TacoOrder(int order_id, String name, double price, int count) {
        this.order_id = order_id;
        this.name = name;
        this.price = price;
        this.count = count;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
