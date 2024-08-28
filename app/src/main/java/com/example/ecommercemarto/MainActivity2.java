package com.example.ecommercemarto;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.ecommercemarto.Adapter.CategoryAdapter;
import com.example.ecommercemarto.Domain.CategoryDomain;
import com.example.ecommercemarto.Domain.LocationDomain;
import com.example.ecommercemarto.databinding.ActivityMain2Binding;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MainActivity2 extends AppCompatActivity {

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    ActivityMain2Binding binding;

    private RecyclerView recyclerView;
    private CategoryAdapter adapter;
    private ArrayList<CategoryDomain> categoryList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMain2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        initLocation();
        initCategoryListInnocent();


    }

    private void initCategoryList() {





        DatabaseReference reference = database.getReference("Category");
        ArrayList<CategoryDomain> list = new ArrayList<>();
        list.add(new CategoryDomain("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSV8jDeR8_JWiDCtdwH3Ke39AiBsq1RZL6drQ&s","Vegetable",1));
        list.add(new CategoryDomain("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSV8jDeR8_JWiDCtdwH3Ke39AiBsq1RZL6drQ&s","Kale",2));
        list.add(new CategoryDomain("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSV8jDeR8_JWiDCtdwH3Ke39AiBsq1RZL6drQ&s","Sukuma",3));
        binding.progressBarCategory.setVisibility(View.VISIBLE);
        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                        list.add(dataSnapshot.getValue(CategoryDomain.class));
                    }
                    if (!list.isEmpty()) {
                        binding.catView.setLayoutManager(new LinearLayoutManager(MainActivity2.this, LinearLayoutManager.HORIZONTAL, false));
                        binding.catView.setAdapter(new CategoryAdapter(list));
                    }
                    binding.progressBarCategory.setVisibility(View.GONE);


                }
                if (snapshot.exists()) {
                    for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                        CategoryDomain category = dataSnapshot.getValue(CategoryDomain.class);
                        if (category != null) {
                            list.add(category);
                        } else {
                            // Log if the category is null
                            Log.e("MainActivity2", "Null CategoryDomain object in snapshot: " + dataSnapshot.toString());
                        }
                    }
                    if (!list.isEmpty()) {
                        binding.catView.setLayoutManager(new LinearLayoutManager(MainActivity2.this, LinearLayoutManager.HORIZONTAL, false));
                        binding.catView.setAdapter(new CategoryAdapter(list));
                    } else {
                        Log.e("MainActivity2", "Category list is empty.");
                    }
                    binding.progressBarCategory.setVisibility(View.GONE);
                } else {
                    Log.e("MainActivity2", "Snapshot does not exist.");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void initCategoryListInnocent() {

        DatabaseReference reference = database.getReference("Category");
        recyclerView = findViewById(R.id.catView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));


        // Initialize the list
        categoryList = new ArrayList<>();
//        categoryList.add(new CategoryDomain("https://res.cloudinary.com/ximmoz-corp/image/upload/v1714658109/firefy/plus.png", "Category 1", 1));
//        categoryList.add(new CategoryDomain("https://res.cloudinary.com/ximmoz-corp/image/upload/v1714658109/firefy/plus.png", "Category 2", 2));
//        categoryList.add(new CategoryDomain("https://res.cloudinary.com/ximmoz-corp/image/upload/v1714658109/firefy/plus.png", "Category 2", 2));

        // Set the adapter
        adapter = new CategoryAdapter(categoryList);
        recyclerView.setAdapter(adapter);

        binding.progressBarCategory.setVisibility(View.VISIBLE);
        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                        categoryList.add(dataSnapshot.getValue(CategoryDomain.class));
                    }
                    if (!categoryList.isEmpty()) {
                        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity2.this, LinearLayoutManager.HORIZONTAL, false));
                        recyclerView.setAdapter(new CategoryAdapter(categoryList));
                    }
                    binding.progressBarCategory.setVisibility(View.GONE);


                }
                if (snapshot.exists()) {
                    for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                        CategoryDomain category = dataSnapshot.getValue(CategoryDomain.class);
                        if (category != null) {
                            categoryList.add(category);
                        } else {
                            // Log if the category is null
                            Log.e("MainActivity2", "Null CategoryDomain object in snapshot: " + dataSnapshot.toString());
                        }
                    }
                    if (!categoryList.isEmpty()) {
                        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity2.this, LinearLayoutManager.HORIZONTAL, false));
                        recyclerView.setAdapter(new CategoryAdapter(categoryList));
                    } else {
                        Log.e("MainActivity2", "Category list is empty.");
                    }
                    binding.progressBarCategory.setVisibility(View.GONE);
                } else {
                    Log.e("MainActivity2", "Snapshot does not exist.");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void initLocation() {
        DatabaseReference reference = database.getReference("Location");
        ArrayList<LocationDomain> list = new ArrayList<>();

//        list.add(new LocationDomain(1,"Nairobi"));
//        list.add(new LocationDomain(2,"Mombasa"));
//        list.add(new LocationDomain(3,"Kisumu"));
//        list.add(new LocationDomain(4,"Eldoret"));
        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    for (DataSnapshot dataSnapshot : snapshot.getChildren()) {

                        list.add(dataSnapshot.getValue(LocationDomain.class));
                    }
                    ArrayAdapter<LocationDomain> adapter = new ArrayAdapter<>(MainActivity2.this, R.layout.sp_items, list);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    binding.locationSp.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}