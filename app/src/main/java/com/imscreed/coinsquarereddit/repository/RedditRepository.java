package com.imscreed.coinsquarereddit.repository;

import android.os.Build;
import android.support.annotation.RequiresApi;

import com.imscreed.coinsquarereddit.di.components.DaggerNetworkComponent;
import com.imscreed.coinsquarereddit.di.components.NetworkComponent;
import com.imscreed.coinsquarereddit.model.RedditPost;
import com.imscreed.coinsquarereddit.model.RedditResponse;
import com.imscreed.coinsquarereddit.services.RedditService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Ibrahim on 2018-02-18.
 */

public class RedditRepository {
    private RedditService redditService;

    public void setRepoFetchListener(RepoFetchListener mRepoFetchListener) {
        this.mRepoFetchListener = mRepoFetchListener;
    }

    private RepoFetchListener mRepoFetchListener;

    public RedditRepository() {
        init();
    }

    private void init() {
        NetworkComponent networkComponent = DaggerNetworkComponent.builder().build();
        redditService = networkComponent.provideRedditService();
    }

    public void fetchRedditPosts() {
        List<RedditPost> posts = new ArrayList<>();
        Call<RedditResponse> call =  redditService.getPostsFromHomePage();
        call.enqueue(new Callback<RedditResponse>() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onResponse(Call<RedditResponse> call, Response<RedditResponse> response) {
                if(response.isSuccessful()){
                    response.body().getRedditMainDataResponse().getRedditPosts().forEach(x -> posts.add(x.getRedditPost()));
                    mRepoFetchListener.onSuccess(posts);
                }else{
                    mRepoFetchListener.onFailure();
                }
            }

            @Override
            public void onFailure(Call<RedditResponse> call, Throwable t) {
                t.printStackTrace();
                mRepoFetchListener.onFailure();
            }
        });
    }

    public interface RepoFetchListener {
        public void onSuccess(List<RedditPost> redditPosts);
        public void onFailure();
    }

}
