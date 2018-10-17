package com.xzy.pojo;

import java.io.Serializable;

/**
 * Created by css on 2018/7/23.
 */
public class ActivityMapper implements Serializable {
    private String id;
    private String userId;
    private Integer productId;
    private Integer activityId;
    private Integer state;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getActivityId() {
        return activityId;
    }

    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "ActivityMapper{" +
                "id='" + id + '\'' +
                ", userId='" + userId + '\'' +
                ", productId=" + productId +
                ", activityId=" + activityId +
                ", state=" + state +
                '}';
    }
}
