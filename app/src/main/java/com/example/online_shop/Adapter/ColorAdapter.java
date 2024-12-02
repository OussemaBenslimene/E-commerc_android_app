package com.example.online_shop.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.online_shop.R;
import com.example.online_shop.databinding.ViewholderColorBinding;
import com.example.online_shop.databinding.ViewholderSizeBinding;

import java.util.ArrayList;

public class ColorAdapter extends RecyclerView.Adapter<ColorAdapter.ViewHolder> {
    ArrayList<String> items;
    Context context;
    int selectPosition = -1;
    int lastSelectedPosition = -1;

    public ColorAdapter(ArrayList<String> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public ColorAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        ViewholderColorBinding binding = ViewholderColorBinding.inflate(LayoutInflater.from(context), parent, false);

        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ColorAdapter.ViewHolder holder, int position) {
        holder.binding.getRoot().setOnClickListener(view -> {
            lastSelectedPosition = selectPosition;
            selectPosition = holder.getAdapterPosition();
            notifyItemChanged(lastSelectedPosition);
            notifyItemChanged(selectPosition);

        });
        if(selectPosition == holder.getAdapterPosition()){
            Drawable unrappedDrawable = AppCompatResources.getDrawable(context, R.drawable.color_selected);
            Glide.with(context)
                    .load(unrappedDrawable)
                    .apply(RequestOptions.circleCropTransform())
                    .into(holder.binding.colorLayout);
        } else {
            Drawable unrappedDrawable = AppCompatResources.getDrawable(context, R.drawable.color_selected);
            Drawable wrappedDrawable = DrawableCompat.wrap(unrappedDrawable);
            DrawableCompat.setTint(wrappedDrawable, Color.parseColor(items.get(position)));
            Glide.with(context)
                    .load(unrappedDrawable)
                    .apply(RequestOptions.circleCropTransform())
                    .into(holder.binding.colorLayout);
        }

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ViewholderColorBinding binding;
        public ViewHolder(ViewholderColorBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
