package com.app.marvelcomics.ui.adapter;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.app.marvelcomics.R;
import com.app.marvelcomics.model.Comic;
import com.app.marvelcomics.ui.activity.ComicDetailActivity;
import com.app.marvelcomics.utils.Constants;
import com.app.marvelcomics.utils.Utils;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class ComicsAdapter extends RecyclerView.Adapter<ComicsAdapter.ComicsViewHolder> {

    private List<Comic> mComics;
    private Activity mActivity;


    public ComicsAdapter(Activity aActivity) {
        mActivity  = aActivity;
        mComics    = new ArrayList<>();
    }

    public void addAll(Collection<Comic> aCollection) {
        clear();
        for (int i = 0; i < aCollection.size(); i++) {
            mComics.add((Comic) aCollection.toArray()[i]);
        }
    }
    public void clear(){
        if (mComics != null) {
            mComics.clear();
        }
    }

    @Override
    public ComicsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ComicsViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_home_item, parent, false), mActivity);
    }

    @Override
    public void onBindViewHolder(ComicsViewHolder aHolder, int aPosition) {

        aHolder.render(mComics.get(aPosition));

    }

    @Override
    public int getItemCount() {
        return mComics.size();
    }


    public class ComicsViewHolder extends RecyclerView.ViewHolder {

        Activity mActivity;
        Comic mComic;

        @Bind(R.id.image_comic)
        ImageView mImageComic;
        @Bind(R.id.lbl_comic_name)
        TextView mName;

        @Bind(R.id.relative_comic)
        RelativeLayout mRelativeComic;

        @OnClick(R.id.relative_comic)
        public void itemClicked(){
            if (mActivity != null && mComic != null){
                Intent lIntent = new Intent(mActivity, ComicDetailActivity.class);
                lIntent.putExtra(Constants.TITLE, mComic.getmTitle());
                lIntent.putExtra(Constants.DESCRIPTION, mComic.getmDescription());
                lIntent.putExtra(Constants.PATH, Utils.getFantasticImagePath(mComic.getmThumbnail()));
                mActivity.startActivity(lIntent);
            }
        }


        public ComicsViewHolder(View aView, Activity aActivity){
            super(aView);
            mActivity = aActivity;
            ButterKnife.bind(this, aView);
        }

        public void render(Comic aComic) {
            mComic = aComic;
            mName.setText(mComic.getmTitle());
            Picasso.with(mActivity).load(Utils.getLargeImagePath(mComic.getmThumbnail())).into(mImageComic);
        }
    }
}
