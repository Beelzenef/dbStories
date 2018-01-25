package com.example.dbstories.data;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.dbstories.data.prefs.StoryApplication;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Sqlite Helper
 */

public class StoriesOpenHelper extends SQLiteOpenHelper {

    private static volatile StoriesOpenHelper singleton;
    private SQLiteDatabase sqLiteDatabase;

    private AtomicInteger openCounter = new AtomicInteger();

    static {
        singleton = new StoriesOpenHelper();
    }

    public synchronized static StoriesOpenHelper getInstance() {
        if (singleton == null) {
            singleton = new StoriesOpenHelper();
        }
        return singleton;
    }

    private StoriesOpenHelper() {
        super(StoryApplication.getContext(), StoryContract.DB_NAME, null, StoryContract.DB_VERSION);
    }

    // Abriendo base de datos
    // Creando tabla

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        try {
            sqLiteDatabase.beginTransaction();
            sqLiteDatabase.execSQL(StoryContract.StoryEntry.SQL_CREATE_ENTRIES);
            sqLiteDatabase.execSQL(StoryContract.StoryEntry.SQL_INSERT_ENTRIES);
            sqLiteDatabase.setTransactionSuccessful();
        } catch (SQLiteException e) {
            Log.e("OPENHELPER", e.getMessage());
        } finally {
            sqLiteDatabase.endTransaction();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        try {
            sqLiteDatabase.beginTransaction();
            sqLiteDatabase.execSQL(StoryContract.StoryEntry.SQL_UPDATE_ENTRIES);
            onCreate(sqLiteDatabase);
            sqLiteDatabase.setTransactionSuccessful();
        } catch (SQLiteException e) {
            Log.e("OPENHELPER", e.getMessage());
        } finally {
            sqLiteDatabase.endTransaction();
        }
    }

    public synchronized SQLiteDatabase openDatabase() {
        if (openCounter.incrementAndGet() == 1)
            sqLiteDatabase = getWritableDatabase();
        return sqLiteDatabase;
    }

    public synchronized void closeDatabase() {
        if (openCounter.decrementAndGet() == 0) {
            sqLiteDatabase.close();
        }
    }
}
