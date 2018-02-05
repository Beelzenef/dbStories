package com.example.dbstories.data.provider;

import android.net.Uri;
import android.provider.BaseColumns;

import java.util.HashMap;

/**
 * ItemProviderContract
 */

public final class ProviderContract {

    public static final String AUTHORITY = "com.example.dbstories";
    public static final Uri CONTENT_URI = Uri.parse("content://" + AUTHORITY);

    private ProviderContract () { }

    public static class Story implements BaseColumns {

        public static final String CONTENT_PATH = "item";
        public static final Uri ITEM_URI = Uri.withAppendedPath(ProviderContract.CONTENT_URI, CONTENT_PATH);

        public static final String COLUMN_TITLE = "title";
        public static final String COLUMN_AUTHOR = "author";

        public static final String[] Projection = new String[] { BaseColumns._ID, COLUMN_TITLE, COLUMN_AUTHOR };

        public static HashMap<String, String> projectionMap;

        static {
            projectionMap = new HashMap<>();
            projectionMap.put(COLUMN_TITLE, COLUMN_TITLE);
            projectionMap.put(COLUMN_AUTHOR, COLUMN_AUTHOR);
        }
    }

    public static class Item implements BaseColumns {

        public static final String CONTENT_PATH = "item";
        public static final Uri ITEM_URI = Uri.withAppendedPath(ProviderContract.CONTENT_URI, CONTENT_PATH);

        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_STORYID = "storyid";

        public static final String[] Projection = new String[] { BaseColumns._ID, COLUMN_NAME, COLUMN_STORYID };

        public static HashMap<String, String> projectionMap;

        static {
            projectionMap = new HashMap<>();
            projectionMap.put(COLUMN_NAME, COLUMN_NAME);
            projectionMap.put(COLUMN_STORYID, COLUMN_STORYID);
        }
    }

}
