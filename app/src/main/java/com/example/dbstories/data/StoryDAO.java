package com.example.dbstories.data;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * StoryDAO
 */

class StoryDAO {

    public void addStory(Story s) {
    }

    /**
     * Método que devuelve un cursor con todos los items de la tabla
     */
    public Cursor loadAll() {
        SQLiteDatabase sqLiteDatabase = StoriesOpenHelper.getInstance().openDatabase();
        Cursor selectAll =
        sqLiteDatabase.query(StoryContract.StoryEntry.TABLE_NAME,
                StoryContract.StoryEntry.ALL_COLUMNS, null, null,
                StoryContract.StoryEntry.COLUMN_DEFAULT_SORT, null, null, null);
        StoriesOpenHelper.getInstance().closeDatabase();
        return selectAll;
    }
}
