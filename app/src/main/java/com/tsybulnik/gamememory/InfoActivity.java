package com.tsybulnik.gamememory;

import static androidx.core.content.PackageManagerCompat.LOG_TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.appsflyer.AppsFlyer2dXConversionCallback;
import com.appsflyer.AppsFlyerConversionListener;
import com.appsflyer.AppsFlyerLib;
import com.appsflyer.attribution.AppsFlyerRequestListener;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings;

import java.util.Map;
import java.util.Objects;

public class InfoActivity extends AppCompatActivity {
    private TextView developerName;
    private TextView developerSurname;
    private TextView model;
    private TextView manufactura;
    private TextView versionAndroid;
    private TextView tv_appsFluersId;
    private TextView tv_appsFluersParametrs;
    Map<String, Object> conversionData = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);


        model = findViewById(R.id.tv_model);
        manufactura = findViewById(R.id.tv_manufacture);
        versionAndroid = findViewById(R.id.tv_release);
        developerName = findViewById(R.id.tv_developer_name);
        developerSurname = findViewById(R.id.tv_developer_surname);
        tv_appsFluersId = findViewById(R.id.tv_appsFluer_id);
        tv_appsFluersParametrs = findViewById(R.id.tv_appsFluer_parameters);


        AppsFlyerLib.getInstance().start(this);
        AppsFlyerLib.getInstance().setDebugLog(true);

         AppsFlyerLib  appsFlyer = AppsFlyerLib.getInstance().init(getString(R.string.key_appsFluers), new AppsFlyerConversionListener() {
            @Override
            public void onConversionDataSuccess(Map<String, Object> map) {
                tv_appsFluersParametrs.setText("onConversionDataSuccess");
                for (String attrName : map.keySet())
                    Log.d("MyLog", "Conversion attribute: " + attrName + " = " + map.get(attrName));
                Toast.makeText(InfoActivity.this,"Conversion attribute: ",Toast.LENGTH_LONG).show();
                String status = Objects.requireNonNull(map.get("af_status")).toString();
                if(status.equals("Non-organic")){
                    if( Objects.requireNonNull(map.get("is_first_launch")).toString().equals("true")){
                        Log.d("MyLog","Conversion: First Launch");
                    } else {
                        Log.d("MyLog","Conversion: Not First Launch");
                    }
                } else {
                    Log.d("MyLog", "Conversion: This is an organic install.");
                }
                conversionData = map;
                Toast.makeText(InfoActivity.this,conversionData.toString(),Toast.LENGTH_LONG).show();

            }
            @Override
            public void onConversionDataFail(String s) {
                tv_appsFluersParametrs.setText("onConversionDataFail");
                String s1= s;

            }
            @Override
            public void onAppOpenAttribution(Map<String, String> map) {
                tv_appsFluersParametrs.setText("onAppOpenAttribution");
            }
            @Override
            public void onAttributionFailure(String s) {
                tv_appsFluersParametrs.setText(s);
            }
        }, this);
        appsFlyer.start(this);



        String appsFlyerId = AppsFlyerLib.getInstance().getAppsFlyerUID(this);


        FirebaseRemoteConfig mFirebaseRemoteConfig = FirebaseRemoteConfig.getInstance();
        FirebaseRemoteConfigSettings configSettings = new FirebaseRemoteConfigSettings.Builder()
                .setMinimumFetchIntervalInSeconds(3600)
                .build();
        mFirebaseRemoteConfig.setConfigSettingsAsync(configSettings);


        String name = mFirebaseRemoteConfig.getString("developer_name");
        String surname = mFirebaseRemoteConfig.getString("developer_surname");

        // for real-time
        mFirebaseRemoteConfig.fetchAndActivate().addOnCompleteListener(new OnCompleteListener<Boolean>() {
            @Override
            public void onComplete(@NonNull Task<Boolean> task) {
            }
        });

        developerName.setText(name);
        developerSurname.setText(surname);
        model.setText(Build.MODEL);
        manufactura.setText(Build.MANUFACTURER);
        versionAndroid.setText(android.os.Build.VERSION.RELEASE);
        tv_appsFluersId.setText(appsFlyerId);


    }
}