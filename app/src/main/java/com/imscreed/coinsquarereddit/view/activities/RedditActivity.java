package com.imscreed.coinsquarereddit.view.activities;

import android.content.res.Configuration;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.imscreed.coinsquarereddit.R;
import com.imscreed.coinsquarereddit.databinding.ActivityRedditBinding;
import com.imscreed.coinsquarereddit.model.RedditPost;
import com.imscreed.coinsquarereddit.repository.RedditRepository;
import com.imscreed.coinsquarereddit.view.adapters.RedditPostAdapter;

import java.util.ArrayList;
import java.util.List;

public class RedditActivity extends AppCompatActivity {

    private ActivityRedditBinding activityBinding;
    private List<RedditPost> posts = new ArrayList<>();
    RedditRepository redditRepository = new RedditRepository();

    //region onCreate
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reddit);
        initDataBinding();
        redditRepository.fetchRedditPosts();
        redditRepository.setRepoFetchListener(mRepoListener);
        activityBinding.swiperefresh.setOnRefreshListener(() -> redditRepository.fetchRedditPosts());
    }
    //endregion

    //region Setup Binding
    private void initDataBinding() {
        activityBinding = DataBindingUtil.setContentView(this, R.layout.activity_reddit);
    }
    //endregion

    //region SetupUI
    private void setupRedditPosts(RecyclerView recyclerView) {
        if(posts != null){
            RedditPostAdapter adapter = new RedditPostAdapter(posts);
            recyclerView.setAdapter(adapter);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            activityBinding.progressBar.setVisibility(View.GONE);
        }else{
            Toast.makeText(this, "Failed to fetch from Reddit", Toast.LENGTH_LONG).show();
            activityBinding.progressBar.setVisibility(View.GONE);
        }
    }
    //endregion

    //region Repository Fetch Listener
    RedditRepository.RepoFetchListener mRepoListener = new RedditRepository.RepoFetchListener() {
        @Override
        public void onSuccess(List<RedditPost> redditPosts) {
            posts = redditPosts;
            setupRedditPosts(activityBinding.recyclerView);
            activityBinding.swiperefresh.setRefreshing(false);
        }

        @Override
        public void onFailure() {
            Toast.makeText(RedditActivity.this, "Failed to fetch from Reddit", Toast.LENGTH_LONG).show();
            activityBinding.progressBar.setVisibility(View.GONE);
            activityBinding.swiperefresh.setRefreshing(false);
        }
    };
    //endregion

}
