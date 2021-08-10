package com.animation.walpaper4k.adpters;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.animation.walpaper4k.R;
import com.animation.walpaper4k.ExpandCategory;
import com.animation.walpaper4k.FullWallpaper;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.Myclass> {

    ExpandCategory expandCategory;
    ArrayList<String> imgArrayList;
    public RecyclerViewAdapter(ExpandCategory expandCategory, ArrayList<String> imgArrayList) {

        this.imgArrayList=imgArrayList;
        this.expandCategory = expandCategory;
    }

    @NonNull
    @Override
    public Myclass onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(expandCategory).inflate(R.layout.recycler_image_item,parent,false);

        return new Myclass(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Myclass holder, final int position) {
        Glide.with(expandCategory).load(imgArrayList.get(position)).into(holder.imageView);
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(expandCategory, FullWallpaper.class);
                i.putExtra("list",imgArrayList);
                i.putExtra("pos",position);
                expandCategory.startActivity(i);
            }
        });
    }



    @Override
    public int getItemCount() {

        return imgArrayList.size();
    }
    class Myclass extends RecyclerView.ViewHolder {
        ImageView imageView;
        public Myclass(@NonNull View itemView) {

            super(itemView);
            imageView=itemView.findViewById(R.id.image);
        }
    }
}
