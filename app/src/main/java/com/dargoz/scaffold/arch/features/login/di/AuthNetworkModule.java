package com.dargoz.scaffold.arch.features.login.di;

import static com.dargoz.scaffold.arch.features.feedback.di.NetworkModule.gson;

import com.dargoz.scaffold.arch.features.login.data.datasources.remote.AuthService;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ActivityComponent;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
@InstallIn(ActivityComponent.class)
public class AuthNetworkModule {

    @Provides
    public AuthService provideAuthService(OkHttpClient client) {
        return new Retrofit.Builder()
                .baseUrl("http://10.0.2.2:3001/")
                .client(client)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()
                .create(AuthService.class);
    }

}
