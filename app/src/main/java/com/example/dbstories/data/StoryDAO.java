package com.example.dbstories.data;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;
import android.util.Log;

import com.example.dbstories.data.pojo.Story;

import java.util.ArrayList;

/**
 * StoryDAO
 */

class StoryDAO implements com.example.dbstories.base.StoryDAO {

    /**
     * Método que devuelve un cursor con todos los items de la tabla
     */
    @Override
    public ArrayList<Story> loadAll() {
        final SQLiteDatabase sqLiteDatabase = StoriesOpenHelper.getInstance().openDatabase();

        final ArrayList<Story> resultado = new ArrayList<>();

        Thread hilo = new Thread(new Runnable() {
            @Override
            public void run() {
                Cursor c = sqLiteDatabase.query(StoryContract.StoryEntry.TABLE_NAME,
                        StoryContract.StoryEntry.ALL_COLUMNS, null, null,
                        StoryContract.StoryEntry.COLUMN_DEFAULT_SORT, null, null, null);

                // Convertir elementos de cursor a Story
                if (c.moveToFirst()) {
                    while (c.moveToNext()) {
                        Story tmp = new Story(c.getInt(0), c.getString(1), c.getString(2));
                        resultado.add(tmp);
                    }
                }

                StoriesOpenHelper.getInstance().closeDatabase();
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    Log.e("DAO", e.getMessage());
                }
            }
        });


        return resultado;
    }

    // Añade un item a la BD
    @Override
    public long add(Story s) {

        SQLiteDatabase sqLiteDatabase = StoriesOpenHelper.getInstance().openDatabase();

        long idInsercion = sqLiteDatabase.insert(StoryContract.StoryEntry.TABLE_NAME,
                null, generateContentValues(s));

        sqLiteDatabase.close();
        return idInsercion;
    }

    // Elimina un item en la BD
    @Override
    public long delete(Story s) {

        SQLiteDatabase sqLiteDatabase = StoriesOpenHelper.getInstance().openDatabase();
        long id = sqLiteDatabase.delete(StoryContract.StoryEntry.TABLE_NAME,
                StoryContract.StoryEntry.COLUMN_TITLE + "=" + s.getTitle(), null);

        sqLiteDatabase.close();
        return id;
    }

    @Override
    public long update(Story s) {
        SQLiteDatabase sqLiteDatabase = StoriesOpenHelper.getInstance().openDatabase();

        String whereClause = BaseColumns._ID+"=?";
        String[] whereArgs = new String[] {String.valueOf(s.getTitle())};

        long id = sqLiteDatabase.update(StoryContract.StoryEntry.TABLE_NAME, generateContentValues(s),
                whereClause, whereArgs);

        sqLiteDatabase.close();
        return id;
    }

    public boolean contains(Story s) {
        return false;
    }

    @Override
    public ContentValues generateContentValues(Story s) {
        ContentValues cV = new ContentValues();
        cV.put(StoryContract.StoryEntry.COLUMN_ID, s.getId());
        cV.put(StoryContract.StoryEntry.COLUMN_TITLE, s.getTitle());
        cV.put(StoryContract.StoryEntry.COLUMN_AUTHOR, s.getAuthor());

        return cV;
    }
}
