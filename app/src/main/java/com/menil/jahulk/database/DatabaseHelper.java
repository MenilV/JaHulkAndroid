package com.menil.jahulk.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import com.menil.jahulk.R;
import com.menil.jahulk.model.ExerciseModel;
import com.menil.jahulk.model.MuscleGroup;

import java.sql.SQLException;

/**
 * Created by irvin on 1/22/16 project JaHulkAndroid.
 */
public class DatabaseHelper extends OrmLiteSqliteOpenHelper {

    private static final String DATABASE_NAME = "jahulk.db";
    private static final int DATABASE_VERSION = 1;

    // Define DAO objects here
    private Dao<ExerciseModel, String> exerciseModelDao = null;
    private Dao<MuscleGroup, String> muscleGroupDao = null;


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION, R.raw.ormlite_config);
    }


    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {
        try {
            TableUtils.createTable(connectionSource, ExerciseModel.class);
            TableUtils.createTable(connectionSource, MuscleGroup.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) {
        try {
            TableUtils.dropTable(connectionSource, ExerciseModel.class, true);
            TableUtils.dropTable(connectionSource, MuscleGroup.class, true);
            onCreate(database, connectionSource);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public Dao<ExerciseModel, String> getExerciseModelDao() throws SQLException {
        if (exerciseModelDao == null) {
            exerciseModelDao = getDao(ExerciseModel.class);
        }
        return exerciseModelDao;
    }

    public Dao<MuscleGroup, String> getMuscleGroupDao() throws  SQLException {
        if (muscleGroupDao == null) {
            muscleGroupDao = getDao(MuscleGroup.class);
        }
        return muscleGroupDao;
    }

}
