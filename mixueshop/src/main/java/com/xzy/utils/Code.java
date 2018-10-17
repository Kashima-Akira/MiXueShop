package com.xzy.utils;

public class Code {

    public static String getCode() {
        String str = "";
        for (int i = 0; i < 6; i++) {
            str += (int)Math.floor(Math.random()*10);
        }
       return str;
    }
}
