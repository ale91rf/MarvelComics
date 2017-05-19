package com.app.marvelcomics.model;

import com.google.gson.annotations.SerializedName;


public class Comic {

    @SerializedName("id")
    private int mId;
    @SerializedName("digitalId")
    private int mDigitalId;
    @SerializedName("title")
    private String mTitle;
    @SerializedName("issueNumber")
    private Double mIssueNumber;
    @SerializedName("variantDescription")
    private String mVariantDescription;
    @SerializedName("description")
    private String mDescription;
    @SerializedName("pageCount")
    private int mPageCount;
    @SerializedName("thumbnail")
    private Thumbnail mThumbnail;

    public Comic(){}

    public Comic(int mId, int mDigitalId, String mTitle, Double mIssueNumber, String mVariantDescription, String mDescription, int mPageCount, Thumbnail mThumbnail) {
        this.mId = mId;
        this.mDigitalId = mDigitalId;
        this.mTitle = mTitle;
        this.mIssueNumber = mIssueNumber;
        this.mVariantDescription = mVariantDescription;
        this.mDescription = mDescription;
        this.mPageCount = mPageCount;
        this.mThumbnail = mThumbnail;
    }

    public int getmId() {
        return mId;
    }

    public void setmId(int mId) {
        this.mId = mId;
    }

    public int getmDigitalId() {
        return mDigitalId;
    }

    public void setmDigitalId(int mDigitalId) {
        this.mDigitalId = mDigitalId;
    }

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public Double getmIssueNumber() {
        return mIssueNumber;
    }

    public void setmIssueNumber(Double mIssueNumber) {
        this.mIssueNumber = mIssueNumber;
    }

    public String getmVariantDescription() {
        return mVariantDescription;
    }

    public void setmVariantDescription(String mVariantDescription) {
        this.mVariantDescription = mVariantDescription;
    }

    public String getmDescription() {
        return mDescription;
    }

    public void setmDescription(String mDescription) {
        this.mDescription = mDescription;
    }

    public int getmPageCount() {
        return mPageCount;
    }

    public void setmPageCount(int mPageCount) {
        this.mPageCount = mPageCount;
    }

    public Thumbnail getmThumbnail() {
        return mThumbnail;
    }

    public void setmThumbnail(Thumbnail mThumbnail) {
        this.mThumbnail = mThumbnail;
    }
}
