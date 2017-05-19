package com.app.marvelcomics.utils;

import com.app.marvelcomics.model.Thumbnail;

/**
 * Created by alejandro on 19/5/17.
 */

public class Utils {

    static String LARGE      = "landscape_large";
    static String FANTASTIC  = "standard_fantastic";



    public static String getLargeImagePath(Thumbnail aThumb) {
        return aThumb.getmPath() + "/" + LARGE + "." + aThumb.getmExtension();
    }

    public static String getFantasticImagePath(Thumbnail aThumb) {
        return aThumb.getmPath() + "/" + FANTASTIC + "." + aThumb.getmExtension();
    }
}

