package com.eliseche.drinkingtime.helpers;

import android.util.TypedValue;

import com.eliseche.drinkingtime.DrinkingTimeApplication;

public class Display {
    public static int convertPixelToDp(int pixel) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, pixel, DrinkingTimeApplication.getContext().getResources().getDisplayMetrics());
    }
}
