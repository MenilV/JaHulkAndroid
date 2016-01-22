package com.menil.jahulk.database;

import android.content.Context;

/**
 * Created by irvin on 1/22/16 project JaHulkAndroid.
 */
public class DatabaseManager {

    private DatabaseHelper databaseHelper;

    public DatabaseManager(Context context) {
        databaseHelper = new DatabaseHelper(context);
    }
}
