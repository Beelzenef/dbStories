package com.example.dbstories.data.prefs;

import android.app.Application;
import android.content.Context;

import com.example.dbstories.data.StoriesOpenHelper;

/**
 * StoryApplication
 */

public class StoryApplication  extends Application {
    private AppPreferencesHelper appPreferencesHelper;
    private StoriesOpenHelper storiesOpenHelper;
    private static Context context;

    public StoryApplication() {
        this.context = this;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        appPreferencesHelper = AppPreferencesHelper.getInstance();
        StoriesOpenHelper.getInstance().openDatabase();
    }

    public static Context getContext() {
        return context;
    }

    public AppPreferencesHelper getAppPreferencesHelper() {
        return appPreferencesHelper;
    }

}
