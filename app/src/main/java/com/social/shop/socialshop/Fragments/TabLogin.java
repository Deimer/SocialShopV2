package com.social.shop.socialshop.Fragments;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.social.shop.socialshop.Controllers.UserController;
import com.social.shop.socialshop.Helpers.Datas;
import com.social.shop.socialshop.Helpers.SweetDialog;
import com.social.shop.socialshop.Helpers.Validate;
import com.social.shop.socialshop.Models.User;
import com.social.shop.socialshop.R;
import com.social.shop.socialshop.Services.Api;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Creado por Deimer, fecha: 11/04/2016.
 */
public class TabLogin extends Fragment {

//region Variables de adecuacion
    private Context context;
    private UserController userController;
    private SweetDialog dialog;
    private Validate validate;
    private Datas datas;
//endregion

//region Elementos de la vista
    @Bind(R.id.txt_email)EditText txt_email;
    @Bind(R.id.txt_password)EditText txt_password;
//endregion

    public static TabLogin newInstance(){
        return new TabLogin();
    }

    public TabLogin(){}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        ButterKnife.bind(this, view);
        setupContext();
        return view;
    }

    public void setupContext(){
        context = getActivity().getApplicationContext();
        userController = new UserController(context);
        dialog = new SweetDialog(getActivity());
        validate = new Validate(context);
        datas = new Datas();
    }

    @OnClick(R.id.but_log_in)
    public void onClickLogin(){
        String email = txt_email.getText().toString();
        String password = txt_password.getText().toString();
        if(email.equalsIgnoreCase("") && password.equalsIgnoreCase("")){
            dialog.dialogError("Error", "First you must fill in all fields");
        } else {
            if (validate.isEmailValid(email)) {
                if (validate.isPasswordValid(password)) {
                    boolean hayConexion = validate.connect();
                    if (hayConexion) {
                        login(email, password);
                    } else {
                        dialog.dialogWarning(getString(R.string.alerta_conexion_1), getString(R.string.alerta_conexion_2));
                    }
                } else {
                    dialog.dialogError("Error", "The password must be more than 6 characters");
                }
            } else {
                dialog.dialogError("Error", "The email entered is invalid or misspelled");
            }
        }
    }

    public void login(final String email, final String password){
        dialog.dialogProgress(getString(R.string.sign_in));
        final String url = getString(R.string.url_con);
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .setEndpoint(url)
                .build();
        Api api = restAdapter.create(Api.class);
        api.login(email, password, new Callback<JsonObject>() {
            @Override
            public void success(JsonObject jsonObject, Response response) {
                boolean success = jsonObject.get("success").getAsBoolean();
                if (success) {
                    User user = new Gson().fromJson(jsonObject.get("data"), User.class);
                    System.out.println(user.toString());
                    dialog.cancelarProgress();
                } else {
                    String message = jsonObject.get("message").getAsString();
                    dialog.cancelarProgress();
                    dialog.dialogWarning("Error", message);
                }
            }
            @Override
            public void failure(RetrofitError error) {
                dialog.cancelarProgress();
                try {
                    dialog.dialogError("Error", error.getBody().toString());
                    Log.e("TabLogin(login)", "Error: " + error.getBody().toString());
                } catch (Exception ex) {
                    Log.e("TabLogin(login)", "Error ret: " + error + "; Error ex: " + ex.getMessage());
                }
            }
        });
    }

}
