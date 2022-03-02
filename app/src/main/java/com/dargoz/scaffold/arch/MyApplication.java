package com.dargoz.scaffold.arch;

import android.app.Application;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import dagger.hilt.android.HiltAndroidApp;
import io.realm.Realm;
import io.realm.log.LogLevel;
import io.realm.log.RealmLog;

@HiltAndroidApp
public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(this);
        PreferenceManager.getDefaultSharedPreferences(this);
        if(BuildConfig.DEBUG) {
            RealmLog.setLevel(LogLevel.ALL);
        }
    }
}
