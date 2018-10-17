package com.xzy.pojo;

import java.io.Serializable;

/**
 * Created by css on 2018/7/23.
 */
public class DiscussImage implements Serializable {
    /*
    * `id` VARCHAR(64) NOT NULL,
  `path` VARCHAR(64) DEFAULT NULL,
  `descript` VARCHAR(128) DEFAULT NULL,
  `product_discuss_id` VARCHAR(64) DEFAULT NULL,
  `state` INT(11) DEFAULT NULL,
    * */
    private String id;
    private String path;
    private String descript;
    private String productDiscussId;
    private Integer state;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getDescript() {
        return descript;
    }

    public void setDescript(String descript) {
        this.descript = descript;
    }

    public String getProductDiscussId() {
        return productDiscussId;
    }

    public void setProductDiscussId(String productDiscussId) {
        this.productDiscussId = productDiscussId;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "DiscussImage{" +
                "id='" + id + '\'' +
                ", path='" + path + '\'' +
                ", descript='" + descript + '\'' +
                ", productDiscussId='" + productDiscussId + '\'' +
                ", state=" + state +
                '}';
    }
}
