package com.example.dbstories.base;

import com.example.dbstories.data.pojo.Story;

import java.util.ArrayList;

public interface StoryDAO {

    ArrayList<Story> loadAll();
    long add(Story s);
    long update(Story s);
    long delete(Story s);
}
