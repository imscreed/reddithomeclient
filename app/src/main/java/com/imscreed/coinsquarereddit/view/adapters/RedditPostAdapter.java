package com.imscreed.coinsquarereddit.view.adapters;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.imscreed.coinsquarereddit.BR;
import com.imscreed.coinsquarereddit.R;
import com.imscreed.coinsquarereddit.databinding.RedditItemLayoutBinding;
import com.imscreed.coinsquarereddit.model.RedditPost;

import java.util.List;

/**
 * Created by Ibrahim on 2018-02-17.
 */

public class RedditPostAdapter extends RecyclerView.Adapter<RedditPostAdapter.CustomViewHolder> {

    private List<RedditPost> posts;

    public RedditPostAdapter(List<RedditPost> posts) {
        this.posts = posts;
    }
    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        RedditItemLayoutBinding binding = DataBindingUtil.inflate(layoutInflater, R.layout.reddit_item_layout, parent, false);
        return new CustomViewHolder(binding);
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {
        final RedditPost redditPost = posts.get(position);
        holder.bind(redditPost);
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {
        private final RedditItemLayoutBinding binding;
        public CustomViewHolder(RedditItemLayoutBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
        public void bind(RedditPost post){
            binding.setVariable(BR.post, post);
        }
    }
}
