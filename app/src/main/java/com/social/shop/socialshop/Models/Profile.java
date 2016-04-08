package com.social.shop.socialshop.Models;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by jcml3 on 6/04/2016.
 */
@DatabaseTable(tableName = "profiles")
public class Profile {

    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField(canBeNull = false)
    private int profile_id;
    @DatabaseField(canBeNull = false)
    private String profile_type;
    @DatabaseField(canBeNull = false)
    private int user_id;

    public Profile() {}

    public Profile(int profile_id, String profile_type, int user_id) {
        this.profile_id = profile_id;
        this.profile_type = profile_type;
        this.user_id = user_id;
    }

//region Getters del modelo
    public int getId() {
        return id;
    }
    public int getProfile_id() {
        return profile_id;
    }
    public String getProfile_type() {
        return profile_type;
    }
    public int getUser_id() {
        return user_id;
    }
//endregion

//region Setters del modelo
    public void setProfile_id(int profile_id) {
        this.profile_id = profile_id;
    }
    public void setProfile_type(String profile_type) {
        this.profile_type = profile_type;
    }
    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
//endregion

//region Funcion para imprimir el modelo en consola
    @Override
    public String toString() {
        return "Profile{" +
                "id=" + id +
                ", profile_id=" + profile_id +
                ", profile_type='" + profile_type + '\'' +
                ", user_id=" + user_id +
                '}';
    }
//endregion

}
