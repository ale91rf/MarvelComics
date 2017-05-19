package com.app.marvelcomics;

import android.app.Application;

import com.app.marvelcomics.di.component.AppComponent;
import com.app.marvelcomics.di.component.DaggerAppComponent;
import com.app.marvelcomics.di.module.AndroidModule;



public class App extends Application {

    private AppComponent appComponent;

    public AppComponent getAppComponent() {
        return appComponent;
    }

    protected AppComponent initDagger(App application) {
        return DaggerAppComponent.builder()
                .androidModule(new AndroidModule(application))
                .build();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = initDagger(this);
    }
}
