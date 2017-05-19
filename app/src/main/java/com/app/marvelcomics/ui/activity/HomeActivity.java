package com.app.marvelcomics.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.app.marvelcomics.App;
import com.app.marvelcomics.R;
import com.app.marvelcomics.presenter.HomePresenter;
import com.app.marvelcomics.ui.view.HomeView;

import javax.inject.Inject;

public class HomeActivity extends AppCompatActivity implements HomeView {

    @Inject
    HomePresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        ((App)getApplication()).getAppComponent().inject(this);

        mPresenter.bind(this);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        mPresenter.unbind();
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }
}
