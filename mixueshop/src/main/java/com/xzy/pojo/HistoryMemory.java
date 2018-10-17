package com.xzy.pojo;

import java.util.Date;

/**
 * Created by Dell on 2018/8/4.
 */
public class HistoryMemory {
    private String uid;
    private Integer pid;
    private Date time;
    private Product product;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "HistoryMemory{" +
                "uid='" + uid + '\'' +
                ", pid=" + pid +
                ", time=" + time +
                ", product=" + product +
                '}';
    }
}
