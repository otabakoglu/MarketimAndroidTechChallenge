package com.bluefish.marketimandroidtechchallenge.utils;

import android.graphics.Color;

public class ViewUtils {

    private static String GREEN = "#67a11b";
    private static String ORANGE = "#ffa81c";
    private static String RED = "#d64238";

    public static int getStatusColor(String status){
        switch (status){
            case "Yolda": return Color.parseColor(GREEN);
            case "Hazırlanıyor": return Color.parseColor(ORANGE);
            case "Onay Bekliyor": return Color.parseColor(RED);
        }
        return Color.GRAY;
    }
}
