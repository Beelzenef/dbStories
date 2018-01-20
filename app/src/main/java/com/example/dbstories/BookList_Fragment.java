package com.example.dbstories;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ListFragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.dbstories.base.BasePresenter;
import com.example.dbstories.data.StoriesAdapter;
import com.example.dbstories.data.Story;
import com.example.dbstories.mvp.ListStoryContract;

import java.util.List;

/**
 * Book list fragment, listing and selecting books for removal
 *  @author Elena Guzman Blanco (Beelzenef) - 3d10Mundos
 */

public class BookList_Fragment extends ListFragment implements ListStoryContract.View {

    public static final String TAG = "listBook";
    ListStoryContract.Presenter presenter;
    private ListBookListener callback;

    StoriesAdapter adapter;

    Toolbar toolbar_stories;

    public static BookList_Fragment newInstance(Bundle args) {

        BookList_Fragment fragment = new BookList_Fragment();

        if (args != null) {
            fragment.setArguments(args);
        }

        return fragment;
    }

    public interface ListBookListener {
    }

    @Override
    public void setPresenter(BasePresenter presenter) {
        this.presenter = (ListStoryContract.Presenter) presenter;
    }

    @Override
    public void showStories(List<Story> bookList) {
        adapter.clear();
        adapter.addAll(bookList);
    }

    // Overriding ListFragment code

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.adapter = new StoriesAdapter(getActivity());
        setRetainInstance(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_story_list, container, false);

        FloatingActionButton fab_AddNewBook = (FloatingActionButton) rootView.findViewById(R.id.fab_Books);
        toolbar_stories = (Toolbar) rootView.findViewById(R.id.toolbar_Books);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar_stories);

        fab_AddNewBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //callback.addNewBook(null);
            }
        });
        presenter.loadStories();

        return rootView;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        try {
            callback = (ListBookListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(getActivity().getLocalClassName() + " must be implemented");
        }
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        setListAdapter(adapter);
        ListView listV_listBooks = (ListView) getListView().findViewById(android.R.id.list);
        listV_listBooks.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Bundle b = new Bundle();
                //b.putParcelable(Story.TAG, (Story)parent.getItemAtPosition(position));
                //callback.viewSelectedBook(b);
            }
        });

        registerForContextMenu(getListView());

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getActivity().getMenuInflater().inflate(R.menu.contextmenu_delete_story, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo)item.getMenuInfo();

        switch (item.getItemId())
        {
            case R.id.action_delete_book:
                break;
        }

        return super.onContextItemSelected(item);
    }
}
