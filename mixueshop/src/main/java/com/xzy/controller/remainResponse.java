package com.xzy.controller;

import java.io.Serializable;
import java.util.Date;

public class remainResponse implements Serializable
{
    private Object id;
    private Object imagepath;
    private Object name;
    private Object orderstime;
    private Object state;

    public Object getId() {
        return id;
    }

    public void setId(Object id) {
        this.id = id;
    }

    public Object getImagepath() {
        return imagepath;
    }

    public void setImagepath(Object imagepath) {
        this.imagepath = imagepath;
    }

    public Object getName() {
        return name;
    }

    public void setName(Object name) {
        this.name = name;
    }

    public Object getOrderstime() {
        return orderstime;
    }

    public void setOrderstime(Object orderstime) {
        this.orderstime = orderstime;
    }

    public Object getState() {
        return state;
    }

    public void setState(Object state) {
        this.state = state;
    }
}
