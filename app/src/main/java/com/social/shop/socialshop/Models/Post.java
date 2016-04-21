package com.social.shop.socialshop.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Creado por Deimer, fecha: 17/04/2016.
 */
@DatabaseTable(tableName = "posts")
public class Post {

    @Expose
    @DatabaseField(generatedId = true)
    private int id;

    @SerializedName("id")
    @DatabaseField(canBeNull = false)
    private int post_id;
    @DatabaseField(canBeNull = false)
    private String url_image_post;
    @DatabaseField(canBeNull = false)
    private String name;
    @DatabaseField(canBeNull = false)
    private int cost;
    @DatabaseField(canBeNull = true)
    private String description;
    @DatabaseField(canBeNull = false)
    private Boolean status;
    @DatabaseField(canBeNull = false)
    private Double weight;
    @DatabaseField(canBeNull = false)
    private int store_id;

    public Post(){}

    public Post(int post_id, String url_image_post, String name, int cost, String description, Boolean status, Double weight, int store_id) {
        this.post_id = post_id;
        this.url_image_post = url_image_post;
        this.name = name;
        this.cost = cost;
        this.description = description;
        this.status = status;
        this.weight = weight;
        this.store_id = store_id;
    }

//region Getters
    public int getId() {
        return id;
    }
    public int getPost_id() {
        return post_id;
    }
    public String getUrl_image_post() {
        return url_image_post;
    }
    public String getName() {
        return name;
    }
    public int getCost() {
        return cost;
    }
    public String getDescription() {
        return description;
    }
    public Boolean getStatus() {
        return status;
    }
    public Double getWeight() {
        return weight;
    }
    public int getStore_id() {
        return store_id;
    }
//endregion

//region Setters
    public void setPost_id(int post_id) {
        this.post_id = post_id;
    }
    public void setUrl_image_post(String url_image_post) {
        this.url_image_post = url_image_post;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setCost(int cost) {
        this.cost = cost;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setStatus(Boolean status) {
        this.status = status;
    }
    public void setWeight(Double weight) {
        this.weight = weight;
    }
    public void setStore_id(int store_id) {
        this.store_id = store_id;
    }
//endregion

//region Funcion para imprimir por consola
    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", post_id=" + post_id +
                ", url_image_post='" + url_image_post + '\'' +
                ", name='" + name + '\'' +
                ", cost=" + cost +
                ", description='" + description + '\'' +
                ", status=" + status +
                ", weight=" + weight +
                ", store_id=" + store_id +
                '}';
    }
//endregion

}
