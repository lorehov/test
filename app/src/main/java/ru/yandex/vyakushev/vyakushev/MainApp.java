package ru.yandex.vyakushev.vyakushev;

import android.app.Application;

import okhttp3.OkHttpClient;

/**
 * Created by user on 09.08.16.
 */
public class MainApp extends Application {

    private static MainApp instance;

    private OkHttpClient client;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        client = new OkHttpClient();
    }

    public static MainApp getInstance() {
        return instance;
    }

    public OkHttpClient getClient() {
        return client;
    }
}
