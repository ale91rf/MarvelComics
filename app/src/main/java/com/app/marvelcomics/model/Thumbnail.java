package com.app.marvelcomics.model;

import com.google.gson.annotations.SerializedName;



public class Thumbnail {
    @SerializedName("path")
    private String mPath;
    @SerializedName("extension")
    private String mExtension;

    public Thumbnail(){}

    public Thumbnail(String mPath, String mExtension) {
        this.mPath = mPath;
        this.mExtension = mExtension;
    }

    public String getmPath() {
        return mPath;
    }

    public void setmPath(String mPath) {
        this.mPath = mPath;
    }

    public String getmExtension() {
        return mExtension;
    }

    public void setmExtension(String mExtension) {
        this.mExtension = mExtension;
    }
}
