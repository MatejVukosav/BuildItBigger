package com.udacity.gradle.builditbigger;

import android.app.Application;

/**
 * Created by mvukosav
 * In this project, you will create an app with multiple flavors that uses multiple libraries and Google Cloud Endpoints.
 * The finished app will consist of four modules. A Java library that provides jokes,
 * a Google Cloud Endpoints (GCE) project that serves those jokes,
 * an Android Library containing an activity for displaying jokes,
 * and an Android app that fetches jokes from the GCE module and passes them to the Android Library for display.
 */
public class App extends Application {

    // - 10.0.2.2 is localhost's IP address in Android emulator
    public static String SERVER_URL_ADDRESS = "10.0.2.2:8080";

    @Override
    public void onCreate() {
        super.onCreate();
    }
}
