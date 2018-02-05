package com.example.dbstories.data;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.dbstories.R;
import com.example.dbstories.data.pojo.Story;

import java.util.ArrayList;

/**
 * Books Adapter
 * @author Elena Guzman Blanco (Beelzenef) - 3d10Mundos
 */

public class StoriesAdapter extends ArrayAdapter<Story> {

    public StoriesAdapter(@NonNull Context context) {
        super(context, R.layout.item_stories, new ArrayList<Story>());
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        StoryHolder bookHolder;
        View view = convertView;

        if (view == null) {
            LayoutInflater inflador = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            // Inflate views
            view = inflador.inflate(R.layout.item_stories, null);
            bookHolder = new StoryHolder();

            // Get views from layout
            bookHolder.txtV_Title = (TextView) view.findViewById(R.id.txtV_Title);
            bookHolder.txtV_Author = (TextView) view.findViewById(R.id.txtV_Author);

            view.setTag(bookHolder);
        }
        else {
            bookHolder = (StoryHolder) view.getTag();
        }

        bookHolder.txtV_Title.setText(getItem(position).getTitle());
        bookHolder.txtV_Author.setText(getItem(position).getAuthor());

        return view;

    }

    class StoryHolder {

        TextView txtV_Title;
        TextView txtV_Author;
    }
}
