package com.example.dbstories.mvp;

/**
 * Interactor implementation for listin books
 *  @author Elena Guzman Blanco (Beelzenef) - 3d10Mundos
 */

public class ListStoryInteractorImpl implements ListStoryInteractor {

    OnLoadBooksListener listener;

    public ListStoryInteractorImpl(OnLoadBooksListener listener)
    {
        this.listener = listener;
    }

    @Override
    public void loadStories() {
        //listener.onSuccess(BookRepository.getInstance().getBooks());
    }
}
