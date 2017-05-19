package com.app.marvelcomics.model;

import com.app.marvelcomics.model.ComicData;
import com.google.gson.annotations.SerializedName;


public class ComicResponse {

    @SerializedName("code")
    private int mCode;
    @SerializedName("status")
    private String mStatus;
    @SerializedName("attributionText")
    private String mAttributionText;
    @SerializedName("etag")
    private String mETag;
    @SerializedName("copyright")
    private String mCopyright;
    @SerializedName("attributionHTML")
    private String mAttributionHTML;
    @SerializedName("data")
    private ComicData mData;

    public ComicResponse(){}

    public ComicResponse(int mCode, String mStatus, String mAttributionText, String mETag, String mCopyright, String mAttributionHTML, ComicData mData) {
        this.mCode = mCode;
        this.mStatus = mStatus;
        this.mAttributionText = mAttributionText;
        this.mETag = mETag;
        this.mCopyright = mCopyright;
        this.mAttributionHTML = mAttributionHTML;
        this.mData = mData;
    }

    public int getmCode() {
        return mCode;
    }

    public void setmCode(int mCode) {
        this.mCode = mCode;
    }

    public String getmStatus() {
        return mStatus;
    }

    public void setmStatus(String mStatus) {
        this.mStatus = mStatus;
    }

    public String getmAttributionText() {
        return mAttributionText;
    }

    public void setmAttributionText(String mAttributionText) {
        this.mAttributionText = mAttributionText;
    }

    public String getmETag() {
        return mETag;
    }

    public void setmETag(String mETag) {
        this.mETag = mETag;
    }

    public String getmCopyright() {
        return mCopyright;
    }

    public void setmCopyright(String mCopyright) {
        this.mCopyright = mCopyright;
    }

    public String getmAttributionHTML() {
        return mAttributionHTML;
    }

    public void setmAttributionHTML(String mAttributionHTML) {
        this.mAttributionHTML = mAttributionHTML;
    }

    public ComicData getmData() {
        return mData;
    }

    public void setmData(ComicData mData) {
        this.mData = mData;
    }
}
