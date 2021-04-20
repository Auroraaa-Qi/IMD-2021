package com.example.droidcafe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class OrderActivity extends AppCompatActivity {

    private TextView donutText, iceCreamText, froyoText;

    public void display(TextView tempView, String name, int count){
        if(count!=0){
            String s = "You have ordered " + String.valueOf(count) + " " + name + ".";
            tempView.setText(s);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        donutText = findViewById(R.id.donutText);
        iceCreamText = findViewById(R.id.iceCreamText);
        froyoText = findViewById(R.id.froyoText);

        Intent intent = getIntent();
        int[] count = intent.getIntArrayExtra("count");
        this.display(donutText, "donut", count[0]);
        this.display(iceCreamText, "ice cream sanwich", count[1]);
        this.display(froyoText, "froyo", count[2]);
    }
}