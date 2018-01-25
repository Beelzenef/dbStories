package com.example.dbstories.data;

import com.example.dbstories.InteractorCallback;

import java.util.ArrayList;

/**
 * Repositorio para historias
 */

public class StoryRepo {

    // Atts
    private StoryDAO storyDAO;
    private static StoryRepo storyRepo;

    InteractorCallback interactorCallback;

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

    public void saveStory(Story s, InteractorCallback interactorCallback) {
        long id = storyDAO.save(s);
        if (id == 0)
            interactorCallback.onError();
        else
            interactorCallback.onSuccess();
    }

    public void updateStory(Story s) {
        long id = storyDAO.update(s);
        if (id == 0)
            interactorCallback.onError();
        else
            interactorCallback.onSuccess();
    }

    public void deleteStory(Story s) {
        long id = storyDAO.delete(s);
        if (id == 0)
            interactorCallback.onError();
        else
            interactorCallback.onSuccess();

    }
}
