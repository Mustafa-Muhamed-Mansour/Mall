package com.mall.repositories.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.mall.model.MallModel;
import com.mall.network.MallClient;
import com.mall.network.MallService;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeRepository
{

    private MallService mallService;

    public HomeRepository()
    {
        mallService = MallClient.getRetrofit().create(MallService.class);
    }

    public LiveData<ArrayList<MallModel>> getProduct()
    {
        MutableLiveData<ArrayList<MallModel>> mallMutableLiveData = new MutableLiveData<>();

        mallService
                .getProductResponse()
                .enqueue(new Callback<ArrayList<MallModel>>() {
                    @Override
                    public void onResponse(Call<ArrayList<MallModel>> call, Response<ArrayList<MallModel>> response)
                    {
                        mallMutableLiveData.postValue(response.body());
                    }

                    @Override
                    public void onFailure(Call<ArrayList<MallModel>> call, Throwable t)
                    {
                        mallMutableLiveData.setValue(null);
                    }
                });
        return mallMutableLiveData;
    }
}
