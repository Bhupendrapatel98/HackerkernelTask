package com.example.hackerkerneltask.utils;

import android.app.Application;

import com.fxn.stash.Stash;

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Stash.init(this);
    }
}