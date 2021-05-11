package com.example.getwebpage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class NetworkUtils {

    static String getWebPage(String urlString){
        HttpURLConnection urlConnection = null;
        BufferedReader reader = null;
        String JSONString = null;

        try {
            URL requestURL = new URL(urlString);
            urlConnection = (HttpURLConnection) requestURL.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();

            InputStream inputStream = urlConnection.getInputStream();
            reader = new BufferedReader(new InputStreamReader(inputStream));

            StringBuilder builder = new StringBuilder();
            String line = null;
            while((line=reader.readLine())!=null){
                builder.append(line);
                builder.append("\n");
            }
            if(builder.length()==0){
                return null;
            }
            JSONString =  builder.toString();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(urlConnection!=null){
                urlConnection.disconnect();
            }
            if(reader!=null){
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return JSONString;
    }
}
