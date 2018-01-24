package com.example.dbstories.data;

import android.content.ContentValues;
import android.database.ContentObservable;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

/**
 * StoryDAO
 */

class StoryDAO {

    /**
     * Método que devuelve un cursor con todos los items de la tabla
     */
    public ArrayList<Story> loadAll() {
        SQLiteDatabase sqLiteDatabase = StoriesOpenHelper.getInstance().openDatabase();

        ArrayList<Story> resultado = new ArrayList<>();

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

        return resultado;
    }

    // Añade un item a la BD
    public long save(Story s) {

        SQLiteDatabase sqLiteDatabase = StoriesOpenHelper.getInstance().openDatabase();

        ContentValues cV = new ContentValues();
        cV.put(StoryContract.StoryEntry.COLUMN_ID, s.getId());
        cV.put(StoryContract.StoryEntry.COLUMN_TITLE, s.getTitle());
        cV.put(StoryContract.StoryEntry.COLUMN_AUTHOR, s.getAuthor());

        long idInsercion = sqLiteDatabase.insert(StoryContract.StoryEntry.TABLE_NAME, null, cV);

        sqLiteDatabase.close();
        return idInsercion;
    }

    // Elimina un item en la BD
    public void delete(Story s) {

        SQLiteDatabase sqLiteDatabase = StoriesOpenHelper.getInstance().openDatabase();
        sqLiteDatabase.delete(StoryContract.StoryEntry.TABLE_NAME,
                StoryContract.StoryEntry.COLUMN_TITLE + "=" + s.getTitle(), null);

        sqLiteDatabase.close();

    }

    public boolean contains(Story s) {
        return false;
    }
}
