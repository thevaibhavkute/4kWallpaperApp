package com.animation.walpaper4k;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;
import android.widget.LinearLayout;

import com.animation.walpaper4k.adpters.CategoryListAdpter;

import java.util.ArrayList;

public class CategoryWallpaper extends AppCompatActivity {
    RecyclerView recyclerView;
    CategoryListAdpter categoryListAdpter;
    ArrayList<String> imagelist = new ArrayList<>();
    ArrayList<String> titlelist= new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_wallpaper);
        recyclerView =findViewById(R.id.category_rec_view);

        imagelist.add("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQV9Zbfin9HS3z0o3SxONFuwJY-uIjRmR91qMJs74eL59IIhdC6CLnCZJpBevo9rNqU6aw&usqp=CAU");
        imagelist.add("https://images.unsplash.com/photo-1514790193030-c89d266d5a9d?ixid=MnwxMjA3fDB8MHxzZWFyY2h8MXx8bWFuJTIwZGFya3xlbnwwfHwwfHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=600&q=60");
        imagelist.add("https://mcdn.wallpapersafari.com/medium/1/17/ZMBC10.jpg");
        imagelist.add("https://swall.teahub.io/photos/small/21-213156_devotional-wallpaper-for-mobile-hindu-god-wallpaper-hd.jpg");


        titlelist.add("Celebreties");
        titlelist.add("Dark");
        titlelist.add("Nature");
        titlelist.add("Devotional");

        categoryListAdpter = new CategoryListAdpter(imagelist,titlelist);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(categoryListAdpter);

    }
}