package com.dargoz.scaffold.arch;

import android.app.Application;
import android.os.Build;
import android.os.StrictMode;

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
        if(BuildConfig.DEBUG) {
            RealmLog.setLevel(LogLevel.ALL);
        }

        if(BuildConfig.DEBUG) {
            StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
                    .detectDiskReads()
                    .detectDiskWrites()
                    .detectNetwork()   // or .detectAll() for all detectable problems
                    .penaltyLog()
                    .build());
            StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder()
                    .detectLeakedSqlLiteObjects()
                    .detectLeakedClosableObjects()
                    .penaltyLog();
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                builder.detectNonSdkApiUsage();
            }
            StrictMode.setVmPolicy(builder.build());
        }
    }
}
