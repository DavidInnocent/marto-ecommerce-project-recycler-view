package com.example.ecommercemarto.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.bumptech.glide.Glide;
import com.example.ecommercemarto.Domain.CategoryDomain;
import com.example.ecommercemarto.databinding.ViewholderCategoryBinding;


import java.util.ArrayList;

public class CategoryAdapter  extends RecyclerView.Adapter<CategoryAdapter.Viewholder>{
    ArrayList<CategoryDomain> items;
    Context context;

    public CategoryAdapter(ArrayList<CategoryDomain> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        ViewholderCategoryBinding binding = ViewholderCategoryBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new Viewholder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {
holder.binding.titleTxt.setText(items.get(position).getName());
        Glide.with(context)
                .load(items.get(position).getImagePath())
                .into(holder.binding.img);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public static class Viewholder extends RecyclerView.ViewHolder {

        ViewholderCategoryBinding binding;
        public Viewholder(ViewholderCategoryBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
