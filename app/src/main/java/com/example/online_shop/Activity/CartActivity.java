package com.example.online_shop.Activity;

import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.online_shop.Adapter.CartAdapter;
import com.example.online_shop.Helper.ManagmentCart;
import com.example.online_shop.R;
import com.example.online_shop.databinding.ActivityCartBinding;

public class CartActivity extends AppCompatActivity {
    private ActivityCartBinding binding;
    private double tax;
    private ManagmentCart managmentCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCartBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        managmentCart = new ManagmentCart(this);
        calculatorCart();
        setVariable();
        initCartList();

    }



    private void calculatorCart() {
        double percentTax = 0; // Example percentage (10%)
        double delivery = 0;  // Example delivery fee
        tax = Math.round((managmentCart.getTotalFee() * percentTax) * 100.0) / 100.0;

        double total = Math.round((managmentCart.getTotalFee() + tax + delivery) * 100.0) / 100.0;
        double itemTotal = Math.round(managmentCart.getTotalFee() * 100.0) / 100.0;

        binding.totalFee.setText("$" + itemTotal);
        binding.tax.setText("$" + tax);
        binding.delivryTxt.setText("$" + delivery);
        binding.total.setText("$" + total);
    }

    private void setVariable() {
        binding.backBtn.setOnClickListener(v -> finish());
    }

    private void initCartList() {
        if (managmentCart.getListCart().isEmpty()) {
            binding.emptytxt.setVisibility(View.VISIBLE);
            binding.scrollV.setVisibility(View.GONE);
        } else {
            binding.emptytxt.setVisibility(View.GONE);
            binding.scrollV.setVisibility(View.VISIBLE);

            binding.cartView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
            binding.cartView.setAdapter(new CartAdapter(managmentCart.getListCart(), this, this::calculatorCart));
        }
    }
}