package com.app.marvelcomics.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.marvelcomics.R;
import com.app.marvelcomics.ui.view.ComicDetailView;
import com.app.marvelcomics.utils.Constants;
import com.squareup.picasso.Picasso;

import butterknife.Bind;
import butterknife.ButterKnife;



public class ComicDetailActivity extends AppCompatActivity implements ComicDetailView {

    @Bind(R.id.image)
    ImageView mImage;

    @Bind(R.id.lbl_texto)
    TextView mLblDescription;

    @Bind(R.id.toolbar)
    Toolbar mToolbar;

    private String mDescription;
    private String mTitle;
    private String mImageUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comic_detail);
        ButterKnife.bind(this);
        getData();
        toolbarSetup();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);    }

    @Override
    public void getData() {
        mTitle       = getIntent().getStringExtra(Constants.TITLE);
        mDescription = getIntent().getStringExtra(Constants.DESCRIPTION);
        mLblDescription.setText(mDescription);
        mImageUrl    = getIntent().getStringExtra(Constants.PATH);
        Picasso.with(getApplicationContext()).load(mImageUrl).into(mImage);

    }

    @Override
    public void toolbarSetup() {
        mToolbar.setTitle(mTitle);
        setSupportActionBar(mToolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }
}
