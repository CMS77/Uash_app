package com.example.uashapp.java.controllers;

import android.graphics.Bitmap;
import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class JsonReceiverController extends AsyncTask<String, Void, JSONArray> {

    @Override
    protected JSONArray doInBackground(String... params) {

        URL url;
        HttpURLConnection urlConnection = null;
        String result = "";

        try {
            url = new URL(params[0]); // Apenas aceita um URL por chamada, field[0] = url
            urlConnection = (HttpURLConnection) url.openConnection();

            InputStream in = urlConnection.getInputStream();
            InputStreamReader reader = new InputStreamReader(in);

            int data = reader.read();
            while(data != -1) {
                char current = (char) data;
                result += current;
                data = reader.read();
            }

            JSONObject jsonObject = new JSONObject(result);
            String resultInfo = jsonObject.getString(params[1]); // field[1] = campo de pesquisa
            JSONArray resultArray = new JSONArray(resultInfo);

            return resultArray;

        } catch(Exception e) {
            e.printStackTrace();
            return null;
        }

    }
}
