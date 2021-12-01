package com.tsybulnik.gamememory;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.appsflyer.AppsFlyerConversionListener;
import com.appsflyer.AppsFlyerLib;

import java.util.Map;
import java.util.Objects;

public class LevelActivity extends AppCompatActivity {
    private Button btLevelSimple;
    private Button btLevelNormal;
    private Button btLevelHard;
    private Button btData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level);
        btLevelSimple = findViewById(R.id.btLevelEasy);
        btLevelNormal = findViewById(R.id.tv_developer_surname);
        btLevelHard = findViewById(R.id.tv_);
        btLevelSimple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LevelActivity.this, GameSimpleActivity.class);
                startActivity(intent);

            }
        });
        btLevelNormal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LevelActivity.this, GameMiddleActivity.class);
                startActivity(intent);
            }
        });
        btLevelHard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LevelActivity.this, GameHardActivity.class);
                startActivity(intent);
            }
        });
        btData = findViewById(R.id.bt_data);
        btData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LevelActivity.this,InfoActivity.class);
                startActivity(intent);

            }
        });
        Log.e("MyLog", "Conversion attribute: " );
    }
    // exit from app
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        moveTaskToBack(true);
    }
}