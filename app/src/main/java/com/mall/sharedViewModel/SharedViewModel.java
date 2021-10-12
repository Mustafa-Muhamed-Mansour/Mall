package com.mall;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.mall.model.MallModel;
import com.mall.responses.RatingResponse;

public class SharedViewModel extends ViewModel
{

    private MutableLiveData<MallModel> mallMutableLiveData = new MutableLiveData<>();

    public void setMallData(String Title, String Description, String Image, double Price, RatingResponse ratingResponse)
    {
        MallModel mallModel = new MallModel(Title, Description, Image, Price, ratingResponse);
        mallMutableLiveData.setValue(mallModel);
    }


    public MutableLiveData<MallModel> getData()
    {
        return mallMutableLiveData;
    }
}
