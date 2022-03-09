package com.udacity.jdnd.course1.data;

import java.sql.Timestamp;

public class Delivery {
    private int id;
    private int order_id;
    private Timestamp time;

    public Delivery(int id, int order_id, Timestamp time) {
        this.id = id;
        this.order_id = order_id;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }
}
