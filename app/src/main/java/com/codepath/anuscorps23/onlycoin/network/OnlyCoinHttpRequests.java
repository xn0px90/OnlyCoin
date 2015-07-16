package com.codepath.anuscorps23.onlycoin.network;

import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by anuscorps23 on 7/11/15.
 */
public class OnlyCoinHttpRequests extends  AsyncTask<String, Void, JSONArray> {


    protected JSONArray doInBackground(String... strings) {
        StringBuilder stringBuilder = null;
        JSONObject jsonObject = null;
        JSONArray jsonArray = null;

        try {

            // Declare a URL Connection
            URL url = new URL(strings[0]);


            // Open InputStream to connection
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.connect();
            InputStream in = conn.getInputStream();

            // Download and decode the string response using builder
            stringBuilder = new StringBuilder();
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));

            String line;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            jsonObject = new JSONObject(stringBuilder.toString());
            if (jsonObject != null) {
                jsonArray = jsonObject.getJSONArray("results");
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }


        return jsonArray;
    }

    protected void onPostExecute(JSONArray json) {
        // This method is executed in the UIThread
    }
}


