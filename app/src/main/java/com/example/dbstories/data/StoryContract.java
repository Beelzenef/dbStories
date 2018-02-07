package com.example.dbstories.data;

import android.provider.BaseColumns;

/**
 * Story Contract
 */

public class StoryContract {

    private StoryContract() {
    }

    public static final int DB_VERSION = 1;
    public static final String DB_NAME = "narrando.db";

    public static class StoryEntry implements BaseColumns {

        public static final String TABLE_NAME = "historias";
        public static final String COLUMN_ID = "id";
        public static final String COLUMN_TITLE = "titulo";
        public static final String COLUMN_AUTHOR = "autor";
        public static final String[] ALL_COLUMNS = new String[]{
                BaseColumns._ID, COLUMN_TITLE, COLUMN_AUTHOR
        };

        public static final String COLUMN_DEFAULT_SORT = COLUMN_TITLE;

        public static final String SQL_CREATE_ENTRIES = String.format("CREATE TABLE %s (%s INTEGER PRIMARY KEY AUTOINCREMENT,%s TEXT NOT NULL,%s TEXT NOT NULL,%s TEXT NOT NULL,%s TEXT NOT NULL)",
                TABLE_NAME,
                BaseColumns._ID,
                COLUMN_TITLE,
                COLUMN_AUTHOR
        );

        public static final String SQL_DELETE_ENTRIES = String.format("DROP TABLE IF EXISTS %s", TABLE_NAME);

        public static final String SQL_UPDATE_ENTRIES = "";

        public static final String SQL_INSERT_ENTRIES = String.format("INSERT INTO %s (%s,%s) VALUES ('%s','%s'),('%s','%s')",
                TABLE_NAME,
                COLUMN_TITLE,
                COLUMN_AUTHOR,

                "Eragon",
                "C. Paolini",

                "La soledad de Charles Dickens",
                "D. Simmons");
    }

    public static class ItemEntry implements BaseColumns {

        public static final String TABLE_NAME = "item";
        public static final String COLUMN_NOMBRE = "nombre";
        public static final String COLUMN_STORYID = "idstory";
        public static final String[] ALL_COLUMNS = new String[]{
                BaseColumns._ID, COLUMN_NOMBRE, COLUMN_STORYID
        };
    }

}
