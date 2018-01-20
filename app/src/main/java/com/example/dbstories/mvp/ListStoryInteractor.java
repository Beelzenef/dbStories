package com.example.dbstories.mvp;

import com.example.dbstories.data.Story;

import java.util.List;

/**
 * Interactor list book
 *  @author Elena Guzman Blanco (Beelzenef) - 3d10Mundos
 */

public interface ListStoryInteractor {

    interface OnLoadBooksListener {
        void onSuccess(List<Story> list);
    }

    void loadStories();
    //void removeStory(Story b);
}
