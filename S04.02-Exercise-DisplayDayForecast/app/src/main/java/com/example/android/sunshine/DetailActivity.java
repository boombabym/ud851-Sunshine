package com.example.android.sunshine;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import org.w3c.dom.Text;

public class DetailActivity extends AppCompatActivity {

    private static final String FORECAST_SHARE_HASHTAG = " #SunshineApp";

    private String passedInText;
    private TextView mWeatherDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        mWeatherDisplay = (TextView) findViewById(R.id.tv_display_weather);

        // TODO (2) Display the weather forecast that was passed from MainActivity
        Intent originatingIntent = getIntent();
        if (originatingIntent != null && originatingIntent.hasExtra(Intent.EXTRA_TEXT)) {
            passedInText = originatingIntent.getStringExtra(Intent.EXTRA_TEXT);
            mWeatherDisplay.setText(passedInText);
        }
    }
}