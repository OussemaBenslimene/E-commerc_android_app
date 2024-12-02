package com.example.online_shop.Activity;

import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.online_shop.Adapter.ColorAdapter;
import com.example.online_shop.Adapter.SizeAdapter;
import com.example.online_shop.Adapter.SliderAdapter;
import com.example.online_shop.Domain.ItemDomain;
import com.example.online_shop.Domain.SliderItems;
import com.example.online_shop.Helper.ManagmentCart;
import com.example.online_shop.R;
import com.example.online_shop.databinding.ActivityDetailBinding;

import java.util.ArrayList;

public class DetailActivity extends BaseActivity {
    private ActivityDetailBinding binding;
    private ItemDomain object;
    private int numberOrder = 1;
    private ManagmentCart managmentCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());
        managmentCart = new ManagmentCart(this);
        getBundles();
        initBanners();
        initSize();
        initColor();

    }

    private void initColor() {
        ArrayList<String> list = new ArrayList<>();
        list.add("#006fc4");
        list.add("#daa048");
        list.add("#398d41");
        list.add("#0c3c72");
        list.add("#829db5");
        binding.recyclerColor.setAdapter(new ColorAdapter(list));
        binding.recyclerColor.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

    }

    private void initSize() {
        ArrayList<String> list = new ArrayList<>();
        list.add("S");
        list.add("M");
        list.add("L");
        list.add("XL");
        list.add("XXL");
        binding.recyclerSize.setAdapter(new SizeAdapter(list));
        binding.recyclerSize.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
    }

    private void initBanners() {
        ArrayList<SliderItems> sliderItems = new ArrayList<>();
        for (int i = 0; i < object.getPicUrl().size(); i++) {
            sliderItems.add(new SliderItems(object.getPicUrl().get(i)));

        }
        binding.viewpagerSlider.setAdapter(new SliderAdapter(sliderItems, binding.viewpagerSlider));
        binding.viewpagerSlider.setClipToPadding(false);
        binding.viewpagerSlider.setClipChildren(false);
        binding.viewpagerSlider.setOffscreenPageLimit(3);
        binding.viewpagerSlider.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);
    }

    private void getBundles() {
        object = (ItemDomain) getIntent().getSerializableExtra("object");
        binding.titletxt.setText(object.getTitle());
        binding.pricetxt.setText("TND"+object.getPrice());
        binding.descriptiontxt.setText(object.getDescription());
        binding.ratingbar.setRating((float) object.getRating());
        binding.ratingTxt.setText(object.getRating()+" Rating");

        binding.AddtoCartBtn.setOnClickListener(view -> {
            object.setNumberinCart(numberOrder);
            managmentCart.insertItem(object);
        });
        binding.backBtn.setOnClickListener(view -> finish());





    }
}