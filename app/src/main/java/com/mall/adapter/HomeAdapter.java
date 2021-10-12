package com.mall.adapter.home;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.mall.R;
import com.mall.sharedViewModel.SharedViewModel;
import com.mall.databinding.ItemProductBinding;
import com.mall.model.MallModel;

import java.util.ArrayList;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.HomeViewHolder>
{

    private SharedViewModel sharedViewModel;

    private ArrayList<MallModel> mallModels;

    public HomeAdapter(ArrayList<MallModel> mallModels)
    {
        this.mallModels = mallModels;
    }

    @NonNull
    @Override
    public HomeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        sharedViewModel = new ViewModelProvider((ViewModelStoreOwner) parent.getContext()).get(SharedViewModel.class);
        return new HomeViewHolder(ItemProductBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull HomeViewHolder holder, int position)
    {
        MallModel model = mallModels.get(position);
        holder.binding.itemTxtTitleProduct.setText(model.getProductTitle());
        holder.binding.itemTxtPriceProduct.setText(model.getProductPrice() + " $");
        Glide
                .with(holder.itemView.getContext())
                .load(model.getProductImage())
                .into(holder.binding.itemCircleProduct);


        holder.itemView.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Bundle detailsBundle = new Bundle();
                detailsBundle.putString("productImage", model.getProductImage());
                sharedViewModel.setMallData(model.getProductTitle(), model.getProductDescription(), model.getProductImage(), model.getProductPrice(), model.getRatingResponse());
                Navigation.findNavController(view).navigate(R.id.action_homeFragment_to_productDetailsFragment, detailsBundle);
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
