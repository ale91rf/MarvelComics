package com.app.marvelcomics.di.module;


import android.net.ConnectivityManager;

import com.app.marvelcomics.interactor.GetComicsInteractor;
import com.app.marvelcomics.networking.MarvelRepository;
import com.app.marvelcomics.presenter.HomePresenter;
import com.app.marvelcomics.presenter.HomePresenterImp;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class PresenterModule {
    @Provides
    @Singleton
    HomePresenter provideHomePresenter(GetComicsInteractor aInteractor, ConnectivityManager aConnectivity) {
        return new HomePresenterImp(aInteractor, aConnectivity);
    }

    @Provides
    @Singleton
    public GetComicsInteractor provideGetComicsInteractor(MarvelRepository aApi) {
        return new GetComicsInteractor(aApi);
    }

}
