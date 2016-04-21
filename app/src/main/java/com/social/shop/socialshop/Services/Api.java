package com.social.shop.socialshop.Services;

import com.google.gson.JsonObject;
import retrofit.Callback;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.POST;

/**
 * Creado por Deimer, fecha: 6/04/2016.
 */
public interface Api {

//region Gestion de la sesion de usuarios
    @FormUrlEncoded
    @POST("/m/login")
    void login(
            @Field("email") String email,
            @Field("password")String password,
            Callback<JsonObject> cb
    );
//endregion

}
