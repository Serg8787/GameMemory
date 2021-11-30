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
        Log.d("MyLog", "Conversion attribute: ");

//        AppsFlyerLib appsflyer = AppsFlyerLib.getInstance();
        AppsFlyerLib appsflyer = AppsFlyerLib.getInstance().init("cBSeCBmTkWgWXb4cPFvgHn", null, this);
        AppsFlyerLib.getInstance().start(this);
        String id = appsflyer.getAppsFlyerUID(this);
        AppsFlyerConversionListener appsFlyerConversionListener = new AppsFlyerConversionListener() {
            @Override
            public void onConversionDataSuccess(Map<String, Object> map) {
                for (String attrName : map.keySet())
                    Log.d("MyLog", "Conversion attribute: " + attrName + " = " + map.get(attrName));
                String status = Objects.requireNonNull(map.get("af_status")).toString();
                Toast.makeText(LevelActivity.this, status, Toast.LENGTH_LONG).show();
                if (status.equals("Organic")) {
                    // Business logic for Organic conversion goes here.
                } else {
                    // Business logic for Non-organic conversion goes here.
                }

            }

            @Override
            public void onConversionDataFail(String s) {
                Log.d("MyLog", "error getting conversion data: " + s);

            }

            @Override
            public void onAppOpenAttribution(Map<String, String> map) {

            }

            @Override
            public void onAttributionFailure(String s) {
                Log.d("MyLog", "error onAttributionFailure : " + s);

            }
        };


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
//                Toast.makeText(LevelActivity.this, id, Toast.LENGTH_LONG).show();
//                String phoneModel = android.os.Build.MODEL;
//                Toast.makeText(LevelActivity.this,phoneModel , Toast.LENGTH_LONG).show();
//
//                // Android version
//                String androidVersion = android.os.Build.VERSION.RELEASE;
//                Toast.makeText(LevelActivity.this, androidVersion, Toast.LENGTH_LONG).show();
//
//                String man = Build.MANUFACTURER;
//                Toast.makeText(LevelActivity.this,man, Toast.LENGTH_LONG).show();
//
//                String model = Build.MODEL;
//                Toast.makeText(LevelActivity.this,model, Toast.LENGTH_LONG).show();
                Intent intent = new Intent(LevelActivity.this,InfoActivity.class);
                startActivity(intent);

            }
        });
    }
    // exit

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        moveTaskToBack(true);
    }
}