package com.imscreed.coinsquarereddit.di.modules;

import com.imscreed.coinsquarereddit.services.RedditService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Ibrahim on 2018-02-18.
 */

@Module
public class NetworkModule {

    @Provides
    @Singleton
    Retrofit provideRetrofit(){
        return  new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://www.reddit.com/")
                .build();
    }

    @Provides
    @Singleton
    RedditService provideRedditService(Retrofit retrofit){
        return retrofit.create(RedditService.class);
    }
}
