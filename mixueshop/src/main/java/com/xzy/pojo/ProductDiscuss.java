package com.xzy.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by css on 2018/7/23.
 */
public class ProductDiscuss implements Serializable {
    /*
    * `id` VARCHAR(64) NOT NULL,
  `descript` VARCHAR(128) DEFAULT NULL,
  `created` DATETIME DEFAULT NULL,
  `good` INT(11) DEFAULT NULL,
  `bad` INT(11) DEFAULT NULL,
  `state` INT(11) DEFAULT NULL,
  `order_item_id` VARCHAR(64) DEFAULT NULL,
  `user_id` VARCHAR(64) DEFAULT NULL,
  `orders_item` INT(11) DEFAULT NULL,
    *
    * */
    private String id;
    private String descript;
    private Date created;
    private Integer good;
    private Integer bad;
    private Integer state;
    private Integer productId;
    private String userId;
    private String ordersId;
    private User user;
    private List<DiscussImage> discussImages;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescript() {
        return descript;
    }

    public void setDescript(String descript) {
        this.descript = descript;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Integer getGood() {
        return good;
    }

    public void setGood(Integer good) {
        this.good = good;
    }

    public Integer getBad() {
        return bad;
    }

    public void setBad(Integer bad) {
        this.bad = bad;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getOrdersId() {
        return ordersId;
    }

    public void setOrdersId(String ordersId) {
        this.ordersId = ordersId;
    }

    public List<DiscussImage> getDiscussImages() {
        return discussImages;
    }

    public void setDiscussImages(List<DiscussImage> discussImages) {
        this.discussImages = discussImages;
    }

    @Override
    public String toString() {
        return "ProductDiscuss{" +
                "id='" + id + '\'' +
                ", descript='" + descript + '\'' +
                ", created=" + created +
                ", good=" + good +
                ", bad=" + bad +
                ", state=" + state +
                ", productId=" + productId +
                ", userId='" + userId + '\'' +
                ", ordersId='" + ordersId + '\'' +
                ", user=" + user +
                ", discussImages=" + discussImages +
                '}';
    }
}
