package com.mall.network;

import com.mall.model.MallModel;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MallService
{

    @GET("products")
    Call<ArrayList<MallModel>> getProductResponse();
}
