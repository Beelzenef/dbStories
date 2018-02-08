package com.example.dbstories.data.provider.dao;

import android.app.Application;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;

import com.example.dbstories.base.StoryDAO;
import com.example.dbstories.data.StoryContract;
import com.example.dbstories.data.pojo.Story;
import com.example.dbstories.data.provider.ProviderContract;

import java.util.ArrayList;

public class storyDaoImpl implements StoryDAO {
    @Override
    public ArrayList<Story> loadAll() {

        ArrayList<Story> lista = new ArrayList<>();

        // 1. Array projection
        String[] projection = new String[] {
                ProviderContract.Story._ID,
                ProviderContract.Story.COLUMN_AUTHOR,
                ProviderContract.Story.COLUMN_TITLE
        };

        // 2. Consulta con la URI propia del Item
        // ContentProvider already registrado en el sistema
        ContentResolver contentResolver = Application.getContext().getContentResolver();
        Cursor cursor = contentResolver.query(ProviderContract.Story.ITEM_URI, projection, null, null, null);

        if (cursor.moveToFirst()) {
            do {
                lista.add(new Story(cursor.getInt(0), cursor.getString(1), cursor.getString(2)));
            } while (cursor.moveToNext());
        }

        return lista;
    }

    @Override
    public long add(Story s) {
        ContentResolver contentResolver = Application.getContext().getContentResolver();
        Uri uriResultante = contentResolver.insert(ProviderContract.Story.ITEM_URI, createContent(s));
        if (uriResultante == null) {
            return -1;
        }
        return Long.parseLong(uriResultante.getLastPathSegment());
    }

    @Override
    public long update(Story s) {
        ContentResolver contentResolver = Application.getContext().getContentResolver();
        long id = contentResolver.update(ProviderContract.Story.ITEM_URI, generateContentValues(s),
                ProviderContract.Story.COLUMN_TITLE + "=" + s.getTitle(), null);

        return id;
    }

    @Override
    public long delete(Story s) {
        ContentResolver contentResolver = Application.getContext().getContentResolver();

        long id = contentResolver.delete(ProviderContract.Story.ITEM_URI,
                ProviderContract.Story.COLUMN_TITLE + "=" + s.getTitle(),null);
        return id;
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
