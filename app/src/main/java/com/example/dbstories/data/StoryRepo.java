package com.example.dbstories.data;

import android.database.Cursor;
import android.widget.CursorAdapter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/**
 * Repositorio para historias
 */

public class StoryRepo {

    // Atts
    private ArrayList<Story> stories;
    private StoryDAO storyDAO;
    private static StoryRepo storyRepo;

    // Constructor
    static {
        storyRepo = new StoryRepo();
    }

    private StoryRepo() {
        stories = new ArrayList<>();
        storyDAO = new StoryDAO();
        //initializeBooks();
    }

    // Methods

    private void initializeBooks() {

        addBook(new Story(1, "Ocaso: Imperio", "EGBo"));
        addBook(new Story(2, "Llegaron del cielo", "FSD"));
        addBook(new Story(3, "La espiral", "TGD"));
        addBook(new Story(4, "Crónicas de Argonath", "WFG"));
    }

    public void addBook(Story s) {
        storyDAO.addStory(s);
    }

    public void removeBook(Story b) {
        Iterator<Story> iterator = stories.iterator();

        while (iterator.hasNext()) {
            if (iterator.next().getTitle() == b.getTitle()) {
                iterator.remove();
                break;
            }
        }
    }

    public ArrayList<Story> getStories() {
        Cursor cursor = getStoriesCursor();
        if (cursor.moveToFirst()) {
            do {
                Story story = new Story(cursor.getInt(0), cursor.getString(1), cursor.getString(2));
                stories.add(story);
            } while (cursor.moveToNext());
        }
        return null;
    }

    public Cursor getStoriesCursor() {
       return storyDAO.loadAll();
    }

    public static StoryRepo getInstance() {
        return storyRepo;
    }

    public void editBook(Story b) {
        for (Story currentBook : stories) {
            if (currentBook.getTitle() == b.getTitle()) {

            }
        }
    }
}
