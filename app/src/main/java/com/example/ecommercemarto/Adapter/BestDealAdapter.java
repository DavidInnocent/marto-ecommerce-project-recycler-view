package com.example.ecommercemarto.Adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ecommercemarto.Domain.BestDealDomain;
import com.example.ecommercemarto.databinding.ViewholderBestDealBinding;

import java.util.ArrayList;

public class BestDealAdapter extends RecyclerView.Adapter<BestDealAdapter.Viewholder>{
    ArrayList<BestDealDomain> items;
    Context context;

    public BestDealAdapter(ArrayList<BestDealDomain> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        ViewholderBestDealBinding binding = ViewholderBestDealBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new Viewholder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return items.size();
    }


    public class Viewholder extends RecyclerView.ViewHolder {

        ViewholderBestDealBinding binding;
        public Viewholder(ViewholderBestDealBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
