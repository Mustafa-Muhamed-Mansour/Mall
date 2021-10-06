package com.mall.adapter.home;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.mall.databinding.ItemProductBinding;
import com.mall.model.MallModel;

import java.util.ArrayList;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.HomeViewHolder>
{

    ArrayList<MallModel> mallModels;

    public HomeAdapter(ArrayList<MallModel> mallModels)
    {
        this.mallModels = mallModels;
    }

    @NonNull
    @Override
    public HomeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        return new HomeViewHolder(ItemProductBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull HomeViewHolder holder, int position)
    {
        MallModel model = mallModels.get(position);
        holder.binding.itemTxtTitleProduct.setText(model.getProductTitle());
        holder.binding.itemTxtDescriptionProduct.setText(model.getProductDescription());
        holder.binding.itemTxtPriceProduct.setText(model.getProductPrice() + "$");
        Glide
                .with(holder.itemView.getContext())
                .load(model.getProductImage())
                .into(holder.binding.itemImgProduct);

        holder.itemView.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Toast.makeText(holder.itemView.getContext(), "ID = " + model.getProductID(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount()
    {
        return mallModels.size();
    }

    public class HomeViewHolder extends RecyclerView.ViewHolder
    {

        private ItemProductBinding binding;

        public HomeViewHolder(@NonNull ItemProductBinding binding)
        {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
