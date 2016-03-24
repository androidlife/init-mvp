package com.training.lft.initmvp;

import android.app.Application;
import android.content.Context;

import timber.log.Timber;

/**
 * Created by laaptu on 3/23/16.
 */
public class MainApplication extends Application {

    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
        Timber.plant(new Timber.DebugTree());
    }

    public static Context getContext() {
        return context;
    }
}
