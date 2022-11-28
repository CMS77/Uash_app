package com.example.uashapp.java.controllers;

import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class JsonSenderController extends AsyncTask<String, Void, JSONArray> {

    @Override
    protected JSONArray doInBackground(String... urls) {

        URL url;
        HttpURLConnection urlConnection = null;
        String result = "";

        try {
            url = new URL(urls[0]); // Apenas aceita um URL por chamada
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
            JSONArray resultArray = new JSONArray();

            return resultArray;

        } catch(Exception e) {
            e.printStackTrace();
            return null;
        }

    }
}
