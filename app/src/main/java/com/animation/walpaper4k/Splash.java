package com.animation.walpaper4k;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.widget.Toast;

import com.gun0912.tedpermission.PermissionListener;

import java.io.File;
import java.util.List;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_activity);
        PermissionListener permissionlistener = new PermissionListener() {
            @Override
            public void onPermissionGranted() {
                
                Toast.makeText(Splash.this, "Permission Granted", Toast.LENGTH_SHORT).show();
                File f= new File(Environment.getExternalStorageDirectory()+"/Walpaper 4k");

                if (!f.exists()){
                    f.mkdirs();
                    f.mkdir();}
            }

            @Override
            public void onPermissionDenied(List<String> deniedPermissions) {
                Toast.makeText(Splash.this, "Permission Denied\n" + deniedPermissions.toString(), Toast.LENGTH_SHORT).show();
            }


        };


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent i = new Intent( Splash.this, CategoryWallpaper.class);
                startActivity(i);
                finish();
            }
        },2000);

        }
    }
