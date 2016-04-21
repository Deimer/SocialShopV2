package com.social.shop.socialshop.Helpers;

import android.content.Context;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.Toast;
import com.social.shop.socialshop.R;
import cn.pedant.SweetAlert.SweetAlertDialog;

/**
 * Creado por Deimer, fecha: 14/04/2016.
 */
public class SweetDialog {

    //Variable para alerta asincronica
    SweetAlertDialog sweetDialog;
    private Context contexto;

    public void dialogs(){}

    public SweetDialog(Context contexto){
        this.contexto = contexto;
        dialogs();
    }

    public void setContext(Context contexto){
        this.contexto = contexto;
    }

    //Funcion que lanza una alerta en un toast con un tiempo definido
    public void dialogToast(String message){
        Toast.makeText(contexto, message, Toast.LENGTH_LONG).show();
    }

    public void dialogBasic(String message){
        new SweetAlertDialog(contexto)
                .setTitleText(message)
                .show();
    }

    public void dialogSuccess(String title, String message){
        new SweetAlertDialog(contexto, SweetAlertDialog.SUCCESS_TYPE)
                .setTitleText(title)
                .setContentText(message)
                .show();
    }

    public void dialogWarning(String title, String message){
        new SweetAlertDialog(contexto, SweetAlertDialog.WARNING_TYPE)
                .setTitleText(title)
                .setContentText(message)
                .show();
    }

    public void dialogError(String title, String message){
        new SweetAlertDialog(contexto, SweetAlertDialog.ERROR_TYPE)
                .setTitleText(title)
                .setContentText(message)
                .show();
    }

    //Funcion que lanza una alerta asincronica para los procesos que requieren tiempo
    public void dialogProgress(String title){
        sweetDialog = new SweetAlertDialog(contexto, SweetAlertDialog.PROGRESS_TYPE);
        sweetDialog.getProgressHelper().setBarColor(R.color.colorPrimary);
        sweetDialog.setTitleText(title);
        sweetDialog.setCancelable(false);
        sweetDialog.show();
    }

    //Funcion que permite cancelar una alerta asincronica
    public void cancelarProgress(){
        sweetDialog.cancel();
    }

    //Funcion para mensajes de snackbar
    public void snackDialog(View view, String message){
        Snackbar.make(
                view, message, Snackbar.LENGTH_LONG
        ).show();
    }

}
