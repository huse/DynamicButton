package com.kpr.hus.dynamicbutton;

/**
 * Created by a09348 on 9/1/2015.
 */
public class TruncatLast {
    public static String truncat(String str) {
       // if (str.length() > 0 && str.charAt(str.length()-1)=='x') {
            if (str.length() > 0 ) {
            str = str.substring(0, str.length()-1);
        }
        return str;
    }
}
