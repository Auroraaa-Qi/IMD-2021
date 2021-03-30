package com.example.hellotoast;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private int mCount = 0;
    private TextView mShowCount;
    private Button countButton, zeroButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // R: resources的缩写
        mShowCount = (TextView) findViewById(R.id.show_count);
        countButton = (Button) findViewById(R.id.button_count);
        zeroButton = (Button) findViewById(R.id.button_zero);
    }

    public void showToast(View view) {
        Toast toast = Toast.makeText(this, R.string.toast_message, Toast.LENGTH_LONG);
        toast.show();;
    }

    public void countUp(View view) {
        mCount += 1;
        if(mCount == 1)
            zeroButton.setBackgroundColor(getResources().getColor(R.color.olive));
        if(mCount%2 == 1) {
            countButton.setBackgroundColor(getResources().getColor(R.color.purple_200));
        }
        else{
            countButton.setBackgroundColor(getResources().getColor(R.color.olive));
        }
        if(mShowCount != null)
            mShowCount.setText(Integer.toString(mCount));
    }

    public void returnToZero(View view) {
        mCount = 0;
        if(mShowCount != null) {
            zeroButton.setBackgroundColor(getResources().getColor(R.color.grey));
            countButton.setBackgroundColor(getResources().getColor(R.color.olive));
            mShowCount.setText(Integer.toString(mCount));
        }
    }
}