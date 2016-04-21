package com.social.shop.socialshop.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Creado por Deimer, fecha: 17/04/2016.
 */
@DatabaseTable(tableName = "users")
public class User {

    @Expose
    @DatabaseField(generatedId = true)
    private int id;

    @SerializedName("id")
    @DatabaseField(canBeNull = false)
    private int user_id;
    @DatabaseField(canBeNull = false)
    private String first_name;
    @DatabaseField(canBeNull = false)
    private String last_name;
    @DatabaseField(canBeNull = true)
    private String avatar;
    @DatabaseField(canBeNull = false)
    private String email;
    @DatabaseField(canBeNull = false)
    private String password;

    public User(){}

    public User(int user_id, String first_name, String last_name,
                String avatar, String email, String password) {
        this.user_id = user_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.avatar = avatar;
        this.email = email;
        this.password = password;
    }

//region Getters del modelo
    public int getId() {
        return id;
    }
    public int getUser_id() {
        return user_id;
    }
    public String getFirst_name() {
        return first_name;
    }
    public String getLast_name() {
        return last_name;
    }
    public String getAvatar() {
        return avatar;
    }
    public String getEmail() {
        return email;
    }
    public String getPassword() {
        return password;
    }
//endregion

//region Setters del modelo
    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }
    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }
    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setPassword(String password) {
        this.password = password;
    }
//endregion

//region Metodo de impresion en consola
    @Override
    public String toString() {
        return "User{" +
            "id=" + id +
            ", user_id=" + user_id +
            ", first_name='" + first_name + '\'' +
            ", last_name='" + last_name + '\'' +
            ", avatar='" + avatar + '\'' +
            ", email='" + email + '\'' +
            ", password='" + password + '\'' +
        '}';
    }
//endregion

}
