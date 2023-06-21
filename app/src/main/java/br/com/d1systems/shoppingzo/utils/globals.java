package br.com.d1systems.shoppingzo.utils;

import android.util.Base64;

import java.io.UnsupportedEncodingException;

import br.com.d1systems.shoppingzo.BuildConfig;

public class globals {

    public static String getUrlServidor(){
        String url = "";
        if(BuildConfig.DEBUG){
            url = "http://10.0.0.148:8082";
            //url = "http://192.168.1.19:8082";
        }else {
            url =  "http://64.31.39.231:8082";
        }
        return url;
    }

    public static String decodeB64(String encoded) throws UnsupportedEncodingException {
        return new String(Base64.decode(encoded, Base64.DEFAULT), "ISO-8859-1");
    }


}
