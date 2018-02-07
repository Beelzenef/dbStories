package com.example.dbstories.data.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.example.dbstories.data.StoriesOpenHelper;
import com.example.dbstories.data.StoryContract;

/**
 * ItemProvider, hereda de ContentProvider
 */

public final class StoryProvider extends ContentProvider {

    // Creamos una constante por cada petición o Uri que pueda recoger el ContentProvider

    public static final int STORY = 1;
    public static final int STORY_ID = 2;
    public static final int ITEM = 3;
    public static final int ITEM_ID = 4;

    private static final UriMatcher uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
    static {
        uriMatcher.addURI(ProviderContract.AUTHORITY, ProviderContract.Story.CONTENT_PATH, STORY);
        uriMatcher.addURI(ProviderContract.AUTHORITY, ProviderContract.Story.CONTENT_PATH + "/#", STORY_ID);
        uriMatcher.addURI(ProviderContract.AUTHORITY, ProviderContract.Item.CONTENT_PATH, ITEM);
        uriMatcher.addURI(ProviderContract.AUTHORITY, ProviderContract.Item.CONTENT_PATH + "/#", ITEM_ID);
    }

    private SQLiteDatabase sqLiteDatabase;

    @Override
    public boolean onCreate() {
        sqLiteDatabase = StoriesOpenHelper.getInstance().openDatabase();
        return true;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projections, @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder) {

        Cursor cursor = null;

        switch (uriMatcher.match(uri)) {
            case STORY:
                cursor = sqLiteDatabase.query(StoryContract.StoryEntry.TABLE_NAME, projections, selection, selectionArgs, null, null, sortOrder);
                break;
            case STORY_ID:
                break;
            case ITEM:
                break;
            case ITEM_ID:
                break;
            case UriMatcher.NO_MATCH:
                throw new IllegalArgumentException("Invalid URI " + uri.toString());
        }

        return cursor;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues contentValues) {
        return null;
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String s, @Nullable String[] strings) {
        return 0;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable String s, @Nullable String[] strings) {
        return 0;
    }
}
