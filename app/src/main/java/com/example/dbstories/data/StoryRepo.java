package com.example.dbstories.data;

import android.database.Cursor;
import android.widget.CursorAdapter;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/**
 * Repositorio para historias
 */

public class StoryRepo {

    // Atts
    private StoryDAO storyDAO;
    private static StoryRepo storyRepo;

    // Constructor
    static {
        storyRepo = new StoryRepo();
    }

    private StoryRepo() {
        storyDAO = new StoryDAO();
    }

    // Methods

    public ArrayList<Story> getStories() {
       return storyDAO.loadAll();
    }

    public static StoryRepo getInstance() {
        if (storyRepo == null) {
            storyRepo = new StoryRepo();
        }
        return storyRepo;
    }

    public boolean existsStory(Story s) {
        return storyDAO.contains(s);
    }

    public long saveStory(Story s) {
        return storyDAO.save(s);
    }

    public void deleteStory(Story s) {
        storyDAO.delete(s);
    }
}
