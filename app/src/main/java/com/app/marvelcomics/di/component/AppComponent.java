package com.app.marvelcomics.di.component;


import com.app.marvelcomics.di.module.ApiModule;
import com.app.marvelcomics.di.module.AppModule;
import com.app.marvelcomics.di.module.PresenterModule;
import com.app.marvelcomics.presenter.HomePresenterImp;
import com.app.marvelcomics.ui.activity.HomeActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class, PresenterModule.class, ApiModule.class})
public interface AppComponent {

    void inject(HomeActivity aActivity);

    void inject(HomePresenterImp aHomePresenter);


}