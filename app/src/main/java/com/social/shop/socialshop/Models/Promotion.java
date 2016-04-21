package com.social.shop.socialshop.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Creado por Deimer, fecha: 17/04/2016.
 */
@DatabaseTable(tableName = "promotions")
public class Promotion {

    @Expose
    @DatabaseField(generatedId = true)
    private int id;

    @SerializedName("id")
    @DatabaseField(canBeNull = false)
    private int promotion_id;
    @DatabaseField(canBeNull = false)
    private String name;
    @DatabaseField(canBeNull = false)
    private String inicial_date;
    @DatabaseField(canBeNull = false)
    private String end_date;
    @DatabaseField(canBeNull = false)
    private Boolean status;

    public Promotion(){}

    public Promotion(int promotion_id, String name, String inicial_date, String end_date, Boolean status) {
        this.promotion_id = promotion_id;
        this.name = name;
        this.inicial_date = inicial_date;
        this.end_date = end_date;
        this.status = status;
    }

//region Getters
    public int getId() {
        return id;
    }
    public int getPromotion_id() {
        return promotion_id;
    }
    public String getName() {
        return name;
    }
    public String getInicial_date() {
        return inicial_date;
    }
    public String getEnd_date() {
        return end_date;
    }
    public Boolean getStatus() {
        return status;
    }
//endregion

//region Setters
    public void setPromotion_id(int promotion_id) {
        this.promotion_id = promotion_id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setInicial_date(String inicial_date) {
        this.inicial_date = inicial_date;
    }
    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }
    public void setStatus(Boolean status) {
        this.status = status;
    }
//endregion


    @Override
    public String toString() {
        return "Promotion{" +
            "id=" + id +
            ", promotion_id=" + promotion_id +
            ", name='" + name + '\'' +
            ", inicial_date='" + inicial_date + '\'' +
            ", end_date='" + end_date + '\'' +
            ", status=" + status +
        '}';
    }
}
