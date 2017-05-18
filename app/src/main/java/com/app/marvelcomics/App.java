package com.app.marvelcomics;

import android.app.Application;

import com.app.marvelcomics.di.component.AppComponent;
import com.app.marvelcomics.di.component.DaggerAppComponent;
import com.app.marvelcomics.di.module.AppModule;

/**
 * Created by alejandro on 18/5/17.
 */

public class App extends Application {

    private AppComponent appComponent;

    public AppComponent getAppComponent() {
        return appComponent;
    }

    protected AppComponent initDagger(App application) {
        return DaggerAppComponent.builder()
                .appModule(new AppModule(application))
                .build();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = initDagger(this);
    }
}
