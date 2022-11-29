package com.example.uashapp.java.controllers;

import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class JsonSenderController extends AsyncTask<String, Void, JSONArray> {

    @Override
    protected JSONArray doInBackground(String... params) {

        URL url;
        HttpURLConnection urlConnection = null;

        try {
            url = new URL(params[0]); // Apenas aceita um URL por chamada, field[0] = url
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setConnectTimeout(20000);
            urlConnection.setReadTimeout(10000); // TODO: post?

            OutputStream out = urlConnection.getOutputStream();
            OutputStreamWriter writer = new OutputStreamWriter(out);

            writer.write(params[1]); // field[1] = campo de entrada
            writer.close();
            out.close();

        } catch(Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
