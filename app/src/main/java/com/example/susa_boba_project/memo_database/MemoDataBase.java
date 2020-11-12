package com.example.susa_boba_project.memo_database;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;

@Database(entities = { MyData.class }, version = 1)
public abstract class MemoDataBase extends RoomDatabase {

    private static final String DB_NAME = "MemoDatabase.db";
    private static volatile MemoDataBase instance;

    public static synchronized MemoDataBase getInstance(Context context) {
        if (instance == null) {
            instance = create(context);
        }
        return instance;
    }

    private static MemoDataBase create(final Context context) {
        return Room.databaseBuilder(
                context,
                MemoDataBase.class,
                DB_NAME).build();
    }
    public abstract DataDao getDataDao();

    @NonNull
    @Override
    protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration config) {
        return null;
    }

    @NonNull
    @Override
    protected InvalidationTracker createInvalidationTracker() {
        return null;
    }

    @Override
    public void clearAllTables() {

    }
}
