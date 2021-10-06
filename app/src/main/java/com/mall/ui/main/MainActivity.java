package com.mall.ui.main;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationBarView;
import com.mall.R;
import com.mall.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity
{

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

//        NavController navController = Navigation.findNavController(MainActivity.this, R.id.nav_host);
//        navController.addOnDestinationChangedListener(new NavController.OnDestinationChangedListener()
//        {
//            @SuppressLint("NonConstantResourceId")
//            @Override
//            public void onDestinationChanged(@NonNull NavController controller, @NonNull NavDestination destination, @Nullable Bundle arguments)
//            {
//                switch (destination.getId())
//                {
//                    case R.id.splashFragment:
//                    case R.id.registerFragment:
//                        binding.bottomNavView.setVisibility(View.GONE);
//                        break;
//                    default:
//                        binding.bottomNavView.setVisibility(View.VISIBLE);
//                        break;
//                }
//            }
//        });

    }
}