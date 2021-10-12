package com.mall.repositories.home;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.mall.model.MallModel;
import com.mall.network.MallClient;
import com.mall.network.MallService;

import java.util.ArrayList;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class HomeRepository
{

    private MallService mallService;
    public MutableLiveData<ArrayList<MallModel>> mallMutableLiveData = new MutableLiveData<>();

    public HomeRepository()
    {
        mallService = MallClient.getRetrofit().create(MallService.class);
    }

    public LiveData<ArrayList<MallModel>> getProduct()
    {
        Observable<ArrayList<MallModel>> observable = mallService.getProductResponse().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());

        Observer<ArrayList<MallModel>> observer = new Observer<ArrayList<MallModel>>()
        {
            @Override
            public void onSubscribe(@NonNull Disposable d)
            {
            }

            @Override
            public void onNext(@NonNull ArrayList<MallModel> mallModels)
            {
                mallMutableLiveData.postValue(mallModels);
            }

            @Override
            public void onError(@NonNull Throwable e)
            {
                mallMutableLiveData.setValue(null);
            }

            @Override
            public void onComplete()
            {
            }
        };

        observable.subscribe(observer);
        return mallMutableLiveData;
    }
}
