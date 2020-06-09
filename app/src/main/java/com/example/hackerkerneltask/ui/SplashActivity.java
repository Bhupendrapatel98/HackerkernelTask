package com.example.hackerkerneltask.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.provider.SyncStateContract;
import android.view.View;

import com.example.hackerkerneltask.Network.Constant;
import com.example.hackerkerneltask.R;
import com.fxn.stash.Stash;
import com.leo.simplearcloader.SimpleArcLoader;

public class SplashActivity extends AppCompatActivity {

    SimpleArcLoader simpleArcLoader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        simpleArcLoader = findViewById(R.id.loader);

        simpleArcLoader.start();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                simpleArcLoader.stop();
                simpleArcLoader.setVisibility(View.GONE);

                if (!Stash.getString("token").equals("")) {
                    startActivity(new Intent(SplashActivity.this, DashBoardActivity.class));
                    finish();

                    } else {
                        startActivity(new Intent(SplashActivity.this, MainActivity.class));
                        finish();
                    }
                }
            },2000);

        }
    }
