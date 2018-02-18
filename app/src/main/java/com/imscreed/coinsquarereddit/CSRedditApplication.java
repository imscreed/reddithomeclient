package com.imscreed.coinsquarereddit;

import android.app.Activity;
import android.app.Application;

import com.imscreed.coinsquarereddit.services.RedditService;

/**
 * Created by Ibrahim on 2018-02-17.
 */

public class CSRedditApplication extends Application {

    private RedditService redditService;
    @Override
    public void onCreate() {
        super.onCreate();
    }

    public RedditService getRedditService() {
        return redditService;
    }
}
