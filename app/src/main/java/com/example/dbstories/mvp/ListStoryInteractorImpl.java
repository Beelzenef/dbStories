package com.example.dbstories.mvp;

import com.example.dbstories.InteractorCallback;

/**
 * Interactor implementation for listin books
 *  @author Elena Guzman Blanco (Beelzenef) - 3d10Mundos
 */

public class ListStoryInteractorImpl implements ListStoryInteractor, InteractorCallback {

    OnLoadBooksListener listener;

    public ListStoryInteractorImpl(OnLoadBooksListener listener)
    {
        this.listener = listener;
    }

    @Override
    public void loadStories() {
        //listener.onSuccess(BookRepository.getInstance().getBooks());
    }

    @Override
    public void onError() {
        //listener.onError();
    }

    @Override
    public void onSuccess() {
        //listener.onSuccess(list);
    }
}
