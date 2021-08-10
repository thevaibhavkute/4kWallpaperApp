package com.animation.walpaper4k;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.animation.walpaper4k.adpters.PagerAdapter;

import java.util.ArrayList;

public class FullWallpaper extends AppCompatActivity {
    int pos;

    ArrayList<String> allImageList = new ArrayList<>();
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.full_screen_wallpeper_activity);
        pos = getIntent().getIntExtra("pos",0);
        allImageList = getIntent().getStringArrayListExtra("list");
        viewPager = findViewById(R.id.viewPager);
        PagerAdapter pagerAdapter=new PagerAdapter(FullWallpaper.this,allImageList);
        viewPager.setAdapter(pagerAdapter);
        viewPager.setCurrentItem(pos);



    }
}