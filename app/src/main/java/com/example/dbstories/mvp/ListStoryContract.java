package com.example.dbstories.mvp;

import com.example.dbstories.base.BasePresenter;
import com.example.dbstories.base.BaseView;
import com.example.dbstories.data.pojo.Story;

import java.util.List;

/**
 * @author Elena Guzman Blanco (Beelzenef) - 3d10Mundos
 */

public interface ListStoryContract {

    interface View extends BaseView {
        void showStories(List<Story> bookList);
    }

    interface Presenter extends BasePresenter {
        void loadStories();
        void removeStory(Story b);
    }
}
