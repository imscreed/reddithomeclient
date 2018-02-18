package com.imscreed.coinsquarereddit.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.imscreed.coinsquarereddit.BR;

/**
 * Created by Ibrahim on 2018-02-16.
 */

public class RedditPost extends BaseObservable implements Parcelable {

    @Expose
    @SerializedName("title")
    private String title;

    @Override
    public String toString() {
        return "RedditPost{" +
                "title='" + title + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RedditPost that = (RedditPost) o;

        return title != null ? title.equals(that.title) : that.title == null;
    }

    @Override
    public int hashCode() {
        return title != null ? title.hashCode() : 0;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.title);
    }

    public RedditPost(String title) {
        this.title = title;
    }

    @Bindable
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
        notifyPropertyChanged(BR.title);
    }

    protected RedditPost(Parcel in) {
        this.title = in.readString();
    }

    public static final Parcelable.Creator<RedditPost> CREATOR = new Parcelable.Creator<RedditPost>() {
        @Override
        public RedditPost createFromParcel(Parcel source) {
            return new RedditPost(source);
        }

        @Override
        public RedditPost[] newArray(int size) {
            return new RedditPost[size];
        }
    };
}
