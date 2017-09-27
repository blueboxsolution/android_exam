package com.bbx.androidexam.common;

import org.json.JSONObject;

import java.net.SocketTimeoutException;
import java.util.concurrent.TimeUnit;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by macbookair on 27/09/2017.
 */

public class OkHttpHelper {

    JSONObject jsonObject = null;

    // Constructor
    public OkHttpHelper() {

    }

    // Get JSON from URL
    public String getJSONFromUrl(String urlStr) {

        jsonObject = null;

        try{
            // 1. Create okHttp Client obj
            OkHttpClient okHttpClient = new OkHttpClient.Builder()
                    .connectTimeout(120, TimeUnit.SECONDS)
                    .writeTimeout(10, TimeUnit.SECONDS)
                    .readTimeout(60, TimeUnit.SECONDS).build();

            // okHttpClient.writeTimeoutMillis()
            MediaType type = MediaType.parse("application/json; charset=utf-8");
            // 2. Define request being send to the server

            Request request = new Request.Builder()
                    .url(urlStr)
                    .get()
                    .build();

            // 3. Transport the request and wait for the response to process next
            Response response = okHttpClient.newCall(request).execute();
            String result = response.body().string();
            return result;

        }catch (SocketTimeoutException e) {
            return e.getMessage();
        }catch (Exception e){
            e.printStackTrace();
            return e.getMessage();
        }

    }




}
