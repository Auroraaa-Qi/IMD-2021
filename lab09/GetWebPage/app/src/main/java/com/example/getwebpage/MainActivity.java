package com.example.getwebpage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private EditText mUrlInput;
    private TextView mScrollText;
    private Spinner mSpinner;

    private ArrayAdapter<String> adapter;
    String []mItems;
    String protocol;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mUrlInput = (EditText)findViewById(R.id.urlInput);
        mScrollText = (TextView)findViewById(R.id.scrollText);
        mSpinner = (Spinner) findViewById(R.id.spinner1);
        mScrollText.setText(R.string.scroll_hint);

        //建立数据源
        mItems = getResources().getStringArray(R.array.protocols);
        //建立adapter并绑定数据源
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, mItems);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //绑定adapter到控件
        mSpinner.setAdapter(adapter);
        mSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                protocol = mItems[position];
                System.out.println(protocol);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Do nothing.
            }
        });

    }

    public void getPage(View view){
        String urlString = protocol + mUrlInput.getText().toString();
        System.out.println(urlString);
        // Uri webPage = Uri.parse(urlString);
        new FetchWeb(mScrollText).execute(urlString);

        //隐藏键盘
        InputMethodManager inputManager = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        if(inputManager!=null){
            inputManager.hideSoftInputFromWindow(view.getWindowToken(),
                    InputMethodManager.HIDE_NOT_ALWAYS);
        }

        //检查网络连接
        ConnectivityManager connMgr = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = null;
        if(connMgr!=null){
            networkInfo = connMgr.getActiveNetworkInfo();
        }
    }
}