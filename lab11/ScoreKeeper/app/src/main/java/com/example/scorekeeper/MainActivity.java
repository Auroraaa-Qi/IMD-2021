package com.example.scorekeeper;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.app.PendingIntent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int mScore1 = 0;
    private int mScore2 = 0;

    private TextView mScoreText1;
    private TextView mScoreText2;

    static final String STATE_SCORE_1 = "Team 1 Score";
    static final String STATE_SCORE_2 = "Team 2 Score";

    private SharedPreferences mPreferences;
    private String sharedPrefFile = "com.example.scorekeeper";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mScoreText1 = findViewById(R.id.score_1);
        mScoreText2 = findViewById(R.id.score_2);

//        if(savedInstanceState != null){
//            mScore1 = savedInstanceState.getInt(STATE_SCORE_1);
//            mScore2 = savedInstanceState.getInt(STATE_SCORE_2);
//
//            mScoreText1.setText(String.valueOf(mScore1));
//            mScoreText2.setText(String.valueOf(mScore2));
//        }

        mPreferences = getSharedPreferences(sharedPrefFile, MODE_PRIVATE);

        // restore preferences
        mScore1 = mPreferences.getInt(STATE_SCORE_1, mScore1);
        mScoreText1.setText(String.format("%s", mScore1));
        mScore2 = mPreferences.getInt(STATE_SCORE_2, mScore2);
        mScoreText2.setText(String.format("%s", mScore2));
    }

    @Override
    protected void onPause(){
        super.onPause();
        SharedPreferences.Editor preferencesEditor = mPreferences.edit();
        preferencesEditor.putInt(STATE_SCORE_1, mScore1);
        preferencesEditor.putInt(STATE_SCORE_2, mScore2);
        preferencesEditor.apply();

    }

    public void decreaseScore(View view) {
        int viewID = view.getId();
        switch (viewID){
            case R.id.decreaseTeam1:
                mScore1 -= 1;
                mScoreText1.setText(String.valueOf(mScore1));
                break;

            case R.id.decreaseTeam2:
                mScore2 -= 1;
                mScoreText2.setText(String.valueOf(mScore2));
                break;
        }
    }

    public void increaseScore(View view) {
        int viewID = view.getId();
        switch (viewID){
            case R.id.increaseTeam1:
                mScore1 += 1;
                mScoreText1.setText(String.valueOf(mScore1));
                break;

            case R.id.increaseTeam2:
                mScore2 += 1;
                mScoreText2.setText(String.valueOf(mScore2));
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.main_menu, menu);
        int nightMode = AppCompatDelegate.getDefaultNightMode();
        if(nightMode == AppCompatDelegate.MODE_NIGHT_YES){
            menu.findItem(R.id.night_mode).setTitle(R.string.day_mode);
        }
        else {
            menu.findItem(R.id.night_mode).setTitle(R.string.night_mode);
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        if(item.getItemId() == R.id.night_mode) {
            int nightMode = AppCompatDelegate.getDefaultNightMode();
            if(nightMode == AppCompatDelegate.MODE_NIGHT_YES){
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            }
            else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            }
            recreate();
        }
        return true;
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt(STATE_SCORE_1, mScore1);
        outState.putInt(STATE_SCORE_2, mScore2);
        super.onSaveInstanceState(outState);
    }

    public void reset(View view) {
        // Reset count
        mScore1 = 0;
        mScoreText1.setText(String.format("%s", mScore1));

        // Reset color
        mScore2 =0;
        mScoreText2.setText(String.format("%s", mScore2));

        SharedPreferences.Editor preferencesEditor = mPreferences.edit();
        preferencesEditor.clear();
        preferencesEditor.apply();
    }
}