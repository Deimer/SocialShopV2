package com.social.shop.socialshop.Models;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Creado por Juan Carlos on 6/04/2016.
 * creacion de la clase store para
 * la gestion del modelo
 * y consultas en la base de datos
 */
@DatabaseTable(tableName = "stores")
public class Store {

    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField(canBeNull = false)
    private int store_id;
    @DatabaseField(canBeNull = false)
    private String name;
    @DatabaseField(canBeNull = true)
    private String description;
    @DatabaseField(canBeNull = true)
    private String avatar;
    @DatabaseField(canBeNull = true)
    private boolean is_person;
    @DatabaseField(canBeNull = true)
    private int number_employees;
    @DatabaseField(canBeNull = true)
    private String product_manufacturing;
    @DatabaseField(canBeNull = true)
    private int verified;

    public Store(){}

    public Store(int store_id, String name, String description, String avatar,
                 boolean is_person, int number_employees, String product_manufacturing, int verified) {
        this.store_id = store_id;
        this.name = name;
        this.description = description;
        this.avatar = avatar;
        this.is_person = is_person;
        this.number_employees = number_employees;
        this.product_manufacturing = product_manufacturing;
        this.verified = verified;
    }

//region Getters del modelo
    public int getId() {
        return id;
    }
    public int getStore_id() {
        return store_id;
    }
    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
    public String getAvatar_store() {
        return avatar;
    }
    public boolean is_person() {
        return is_person;
    }
    public int getNumber_employees() {
        return number_employees;
    }
    public String getProduct_manufacturing() {
        return product_manufacturing;
    }
    public int getVerified() {
        return verified;
    }
//endregion

//region Setters del modelo
    public void setStore_id(int store_id) {
        this.store_id = store_id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
    public void setIs_person(boolean is_person) {
        this.is_person = is_person;
    }
    public void setNumber_employees(int number_employees) {
        this.number_employees = number_employees;
    }
    public void setProduct_manufacturing(String product_manufacturing) {
        this.product_manufacturing = product_manufacturing;
    }
    public void setVerified(int verified) {
        this.verified = verified;
    }
//endregion

//region Metodo de impresion en la consola
    @Override
    public String toString() {
        return "Store{" +
                "id=" + id +
                ", store_id=" + store_id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", avatar='" + avatar + '\'' +
                ", is_person=" + is_person +
                ", number_employees=" + number_employees +
                ", product_manufacturing='" + product_manufacturing + '\'' +
                ", verified=" + verified +
                '}';
    }
//endregion

}
