package com.imscreed.coinsquarereddit.services;

import com.imscreed.coinsquarereddit.model.RedditPost;
import com.imscreed.coinsquarereddit.model.RedditResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Ibrahim on 2018-02-17.
 */

public interface RedditService {

    @GET(".json")
    Call<RedditResponse> getPostsFromHomePage();
}
