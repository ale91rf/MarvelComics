package com.app.marvelcomics.di.module;


import android.content.Context;

import com.app.marvelcomics.presenter.HomePresenter;
import com.app.marvelcomics.presenter.HomePresenterImp;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class PresenterModule {
    @Provides
    @Singleton
    HomePresenter provideHomePresenter(Context context) {
        return new HomePresenterImp(context);
    }
}
