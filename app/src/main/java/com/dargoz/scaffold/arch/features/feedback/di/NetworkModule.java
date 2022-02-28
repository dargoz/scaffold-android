package com.dargoz.scaffold.arch.features.feedback.di;

import androidx.annotation.NonNull;

import com.dargoz.scaffold.arch.features.feedback.data.datasources.remote.services.GitlabService;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


import java.text.DateFormat;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ActivityComponent;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
@InstallIn(ActivityComponent.class)
public class NetworkModule {
    private static final String gitlabToken = "glpat-6VtJb2k-Ns8SXGApxzbb";

    public static final Gson gson = new GsonBuilder()
            .enableComplexMapKeySerialization()
            .serializeNulls()
            .setDateFormat(DateFormat.LONG)
            .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
            .setPrettyPrinting()
            .setVersion(1.0)
            .serializeNulls()
            .create();

    @Provides
    public static OkHttpClient provideOkHttpInterceptor() {
        return new OkHttpClient.Builder()
                .addInterceptor(chain -> {
                    Request.Builder request = chain.request().newBuilder();
                    request.addHeader("Authorization", "Bearer " + gitlabToken);
                    HttpUrl originalHttpUrl = chain.request().url();
                    HttpUrl url = originalHttpUrl.newBuilder().build();
                    request.url(url);
                    return chain.proceed(request.build());
                })
                .build();
    }

    @NonNull
    @Provides
    public static GitlabService provideGitlabService(OkHttpClient client) {
        return new Retrofit.Builder()
                .baseUrl("https://gitlab.com/api/v4/")
                .client(client)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()
                .create(GitlabService.class);
    }

}
