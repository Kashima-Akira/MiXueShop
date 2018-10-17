package com.xzy.pojo;

import java.io.Serializable;

/**
 * Created by css on 2018/7/23.
 */
public class ActivityImage implements Serializable{
    private String id;
    private String path;
    private String activityId;
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

    public String getActivityId() {
        return activityId;
    }

    public void setActivityId(String activityId) {
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
        return "ActivityImage{" +
                "id='" + id + '\'' +
                ", path='" + path + '\'' +
                ", activityId='" + activityId + '\'' +
                ", state=" + state +
                '}';
    }
}
