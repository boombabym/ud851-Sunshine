package com.example.android.sunshine.sync;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;

import com.example.android.sunshine.data.WeatherContract;
import com.example.android.sunshine.utilities.NetworkUtils;
import com.example.android.sunshine.utilities.OpenWeatherJsonUtils;

import java.net.URL;

//  TODO (1) Create a class called SunshineSyncTask
public class SunshineSyncTask {

//  TODO (2) Within SunshineSyncTask, create a synchronized public static void method called syncWeather
    synchronized public static void syncWeather(Context context) {

//      TODO (3) Within syncWeather, fetch new weather data
        try {
            URL weatherRequestURL = NetworkUtils.getUrl(context);

            String weatherResponseJSON = NetworkUtils.getResponseFromHttpUrl(weatherRequestURL);

            ContentValues[] weatherValues = OpenWeatherJsonUtils.getWeatherContentValuesFromJson(context, weatherResponseJSON);

//      TODO (4) If we have valid results, delete the old data and insert the new
            if (weatherValues != null && weatherValues.length != 0) {
                ContentResolver sunshineCR = context.getContentResolver();
                sunshineCR.delete(WeatherContract.WeatherEntry.CONTENT_URI, null, null);
                sunshineCR.bulkInsert(WeatherContract.WeatherEntry.CONTENT_URI, weatherValues);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}