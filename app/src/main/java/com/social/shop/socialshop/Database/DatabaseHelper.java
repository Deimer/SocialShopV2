package com.social.shop.socialshop.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import com.social.shop.socialshop.Models.Profile;
import com.social.shop.socialshop.Models.SocialProvider;
import com.social.shop.socialshop.Models.Store;
import com.social.shop.socialshop.Models.User;
import com.social.shop.socialshop.R;
import java.sql.SQLException;

/**
 * Creado por Deimer, fecha: 6/04/2016.
 */
public class DatabaseHelper extends OrmLiteSqliteOpenHelper {

    private static final String DATABASE_NAME = "social_shop.db";
    private static final int DATABASE_VERSION = 1;

    public DatabaseHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION, R.raw.ormlite_config);
    }

    private Dao<User, Integer> userDao = null;
    private RuntimeExceptionDao<User, Integer> userRuntimeDao = null;
    private Dao<Profile, Integer> profileDao = null;
    private RuntimeExceptionDao<Profile, Integer> profileRuntimeDao = null;
    private Dao<SocialProvider, Integer> socialDao = null;
    private RuntimeExceptionDao<SocialProvider, Integer> socialRuntimeDao = null;
    private Dao<Store, Integer> storeDao = null;
    private RuntimeExceptionDao<Store, Integer> storeRuntimeDao = null;

    /*Funcion que permite crear la base de datos cuando inicia la aplicacion
    * Usa como parametros;
    * @param sqLiteDatabase -> extension de la base de datos para sqlite
    * @param source -> variable para la conexion a los recursos de sqlite
    */
    @Override
    public void onCreate(SQLiteDatabase db, ConnectionSource source) {
        try {
            TableUtils.createTable(source, User.class);
            TableUtils.createTable(source, Profile.class);
            TableUtils.createTable(source, SocialProvider.class);
            TableUtils.createTable(source, Store.class);
        } catch (SQLException sqlEx) {
            Log.e("DatabaseHelper(onCreate)", "Error: " + sqlEx.getMessage());
            throw new RuntimeException(sqlEx);
        }
    }

    /*Funcion que permite actualizar la base de datos cuando sea necesario
    * Usa como parametros;
    * @param db -> extension de la base de datos
    * @param source -> variable para la conexion a la base de datos
    * @param oldVersion -> numero de version actual de la base de datos
    * @param newVersion -> numero de la nueva version de la base de datos
    */
    @Override
    public void onUpgrade(SQLiteDatabase db, ConnectionSource source, int oldVersion, int newVersion) {
        try {
            TableUtils.dropTable(source, User.class, true);
            TableUtils.dropTable(source, Profile.class, true);
            TableUtils.dropTable(source, SocialProvider.class, true);
            TableUtils.dropTable(source, Store.class, true);
            onCreate(db, source);
        } catch (SQLException sqlEx) {
            Log.e("DatabaseHelper(onUpgrade)", "Error: " + sqlEx.getMessage());
            Log.e(DatabaseHelper.class.getSimpleName(), "Imposible eliminar la base de datos", sqlEx);
        }
    }

    /*Funcion que permite resetear la base de datos cuando se cierra la sesión del usuario
    * Todos los datos de la aplicación son borrados para evitar información basura.
    * No recibe ningun parametro para funcionar.
    */
    public void onResetDataBase(){
        try {
            //Se eliminan las tablas existentes
            ConnectionSource source = this.getConnectionSource();
            TableUtils.dropTable(source, User.class, true);
            TableUtils.dropTable(source, Profile.class, true);
            TableUtils.dropTable(source, SocialProvider.class, true);
            TableUtils.dropTable(source, Store.class, true);
            //Recreacion de las tablas
            TableUtils.createTable(source, User.class);
            TableUtils.createTable(source, Profile.class);
            TableUtils.createTable(source, SocialProvider.class);
            TableUtils.createTable(source, Store.class);
        }catch (SQLException sqlEx){
            Log.i("DatabaseHelper(onResetDataBase)", "Error: " + sqlEx.getMessage());
            throw new RuntimeException(sqlEx);
        }
    }

    public void close(){
        super.close();
        userDao = null;
        userRuntimeDao = null;
        profileDao = null;
        profileRuntimeDao = null;
        socialDao = null;
        socialRuntimeDao = null;
        storeDao = null;
        storeRuntimeDao = null;
    }

    public Dao<User, Integer> getUserDao() throws SQLException {
        if(userDao == null) userDao = getDao(User.class);
        return userDao;
    }
    public RuntimeExceptionDao<User, Integer> getUsuarioRuntimeDao() {
        if(userRuntimeDao == null) userRuntimeDao = getRuntimeExceptionDao(User.class);
        return userRuntimeDao;
    }

    public Dao<SocialProvider, Integer> getSocialDao() throws SQLException {
        if(socialDao == null) socialDao = getDao(SocialProvider.class);
        return socialDao;
    }
    public RuntimeExceptionDao<SocialProvider, Integer> getSocialRuntimeDao() {
        if(socialRuntimeDao == null) socialRuntimeDao = getRuntimeExceptionDao(SocialProvider.class);
        return socialRuntimeDao;
    }

    public Dao<Store, Integer> getStoreDao() throws SQLException {
        if(storeDao == null) storeDao = getDao(Store.class);
        return storeDao;
    }
    public RuntimeExceptionDao<Store, Integer> getStoreRuntimeDao() {
        if(storeRuntimeDao == null) storeRuntimeDao = getRuntimeExceptionDao(Store.class);
        return storeRuntimeDao;
    }

    public Dao<Profile, Integer> getProfileDao() throws SQLException {
        if(profileDao == null) profileDao = getDao(Profile.class);
        return profileDao;
    }
    public RuntimeExceptionDao<Profile, Integer> getCountryRuntimeDao() {
        if(profileRuntimeDao == null) profileRuntimeDao = getRuntimeExceptionDao(Profile.class);
        return profileRuntimeDao;
    }

}
