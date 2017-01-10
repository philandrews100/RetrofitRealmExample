package com.retrofitrealm.networking.clients;

import android.util.Log;

import com.facebook.stetho.okhttp3.StethoInterceptor;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Phil on 10/01/2017.
 */

public class ApiClient {
    private String TAG = ApiClient.class.getName();
    private Retrofit apiRetrofit = null;

    public ApiClient(String url) {
        if(apiRetrofit == null) {
            apiRetrofit = new Retrofit.Builder().client(getOkClient()).baseUrl(url).addConverterFactory(GsonConverterFactory.create()).build();
        }
    }

    public Retrofit getApiRetrofit() {
        return apiRetrofit;
    }

    private OkHttpClient getOkClient() {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                Log.e(TAG, message);
            }
        });
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);
        OkHttpClient okHttpClient = new OkHttpClient.Builder().addNetworkInterceptor(new StethoInterceptor()).addInterceptor(httpLoggingInterceptor).build();
        return okHttpClient;
    }
}
