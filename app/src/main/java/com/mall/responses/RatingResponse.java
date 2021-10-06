package com.mall.responses;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RatingResponse
{

    @SerializedName("rate")
    @Expose
    private float productRate;
    @SerializedName("count")
    @Expose
    private int productCount;

    public RatingResponse()
    {
    }

    public float getProductRate() {
        return productRate;
    }

    public int getProductCount() {
        return productCount;
    }
}
