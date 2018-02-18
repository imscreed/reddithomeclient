package com.imscreed.coinsquarereddit.di.components;

import com.imscreed.coinsquarereddit.di.modules.NetworkModule;
import com.imscreed.coinsquarereddit.services.RedditService;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Ibrahim on 2018-02-18.
 */

@Singleton
@Component(modules = {NetworkModule.class})
public interface NetworkComponent {
    RedditService provideRedditService();
}
