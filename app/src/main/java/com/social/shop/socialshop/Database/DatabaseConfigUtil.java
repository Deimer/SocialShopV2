package com.social.shop.socialshop.Database;

import com.j256.ormlite.android.apptools.OrmLiteConfigUtil;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Creado por Deimer, fecha: 8/04/2016.
 */
public class DatabaseConfigUtil extends OrmLiteConfigUtil {

    public static void main(String[] args)throws IOException, SQLException {
        writeConfigFile("ormlite_config.txt");
    }

}
