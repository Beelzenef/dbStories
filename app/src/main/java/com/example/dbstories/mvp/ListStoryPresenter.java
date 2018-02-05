package com.example.dbstories.mvp;

import com.example.dbstories.data.pojo.Story;

import java.util.List;

/**
 *  List book presenter, intermediary for interactor and view
 * @author Elena Guzman Blanco (Beelzenef) - 3d10Mundos
 */

public class ListStoryPresenter implements ListStoryContract.Presenter, ListStoryInteractorImpl.OnLoadBooksListener {

    ListStoryContract.View view;
    ListStoryInteractorImpl interactor;

    public ListStoryPresenter(ListStoryContract.View v)
    {
        this.view = v;
        this.interactor = new ListStoryInteractorImpl(this);
    }

    @Override
    public void onSuccess(List<Story> list) {
        //view.dismissProgressDialog();
        view.showStories(list);
    }

    @Override
    public void loadStories() {
        //view.showProgressDialog();
        interactor.loadStories();
    }

    @Override
    public void removeStory(Story b) {
        //interactor.removeStory(b);
    }
}
