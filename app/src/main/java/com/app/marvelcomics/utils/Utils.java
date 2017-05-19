package com.app.marvelcomics.utils;

import com.app.marvelcomics.model.Thumbnail;

/**
 * Created by alejandro on 19/5/17.
 */

public class Utils {

    static String INCREDIBLE = "landscape_incredible";
    static String MEDIUM     = "landscape_medium";
    static String LARGE      = "landscape_large";



    public static String getAllImagePath(Thumbnail aThumb) {
        return aThumb.getmPath() + "/" + LARGE + "." + aThumb.getmExtension();
    }
}

