package com.app.marvelcomics.ui.activity;

import android.content.Context;
import android.support.v4.widget.ContentLoadingProgressBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.app.marvelcomics.App;
import com.app.marvelcomics.R;
import com.app.marvelcomics.model.Comic;
import com.app.marvelcomics.presenter.HomePresenter;
import com.app.marvelcomics.ui.adapter.ComicsAdapter;
import com.app.marvelcomics.ui.view.HomeView;
import com.app.marvelcomics.utils.Constants;

import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;

public class HomeActivity extends AppCompatActivity implements HomeView {

    @Inject
    HomePresenter mPresenter;

    @Bind(R.id.toolbar)
    Toolbar mToolbar;
    @Bind(R.id.recycler_view)
    RecyclerView mRecycler;
    @Bind(R.id.progress_bar)
    ContentLoadingProgressBar mProgress;

    private ComicsAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        ((App)getApplication()).getAppComponent().inject(this);
        ButterKnife.bind(this);
        setupRecyclerView();
        toolbarSetup();
        mPresenter.bind(this);
        mPresenter.getCommics(getTimestamp());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        mPresenter.unbind();
    }

    @Override
    public void showProgress() {
        mProgress.setVisibility(View.VISIBLE);

    }

    @Override
    public void hideProgress() {
        mProgress.setVisibility(View.INVISIBLE);

    }

    @Override
    public void toolbarSetup() {
        mToolbar.setTitle(Constants.HOME_TOOLBAR_TITLE);

    }

    @Override
    public void setupRecyclerView() {
        mAdapter = new ComicsAdapter(this);
        mRecycler.setHasFixedSize(true);
        mRecycler.setLayoutManager(new LinearLayoutManager(this));
        mRecycler.setNestedScrollingEnabled(false);
        mRecycler.setAdapter(mAdapter);
    }

    @Override
    public void showMessage(String aMessage) {
        Toast.makeText(getApplicationContext(), aMessage, Toast.LENGTH_LONG).show();
    }

    @Override
    public void displayComics(List<Comic> aList) {
        mAdapter.addAll(aList);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public Context getContext() {
        return getApplicationContext();
    }

    @Override
    public Long getTimestamp() {
        return System.currentTimeMillis()/1000;
    }
}
