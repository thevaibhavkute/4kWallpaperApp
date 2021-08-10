package com.animation.walpaper4k;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.animation.walpaper4k.adpters.RecyclerViewAdapter;

import java.util.ArrayList;

public class ExpandCategory extends AppCompatActivity {
    RecyclerView rcMain;
    ArrayList<String> imgArrayList= new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expand_category);

        imgArrayList = getIntent().getStringArrayListExtra("imagelist");

        rcMain = findViewById(R.id.rcMain);
        rcMain.setLayoutManager(new GridLayoutManager(this, 2));
        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(ExpandCategory.this, imgArrayList);
        rcMain.setAdapter(recyclerViewAdapter);

    }
}