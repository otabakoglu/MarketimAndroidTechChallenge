package com.bluefish.marketimandroidtechchallenge.utils;

public class DateUtils {

    public static String getMonth(String month){
        switch (Integer.parseInt(month)){
            case 1: return "Ocak";
            case 2: return "Şubat";
            case 3: return "Mart";
            case 4: return "Nisan";
            case 5: return "Mayıs";
            case 6: return "Haziran";
            case 7: return "Temmuz";
            case 8: return "Ağustos";
            case 9: return "Eylül";
            case 10: return "Ekim";
            case 11: return "Kasım";
            case 12: return "Aralık";
        }
        return "Upps :(";
    }
}
