package com.animation.walpaper4k.adpters;

import android.app.WallpaperManager;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.animation.walpaper4k.R;
import com.animation.walpaper4k.FullWallpaper;
import com.bumptech.glide.Glide;
import com.chootdev.blurimg.BlurImage;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;

public class PagerAdapter extends androidx.viewpager.widget.PagerAdapter {
    FullWallpaper fullWallpaper;
    ArrayList<String> allImageList;

    public PagerAdapter(FullWallpaper fullWallpaper, ArrayList<String> allImageList) {
        this.allImageList = allImageList;
        this.fullWallpaper = fullWallpaper;

    }

    @Override
    public int getCount() {
        return allImageList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, final int position) {
        View view = LayoutInflater.from(fullWallpaper).inflate(R.layout.pager_adapter_item, container, false);
        ImageView imageView;
        ImageView simpleImg;
        ImageView share;
        ImageView setwalpaper;
        ImageView download;
        simpleImg = view.findViewById(R.id.simpleImg);
        imageView = view.findViewById(R.id.blurimage);
        share = view.findViewById(R.id.share);
        download = view.findViewById(R.id.download);
        setwalpaper = view.findViewById(R.id.set_walpaper);

        Glide.with(fullWallpaper).load(allImageList.get(position)).into(simpleImg);
        BlurImage.withContext(fullWallpaper)
                .blurFromUri(allImageList.get(position))
                .into(imageView);

        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new ShareImg().execute(allImageList.get(position));

            }
        });
        download.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DownloadImage().execute(allImageList.get(position));
            }
        });
        setwalpaper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new SetWalpaper().execute(allImageList.get(position));

            }
        });

        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }


    class DownloadImage extends AsyncTask<String, Void, Bitmap> {


        @Override
        protected void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);
            Toast.makeText(fullWallpaper, "Done Download", Toast.LENGTH_SHORT).show();

        }

        @Override
        protected Bitmap doInBackground(String... urls) {
            try {


                URL url = new URL(urls[0]);
                HttpURLConnection connection = null;

                connection = (HttpURLConnection) url.openConnection();
                connection.connect();

                InputStream inputStream = null;

                inputStream = connection.getInputStream();

                Bitmap myBitmap = BitmapFactory.decodeStream(inputStream);
                Bitmap icon = myBitmap;
                ByteArrayOutputStream bytes = new ByteArrayOutputStream();
                icon.compress(Bitmap.CompressFormat.JPEG, 100, bytes);
                int time = (int) System.currentTimeMillis();
                ;
                File f = new File(Environment.getExternalStorageDirectory() + "Walpaper 4k" + time + "myimage" + ".jpg");
                try {
                    f.createNewFile();
                    FileOutputStream fo = new FileOutputStream(f);
                    fo.write(bytes.toByteArray());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Toast.makeText(fullWallpaper, "Download Succesful", Toast.LENGTH_SHORT).show();
            } catch (Exception e) {
                e.printStackTrace();
            }


            return null;
        }
    }

    class ShareImg extends AsyncTask<String, Void, Bitmap> {
        @Override
        protected void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);
            Toast.makeText(fullWallpaper, "Share Succesful", Toast.LENGTH_SHORT).show();

        }

        @Override
        protected Bitmap doInBackground(String... urls) {
            try {


                URL url = new URL(urls[0]);
                HttpURLConnection connection = null;

                connection = (HttpURLConnection) url.openConnection();


                connection.connect();

                InputStream inputStream = null;

                inputStream = connection.getInputStream();

                Bitmap myBitmap = BitmapFactory.decodeStream(inputStream);
                Bitmap b = myBitmap;
                Intent share = new Intent(Intent.ACTION_SEND);
                share.setType("Image/jpeg");
                share.setType("text/html");
                share.putExtra(Intent.EXTRA_TEXT, "shre body");


                ByteArrayOutputStream bytes = new ByteArrayOutputStream();
                b.compress(Bitmap.CompressFormat.JPEG, 100, bytes);
                String path = MediaStore.Images.Media.insertImage(fullWallpaper.getContentResolver(), b, "Title", null);
                Uri imageUri = Uri.parse(path);
                share.putExtra(Intent.EXTRA_STREAM, imageUri);
                fullWallpaper.startActivity(Intent.createChooser(share, "Select"));


            } catch (Exception e) {
                e.printStackTrace();
            }


            return null;
        }
    }

    class SetWalpaper extends AsyncTask<String, Void, Bitmap> {
        Random random;
        int var;

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);
            Toast.makeText(fullWallpaper, "Walpaper set Succesful", Toast.LENGTH_SHORT).show();

        }

        @Override
        protected Bitmap doInBackground(String... urls) {
            random = new Random();
            var = random.nextInt(10000);

            try {


                URL url = new URL(urls[0]);
                HttpURLConnection connection = null;

                connection = (HttpURLConnection) url.openConnection();


                connection.connect();

                InputStream inputStream = null;

                inputStream = connection.getInputStream();

                Bitmap myBitmap = BitmapFactory.decodeStream(inputStream);
                WallpaperManager myWallpaper = WallpaperManager.getInstance(fullWallpaper.getApplicationContext());
                try {
                    myWallpaper.setBitmap(myBitmap);

                } catch (IOException e) {
                    e.printStackTrace();
                }


            } catch (Exception e) {
                e.printStackTrace();
            }


            return null;
        }
    }

}
