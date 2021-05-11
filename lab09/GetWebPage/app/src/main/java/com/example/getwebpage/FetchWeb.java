package com.example.getwebpage;

import android.net.Uri;
import android.os.AsyncTask;
import android.widget.TextView;

import java.lang.ref.WeakReference;
import java.net.MalformedURLException;
import java.net.URL;

public class FetchWeb extends AsyncTask<String, Void, String> {

    private WeakReference<TextView> mScrollText;

    public FetchWeb(TextView scrollText){
        this.mScrollText = new WeakReference<>(scrollText);
    }

    @Override
    protected String doInBackground(String... strings) {
        return NetworkUtils.getWebPage(strings[0]);
    }

    @Override
    protected void onPostExecute(String s){ //这里的s是NetworkUtils里返回的JSONString
        if (s!=null){
            mScrollText.get().setText(s);
        }
        else{
            mScrollText.get().setText("Sorry, something is wrong or the content is null.");
        }
    }
}
