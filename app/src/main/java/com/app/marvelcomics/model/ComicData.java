package com.app.marvelcomics.model;

import com.app.marvelcomics.model.Comic;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by alejandro on 19/5/17.
 */

public class ComicData {

    @SerializedName("offset")
    private int mOffset;
    @SerializedName("limit")
    private int mLimit;
    @SerializedName("total")
    private int mTotal;
    @SerializedName("count")
    private int mCount;
    @SerializedName("results")
    private List<Comic> mComics;

    public ComicData(){}

    public ComicData(int mOffset, int mLimit, int mTotal, int mCount, List<Comic> mComics) {
        this.mOffset = mOffset;
        this.mLimit = mLimit;
        this.mTotal = mTotal;
        this.mCount = mCount;
        this.mComics = mComics;
    }

    public int getmOffset() {
        return mOffset;
    }

    public void setmOffset(int mOffset) {
        this.mOffset = mOffset;
    }

    public int getmLimit() {
        return mLimit;
    }

    public void setmLimit(int mLimit) {
        this.mLimit = mLimit;
    }

    public int getmTotal() {
        return mTotal;
    }

    public void setmTotal(int mTotal) {
        this.mTotal = mTotal;
    }

    public int getmCount() {
        return mCount;
    }

    public void setmCount(int mCount) {
        this.mCount = mCount;
    }

    public List<Comic> getmComics() {
        return mComics;
    }

    public void setmComics(List<Comic> mComics) {
        this.mComics = mComics;
    }
}
