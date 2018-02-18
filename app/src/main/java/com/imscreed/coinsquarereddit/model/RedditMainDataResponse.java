package com.imscreed.coinsquarereddit.model;

import android.os.Build;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Ibrahim on 2018-02-17.
 */

public class RedditMainDataResponse {
    @Expose
    @SerializedName("children")
    private List<RedditChildResponse> redditPosts;

    public List<RedditChildResponse> getRedditPosts() {
        return redditPosts;
    }

}
