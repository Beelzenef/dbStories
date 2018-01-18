package com.example.dbstories.data;

import android.provider.BaseColumns;

/**
 * Story Contract
 */

public class StoryContract implements BaseColumns {

    public static abstract class StoryEntry {
        public static final String TABLE_NAME = "historia";

        public static final String ID = "id";
        public static final String TITLE = "titulo";
        public static final String AUTHOR = "autor";
    }
}
