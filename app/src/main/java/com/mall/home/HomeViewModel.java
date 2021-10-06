package com.mall.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.mall.model.MallModel;
import com.mall.repositories.home.HomeRepository;

import java.util.ArrayList;

public class HomeViewModel extends ViewModel
{

    private HomeRepository homeRepository;

    public HomeViewModel()
    {
        homeRepository = new HomeRepository();
    }

    public LiveData<ArrayList<MallModel>> getProduct()
    {
        return homeRepository.getProduct();
    }
}
