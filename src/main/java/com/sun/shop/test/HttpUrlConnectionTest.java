package com.sun.shop.test;


import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by ddyunf on 2018/7/17.
 * @author ddyunf
 */
public class HttpUrlConnectionTest {
    public static void main(String[] args) {
        HttpURLConnection conn = null;


        try {
            URL realUrl = new URL("https://www.douyu.com/");
            conn = (HttpURLConnection) realUrl.openConnection();
            System.out.println(conn);
        } catch (Exception e) {
           e.printStackTrace();
        }

    }
}
