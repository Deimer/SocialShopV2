package com.social.shop.socialshop.Models;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by jcml3 on 6/04/2016.
 */
@DatabaseTable(tableName = "social_providers")
public class SocialProvider {

    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField(canBeNull = false)
    private int social_id;
    @DatabaseField(canBeNull = false)
    private String provider_id;
    @DatabaseField(canBeNull = false)
    private String email;
    @DatabaseField(canBeNull = false)
    private String provider;
    @DatabaseField(canBeNull = false)
    private String token;
    @DatabaseField(canBeNull = false)
    private boolean is_primary_provider;

    public SocialProvider() {}

    public SocialProvider(int social_id, String provider_id, String email,
                          String provider, String token, boolean is_primary_provider) {
        this.social_id = social_id;
        this.provider_id = provider_id;
        this.email = email;
        this.provider = provider;
        this.token = token;
        this.is_primary_provider = is_primary_provider;
    }

//region Getters del modelo
    public int getId() {
        return id;
    }
    public int getSocial_id() {
        return social_id;
    }
    public String getProvider_id() {
        return provider_id;
    }
    public String getEmail() {
        return email;
    }
    public String getProvider() {
        return provider;
    }
    public String getToken() {
        return token;
    }
    public boolean is_primary_provider() {
        return is_primary_provider;
    }
//endregion

//region Setters del modelo
    public void setSocial_id(int social_id) {
        this.social_id = social_id;
    }
    public void setProvider_id(String provider_id) {
        this.provider_id = provider_id;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setProvider(String provider) {
        this.provider = provider;
    }
    public void setToken(String token) {
        this.token = token;
    }
    public void setIs_primary_provider(boolean is_primary_provider) {
        this.is_primary_provider = is_primary_provider;
    }
//endregion

//region Metodo de impresion de consola
    @Override
    public String toString() {
        return "SocialProvider{" +
            "id=" + id +
            ", social_id=" + social_id +
            ", provider_id='" + provider_id + '\'' +
            ", email='" + email + '\'' +
            ", provider='" + provider + '\'' +
            ", token='" + token + '\'' +
            ", is_primary_provider=" + is_primary_provider +
        '}';
    }
//endregion

}
