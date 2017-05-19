package com.app.marvelcomics.ui.view;


import android.content.Context;

import com.app.marvelcomics.model.Comic;

import java.util.List;

public interface HomeView {

    void showProgress();
    void hideProgress();
    void toolbarSetup();
    void setupRecyclerView();
    void showMessage(String aMessage);
    void displayComics(List<Comic> aList);

    Context getContext();
    Long getTimestamp();

}
