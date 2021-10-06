package com.mall.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MallClient
{

    private static Retrofit retrofit;

    public static Retrofit getRetrofit()
    {
        if (retrofit == null)
        {
            retrofit = new Retrofit
                    .Builder()
                    .baseUrl("https://fakestoreapi.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
