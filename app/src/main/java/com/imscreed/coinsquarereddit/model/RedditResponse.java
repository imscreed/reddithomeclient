package com.imscreed.coinsquarereddit.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Ibrahim on 2018-02-18.
 */

public class RedditResponse {
    @SerializedName("data")
    @Expose
    private RedditMainDataResponse redditMainDataResponse;

    public RedditMainDataResponse getRedditMainDataResponse() {
        return redditMainDataResponse;
    }

}
