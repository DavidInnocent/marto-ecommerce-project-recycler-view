package com.example.ecommercemarto.innocent;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.ecommercemarto.Domain.CategoryDomain;
import com.example.ecommercemarto.R;


import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> {

    private List<CategoryDomain> categoryList;

    public CategoryAdapter(List<CategoryDomain> categoryList) {
        this.categoryList = categoryList;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.viewholder_category, parent, false);
        return new CategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        CategoryDomain category = categoryList.get(position);
        holder.textViewName.setText(category.getName());
        // You can use an image loading library like Glide or Picasso to load images
         Glide.with(holder.itemView.getContext()).load(category.getImagePath()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return categoryList.size();
    }

    public static class CategoryViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView textViewName;

        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.img);
            textViewName = itemView.findViewById(R.id.titleTxt);
        }
    }
}