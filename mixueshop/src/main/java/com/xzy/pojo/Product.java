package com.xzy.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by css on 2018/7/23.
 */
public class Product implements Serializable {
    /*
    * `id` INT(11) NOT NULL,
  `NAME` VARCHAR(64) DEFAULT NULL,
  `descript` VARCHAR(128) DEFAULT NULL,
  `number` INT(11) DEFAULT NULL,
  `buy_number` INT(11) DEFAULT NULL,
  `is_hot` INT(11) DEFAULT NULL,
  `created` DATETIME DEFAULT NULL,
  `updated` DATETIME DEFAULT NULL,
  `state` INT(11) DEFAULT NULL,
  `category_id` INT(11) DEFAULT NULL,
    * */
    private Integer id;
    private String name;
    private String descript;
    private Integer number;
    private Integer buyNumber;
    private Integer isHot;
    private Date created;
    private Date updated;
    private Integer state;
    private Integer categoryId;
    private Integer level;
    private Category category;
    private List<Activity> activities;
    private List<Coupon> coupons;
    private List<Price> prices;
    private List<ProductImage> productImages;
    private List<ProductDiscuss> productDiscusses;

    public List<ProductDiscuss> getProductDiscusses() {
        return productDiscusses;
    }

    public void setProductDiscusses(List<ProductDiscuss> productDiscusses) {
        this.productDiscusses = productDiscusses;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescript() {
        return descript;
    }

    public void setDescript(String descript) {
        this.descript = descript;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getBuyNumber() {
        return buyNumber;
    }

    public void setBuyNumber(Integer buyNumber) {
        this.buyNumber = buyNumber;
    }

    public Integer getIsHot() {
        return isHot;
    }

    public void setIsHot(Integer isHot) {
        this.isHot = isHot;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Activity> getActivities() {
        return activities;
    }

    public void setActivities(List<Activity> activities) {
        this.activities = activities;
    }

    public List<Coupon> getCoupons() {
        return coupons;
    }

    public void setCoupons(List<Coupon> coupons) {
        this.coupons = coupons;
    }

    public List<Price> getPrices() {
        return prices;
    }

    public void setPrices(List<Price> prices) {
        this.prices = prices;
    }

    public List<ProductImage> getProductImages() {
        return productImages;
    }

    public void setProductImages(List<ProductImage> productImages) {
        this.productImages = productImages;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", descript='" + descript + '\'' +
                ", number=" + number +
                ", buyNumber=" + buyNumber +
                ", level=" + level +
                ", isHot=" + isHot +
                ", created=" + created +
                ", updated=" + updated +
                ", state=" + state +
                ", categoryId=" + categoryId +
                ", level=" + level +
                ", category=" + category +
                ", activities=" + activities +
                ", coupons=" + coupons +
                ", prices=" + prices +
                ", productImages=" + productImages +
                ", productDiscusses=" + productDiscusses +
                '}';
    }
}
