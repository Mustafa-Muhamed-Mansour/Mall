package com.mall.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.mall.responses.RatingResponse;

public class MallModel
{

    @SerializedName("id")
    @Expose
    private int productID;
    @SerializedName("title")
    @Expose
    private String productTitle;
    @SerializedName("description")
    @Expose
    private String  productDescription;
    @SerializedName("image")
    @Expose
    private String productImage;
    @SerializedName("price")
    @Expose
    private int productPrice;
    @SerializedName("rating")
    @Expose
    private RatingResponse ratingResponse;

    public MallModel()
    {
    }

    public int getProductID() {
        return productID;
    }

    public String getProductTitle() {
        return productTitle;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public String getProductImage() {
        return productImage;
    }

    public int getProductPrice() {
        return productPrice;
    }

    public RatingResponse getRatingResponse() {
        return ratingResponse;
    }
}
