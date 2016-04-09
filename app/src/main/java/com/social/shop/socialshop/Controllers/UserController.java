package com.social.shop.socialshop.Controllers;

import android.content.Context;
import android.util.Log;
import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.social.shop.socialshop.Database.DatabaseHelper;
import com.social.shop.socialshop.Models.User;
import java.util.List;

/**
 * Creado por Deimer, fecha: 9/04/2016.
 * Controlador de la entidad user.
 * En esta clase se encuentran todos las
 * funciones encargadas consultar
 * la tabla users en la base de datos.
 */
public class UserController {

    private DatabaseHelper helper;
    private Context contexto;

    public void userController(){}

    public UserController(Context contexto){
        this.contexto = contexto;
        userController();
    }

    //Funcion que permite la creacion de un usuario nuevo
    public boolean create(User user){
        boolean res = true;
        try {
            helper = OpenHelperManager.getHelper(contexto, DatabaseHelper.class);
            RuntimeExceptionDao<User, Integer> userDao = helper.getUsuarioRuntimeDao();
            userDao.create(user);
        } catch (Exception ex) {
            res = false;
            Log.e("UserController(create)", "Error: " + ex.getMessage());
        }
        return res;
    }

    //Funcion que permite la edicion de un usuario
    public boolean update(User user){
        boolean res = true;
        try {
            helper = OpenHelperManager.getHelper(contexto,DatabaseHelper.class);
            RuntimeExceptionDao<User, Integer> usuarioDao = helper.getUsuarioRuntimeDao();
            usuarioDao.update(user);
        } catch (Exception ex) {
            res = false;
            Log.e("UserController(update)", "Error: " + ex.getMessage());
        }
        return res;
    }

    //Funcion que permite mostrar toda la informacion del usuario logueado
    public User show(Context context){
        User user;
        try {
            helper = OpenHelperManager.getHelper(context,DatabaseHelper.class);
            RuntimeExceptionDao<User, Integer> userDao = helper.getUsuarioRuntimeDao();
            user = userDao.queryForId(1);
        } catch (Exception ex) {
            user = null;
            Log.e("UserController(show)", "Error: " + ex.getMessage());
        }
        return user;
    }

    //Funcion que permite eliminar un Usuario de la base de datos
    public boolean delete(User user){
        boolean res = true;
        try {
            helper = OpenHelperManager.getHelper(contexto,DatabaseHelper.class);
            RuntimeExceptionDao<User, Integer> userDao = helper.getUsuarioRuntimeDao();
            userDao.delete(user);
        } catch (Exception ex) {
            res = false;
            Log.e("UserController(delete)", "Error: " + ex.getMessage());
        }
        return res;
    }

    //Funcion que permite saber si hay una sesion iniciada
    public boolean session(){
        boolean res = false;
        try {
            helper = OpenHelperManager.getHelper(contexto,DatabaseHelper.class);
            RuntimeExceptionDao<User, Integer> usuarioDao = helper.getUsuarioRuntimeDao();
            int cantidad = (int)usuarioDao.countOf();
            if(cantidad > 0){
                res = true;
            }
        } catch (Exception ex) {
            Log.e("UserController(session)", "Error: " + ex.getMessage());
        }
        return res;
    }

    //Funcion que permite reiniciar la base de datos al cerrar una sesion del usuario
    public boolean logout(int id){
        boolean res = true;
        try {
            helper = OpenHelperManager.getHelper(contexto,DatabaseHelper.class);
            RuntimeExceptionDao<User, Integer> usuarioDao = helper.getUsuarioRuntimeDao();
            usuarioDao.deleteById(id);
            helper.onResetDataBase();
        }catch (Exception ex){
            res = false;
            Log.e("UserController(logout)", "Error: " + ex.toString());
        }
        return res;
    }

    //Funcion que permite mostrar toda la informacion del usuario logueado
    public List<User> showAll(){
        List<User> users;
        try {
            helper = OpenHelperManager.getHelper(contexto,DatabaseHelper.class);
            RuntimeExceptionDao<User, Integer> userDao = helper.getUsuarioRuntimeDao();
            users = userDao.queryForAll();
        } catch (Exception ex) {
            users = null;
            Log.e("UserController(show)", "Error: " + ex.getMessage());
        }
        return users;
    }

}
