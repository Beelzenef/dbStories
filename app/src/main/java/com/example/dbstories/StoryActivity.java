package com.example.dbstories;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.example.dbstories.base.BaseActivity;
import com.example.dbstories.mvp.ListStoryPresenter;

/**
 *
 */

public class StoryActivity extends BaseActivity implements BookList_Fragment.ListBookListener {

    BookList_Fragment bookList_Frag;

    ListStoryPresenter bookListPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.fragmentcontainer_story_activity);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        bookList_Frag = (BookList_Fragment) fragmentManager.findFragmentByTag(BookList_Fragment.TAG);

        if (bookList_Frag == null)
        {
            bookList_Frag = BookList_Fragment.newInstance(null);
            fragmentTransaction.add(android.R.id.content, bookList_Frag, BookList_Fragment.TAG);
            fragmentTransaction.commit();
        }

        bookListPresenter = new ListStoryPresenter(bookList_Frag);

        bookList_Frag.setPresenter(bookListPresenter);
    }
}
