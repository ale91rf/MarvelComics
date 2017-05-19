package com.app.marvelcomics.presenter;

import android.content.Context;

import com.app.marvelcomics.App;
import com.app.marvelcomics.networking.MarvelRepository;
import com.app.marvelcomics.ui.view.HomeView;

import javax.inject.Inject;

import rx.Subscription;
import rx.subscriptions.Subscriptions;


public class HomePresenterImp implements HomePresenter {

    @Inject
    MarvelRepository mApi;

    private HomeView mView;
    private Subscription subscription = Subscriptions.empty();


    public HomePresenterImp(Context context) {
        ((App)context).getAppComponent().inject(this);
    }

    @Override
    public void getCommics() {

    }


    @Override
    public void bind(HomeView view) {
        mView = view;
    }

    @Override
    public void unbind() {
        if (subscription != null && !subscription.isUnsubscribed())
            subscription.unsubscribe();

        mView = null;
    }
}
