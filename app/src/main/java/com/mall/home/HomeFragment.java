package com.mall.home;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.mall.adapter.home.HomeAdapter;
import com.mall.databinding.FragmentHomeBinding;
import com.mall.model.MallModel;
import com.mall.responses.MallResponse;

import java.util.ArrayList;

public class HomeFragment extends Fragment
{


    private FragmentHomeBinding binding;
    private NavController navController;
    private HomeViewModel homeViewModel;
    private HomeAdapter homeAdapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);

        navController = Navigation.findNavController(view);
        homeViewModel = new ViewModelProvider(requireActivity()).get(HomeViewModel.class);

        homeViewModel.getProduct().observe(getViewLifecycleOwner(), new Observer<ArrayList<MallModel>>()
        {
            @Override
            public void onChanged(ArrayList<MallModel> mallModels)
            {
                if (mallModels != null)
                {
                    homeAdapter = new HomeAdapter(mallModels);
                    binding.rVHome.setAdapter(homeAdapter);
                    binding.rVHome.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
                    binding.rVHome.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));
                }

                else
                {
                    Toast.makeText(getActivity(), "Error the data", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public void onDestroyView()
    {
        super.onDestroyView();

        homeViewModel.getProduct().removeObservers(getViewLifecycleOwner());
    }
}