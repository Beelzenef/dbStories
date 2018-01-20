package com.example.dbstories.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Sqlite Helper
 */

public class storiesAccess extends SQLiteOpenHelper {

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public storiesAccess(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, StoryContract.DB_NAME, null, StoryContract.DB_VERSION);
    }
}
