package com.mall.register;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mall.R;
import com.mall.databinding.RegisterFragmentBinding;

public class RegisterFragment extends Fragment
{

    private RegisterFragmentBinding binding;
    private NavController navController;
    private RegisterViewModel registerViewModel;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        binding = RegisterFragmentBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);

        navController = Navigation.findNavController(view);
        registerViewModel = new ViewModelProvider(requireActivity()).get(RegisterViewModel.class);

        binding.btnRegister.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                navController.navigate(R.id.action_registerFragment_to_homeFragment);
            }
        });
    }
}