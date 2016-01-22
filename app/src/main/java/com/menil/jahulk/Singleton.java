package com.menil.jahulk;

import android.app.Application;

import com.menil.jahulk.database.DatabaseManager;

/**
 * Created by Menil V. on 22.1.2016 at com.menil.jahulk.
 */
public class Singleton extends Application {

    private static DatabaseManager databaseManager;

    @Override
    public void onCreate() {
        super.onCreate();
        databaseManager = new DatabaseManager(this);
    }

    public static DatabaseManager getDbManager() {
        return databaseManager;
    }
}
