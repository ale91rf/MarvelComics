package com.app.marvelcomics.ui.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.app.marvelcomics.R;
import com.app.marvelcomics.model.Comic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;



public class ComicsAdapter extends RecyclerView.Adapter<ComicsAdapter.ComicsViewHolder> {

    private List<Comic> mComics;
    private Activity mActivity;

    public ComicsAdapter(Activity aActivity) {
        mActivity = aActivity;
        mComics   = new ArrayList<>();
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
        return new ComicsViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_home_item, parent, false));
    }

    @Override
    public void onBindViewHolder(ComicsViewHolder aHolder, int aPosition) {

        aHolder.render(mComics.get(aPosition), mActivity);

    }

    @Override
    public int getItemCount() {
        return mComics.size();
    }


    public class ComicsViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.image_comic)
        ImageView imageComic;
        @Bind(R.id.lbl_comic_name)
        TextView mName;
        @Bind(R.id.relative_comic)
        RelativeLayout mRelativeComic;


        public ComicsViewHolder(View aView){
            super(aView);
            ButterKnife.bind(this, aView);
        }

        public void render(Comic aComic, Activity aActivity) {

            mName.setText(aComic.getmTitle());
        }
    }
}
