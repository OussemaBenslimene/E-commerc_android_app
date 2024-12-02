package com.example.online_shop.Activity;

import android.content.Intent;
import android.os.Bundle;

import com.example.online_shop.databinding.ActivityIntroBinding;

public class IntroActivity extends BaseActivity {
    private ActivityIntroBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityIntroBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());

        binding.button.setOnClickListener(view -> {
            startActivity(new Intent(this,MainActivity.class));
            finish();
        });

    }
}