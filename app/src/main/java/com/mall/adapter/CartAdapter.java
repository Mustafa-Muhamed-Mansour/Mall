package com.mall.adapter.cart;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.mall.databinding.ItemCartBinding;
import com.mall.model.ProductModel;

import java.util.ArrayList;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CartViewHolder>
{

    ArrayList<ProductModel> productModels;

    public CartAdapter(ArrayList<ProductModel> productModels)
    {
        this.productModels = productModels;
    }

    @NonNull
    @Override
    public CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        return new CartViewHolder(ItemCartBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull CartViewHolder holder, int position)
    {
        ProductModel model = productModels.get(position);
        holder.binding.itemProductTitle.setText(model.getTitle());
        holder.binding.itemProductPrice.setText(model.getPrice());
        holder.binding.itemProductNumber.setText(model.getNumber());
        Glide
                .with(holder.itemView.getContext())
                .load(model.getImage())
                .into(holder.binding.itemProductImg);

    }

    @Override
    public int getItemCount()
    {
        return productModels.size();
    }

    public class CartViewHolder extends RecyclerView.ViewHolder
    {

        private ItemCartBinding binding;

        public CartViewHolder(@NonNull ItemCartBinding binding)
        {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
