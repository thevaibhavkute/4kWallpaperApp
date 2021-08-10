package com.animation.walpaper4k.adpters;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.animation.walpaper4k.CategoryWallpaper;
import com.animation.walpaper4k.ExpandCategory;
import com.animation.walpaper4k.R;
import com.bumptech.glide.Glide;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class CategoryListAdpter extends RecyclerView.Adapter<CategoryListAdpter.MyCategory> {
    ArrayList<String> imagelist;
    ArrayList<String> titlelist;

    public CategoryListAdpter(ArrayList<String> imagelist, ArrayList<String> titlelist) {
        this.imagelist = imagelist;
        this.titlelist = titlelist;
    }

    @NonNull
    @org.jetbrains.annotations.NotNull
    @Override
    public MyCategory onCreateViewHolder(@NonNull @org.jetbrains.annotations.NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_image_item, parent, false);

        return new MyCategory(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @org.jetbrains.annotations.NotNull final CategoryListAdpter.MyCategory holder, final int position) {
        Glide.with(holder.imageView.getContext()).load(imagelist.get(position)).into(holder.imageView);
        holder.title.setVisibility(View.VISIBLE);
        holder.title.setText(titlelist.get(position));
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (titlelist.get(position).equals("Celebreties")) {
                    ArrayList<String> imgArrayList = new ArrayList<>();
                    imgArrayList.add("https://i.pinimg.com/originals/c2/8d/00/c28d00c15e57351e9f630d01ee91bfb0.png");
                    imgArrayList.add("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQOCgeLH4uqPynKoJBZNnFyzHn_sNPR0ZsY5w&usqp=CAU");
                    imgArrayList.add("https://i.pinimg.com/originals/a8/af/ae/a8afae6a9e8c7d5b4c808a040125f17b.jpg");
                    imgArrayList.add("https://content.tupaki.com//twdata/2020/0920/photos/actress/Rashmika%20Mandanna%20Sensuous%20Poses/normal/Rashmika%20Mandanna%20Sensuous%20Poses_5.jpg");
                    imgArrayList.add("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQKV6DYJQNjz-NJ2v5FjKbL3cCMKfUuWZAeVw&usqp=CAU");
                    imgArrayList.add("https://wallpapercave.com/wp/wp5190338.jpg");
                    imgArrayList.add("https://wallpapercave.com/wp/wp5547115.jpg");
                    imgArrayList.add("https://wallpapercave.com/wp/wp5493687.jpg");
                    imgArrayList.add("https://wallpapercave.com/wp/wp5775130.jpg");
                    imgArrayList.add("https://wallpapercave.com/wp/wp5775134.jpg");
                    imgArrayList.add("https://wallpapercave.com/wp/wp4862671.jpg");
                    imgArrayList.add("https://wallpapercave.com/wp/wp5230013.jpg");
                    imgArrayList.add("https://wallpapercave.com/wp/wp3975159.jpg");
                    imgArrayList.add("https://www.startupstories.in/wp-content/uploads/2019/01/main-qimg-7b7886df271e777b81c88314a8a9260a.png");


                    Intent i = new Intent(holder.imageView.getContext(), ExpandCategory.class);
                    i.putExtra("imagelist", imgArrayList);
                    holder.imageView.getContext().startActivity(i);


                } else if (titlelist.get(position).equals("Dark")) {
                    ArrayList<String> imgArrayList = new ArrayList<>();
                    imgArrayList.add("https://r1.ilikewallpaper.net/iphone-wallpapers/download/5373/Black-3D-Blocks-iphone-wallpaper-ilikewallpaper_com_200.jpg");
                    imgArrayList.add("https://r1.ilikewallpaper.net/iphone-wallpapers/download/28761/Apple-Logo-Window-Dark-Broken-iphone-wallpaper-ilikewallpaper_com_200.jpg");
                    imgArrayList.add("https://r1.ilikewallpaper.net/iphone-wallpapers/download-105173/worm's-eye-view-of-sewer-lid_200.jpg");
                    imgArrayList.add("https://r1.ilikewallpaper.net/iphone-wallpapers/download/81160/closeup-photo-of-red-and-black-lighted-signage-iphone-wallpaper-ilikewallpaper_com_200.jpg");
                    imgArrayList.add("https://r1.ilikewallpaper.net/iphone-wallpapers/download/25146/Asia-At-Night-Earth-Space-Dark-iphone-wallpaper-ilikewallpaper_com_200.jpg");
                    imgArrayList.add("https://r1.ilikewallpaper.net/iphone-wallpapers/download/17850/World-Map-Dark-iphone-wallpaper-ilikewallpaper_com_200.jpg");
                    imgArrayList.add("https://r1.ilikewallpaper.net/iphone-wallpapers/download/15756/Dark-Link-iphone-wallpaper-ilikewallpaper_com_200.jpg");
                    imgArrayList.add("https://r1.ilikewallpaper.net/iphone-wallpapers/download/24794/Dark-Night-Sky-Silent-Wide-Mountain-Star-Shining-iphone-wallpaper-ilikewallpaper_com_200.jpg");
                    imgArrayList.add("https://r1.ilikewallpaper.net/iphone-wallpapers/download/38857/Night-life-iphone-wallpaper-ilikewallpaper_com_200.jpg");
                    imgArrayList.add("https://r1.ilikewallpaper.net/iphone-wallpapers/download-108640/person-in-black-hoodie_200.jpg");

                    Intent i = new Intent(holder.imageView.getContext(), ExpandCategory.class);
                    i.putExtra("imagelist", imgArrayList);
                    holder.imageView.getContext().startActivity(i);


                } else if (titlelist.get(position).equals("Nature")) {
                    ArrayList<String> imgArrayList = new ArrayList<>();
                    imgArrayList.add("https://www.teahub.io/photos/full/200-2000607_nature-phone-wallpaper-4k.jpg");
                    imgArrayList.add("https://swall.teahub.io/photos/small/3-30467_forest-phone-wallpaper-4k.jpg");
                    imgArrayList.add("https://swall.teahub.io/photos/small/323-3236109_nature-mobile-wallpaper-4k.jpg");
                    imgArrayList.add("https://swall.teahub.io/photos/small/28-287766_4k-wallpaper-4k-wallpaper-phone-nature.jpg");
                    imgArrayList.add("https://wallpapercave.com/wp/wp6869861.jpg");
                    imgArrayList.add("https://wallpapercave.com/wp/wp9012506.jpg");
                    imgArrayList.add("https://wallpapercave.com/wp/wp5227476.jpg");
                    imgArrayList.add("https://wallpapercave.com/wp/wp8227082.jpg");
                    imgArrayList.add("https://images.pexels.com/photos/799443/pexels-photo-799443.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500");

                    Intent i = new Intent(holder.imageView.getContext(), ExpandCategory.class);
                    i.putExtra("imagelist", imgArrayList);
                    holder.imageView.getContext().startActivity(i);


                } else if (titlelist.get(position).equals("Devotional")) {
                    ArrayList<String> imgArrayList = new ArrayList<>();
                    imgArrayList.add("https://wallpapercave.com/wp/wp4775401.jpg");
                    imgArrayList.add("https://wallpapercave.com/wp/wp4974346.jpg");
                    imgArrayList.add("https://wallpapercave.com/wp/wp5357773.jpg");
                    imgArrayList.add("https://wallpapercave.com/wp/wp5344265.jpg");
                    imgArrayList.add("https://wallpapercave.com/wp/wp4415642.jpg");
                    imgArrayList.add("https://wallpapercave.com/wp/wp5217151.jpg");
                    imgArrayList.add("https://swall.teahub.io/photos/small/21-213156_devotional-wallpaper-for-mobile-hindu-god-wallpaper-hd.jpg");
                    imgArrayList.add("https://www.mordeo.org/files/uploads/2019/03/Giant-Buddha-Statue-Tawang-4K-Ultra-HD-Mobile-Wallpaper-283x503.jpg");
                    imgArrayList.add("https://www.mordeo.org/files/uploads/2019/03/Buddha-Statue-Tawang-4K-Ultra-HD-Mobile-Wallpaper-283x503.jpg");
                    imgArrayList.add("https://www.mordeo.org/files/uploads/2019/02/Cross-Sunset-Hill-4K-Ultra-HD-Mobile-Wallpaper-283x503.jpg");

                    Intent i = new Intent(holder.imageView.getContext(), ExpandCategory.class);
                    i.putExtra("imagelist", imgArrayList);
                    holder.imageView.getContext().startActivity(i);

                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return titlelist.size();
    }

    public static class MyCategory extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView title;

        public MyCategory(@NonNull @NotNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image);
            title = itemView.findViewById(R.id.title);

        }
    }
}
