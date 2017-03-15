package com.clownjee.timeline.util;

import android.databinding.BindingConversion;
import android.view.View;

/**
 * Created by Clownjee on 2017/3/15.
 */
public class Utils {

    @BindingConversion
    public static int convertSpread(boolean spread) {
        if (spread) {
            return View.VISIBLE;
        } else {
            return View.GONE;
        }
    }
}
