package com.example.a20221121_michaelcasalinuovo_nycschools.retrofit;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private static RetrofitClient instance = null;
    private Api myApi;

    final OkHttpClient okHttpClient = new OkHttpClient.Builder()
            .readTimeout(160, TimeUnit.SECONDS)
            .connectTimeout(160, TimeUnit.SECONDS)
            .build();

    private RetrofitClient() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(Api.BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        myApi = retrofit.create(Api.class);
    }

    public static synchronized RetrofitClient getInstance() {
        if (instance == null) {
            instance = new RetrofitClient();
        }
        return instance;
    }

    public Api getMyApi() {
        return myApi;
    }
}
