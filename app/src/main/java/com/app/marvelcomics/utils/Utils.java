package com.app.marvelcomics.utils;

import android.net.NetworkInfo;

import com.app.marvelcomics.model.Thumbnail;

/**
 * Created by alejandro on 19/5/17.
 */

public class Utils {

    static String LARGE      = "landscape_large";
    static String FANTASTIC  = "standard_fantastic";

    public static boolean isNetworkAvailable(NetworkInfo aActiveNetworkInfo) {

        return aActiveNetworkInfo != null && aActiveNetworkInfo.isConnected();
    }


    public static String getLargeImagePath(Thumbnail aThumb) {
        return aThumb.getmPath() + "/" + LARGE + "." + aThumb.getmExtension();
    }

    public static String getFantasticImagePath(Thumbnail aThumb) {
        return aThumb.getmPath() + "/" + FANTASTIC + "." + aThumb.getmExtension();
    }
}

