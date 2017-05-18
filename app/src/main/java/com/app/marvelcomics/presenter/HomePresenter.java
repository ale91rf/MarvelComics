package com.app.marvelcomics.presenter;

import com.app.marvelcomics.ui.view.HomeView;

/**
 * Created by alejandro on 18/5/17.
 */

public interface HomePresenter extends BasePresenter<HomeView> {

    void getCommics();
}
