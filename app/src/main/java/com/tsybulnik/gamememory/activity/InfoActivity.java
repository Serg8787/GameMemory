package com.tsybulnik.gamememory.activity;

import static androidx.core.content.PackageManagerCompat.LOG_TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.appsflyer.AppsFlyerConversionListener;
import com.appsflyer.AppsFlyerLib;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings;
import com.tsybulnik.gamememory.R;

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

    public static final String LOG_TAG = "AppsFlyerOneLinkSimApp";
    public static final String DL_ATTRS = "dl_attrs";
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

        String afDevKey = getString(R.string.key_appsFluers);
        AppsFlyerLib appsflyer = AppsFlyerLib.getInstance();
        appsflyer.setMinTimeBetweenSessions(0);
        appsflyer.setDebugLog(true);

        AppsFlyerConversionListener conversionListener =  new AppsFlyerConversionListener() {
            @Override
            public void onConversionDataSuccess(Map<String, Object> conversionDataMap) {
                for (String attrName : conversionDataMap.keySet())
                    Log.d(LOG_TAG, "Conversion attribute: " + attrName + " = " + conversionDataMap.get(attrName));
                String status = Objects.requireNonNull(conversionDataMap.get("af_status")).toString();
                if(status.equals("Non-organic")){
                    if( Objects.requireNonNull(conversionDataMap.get("is_first_launch")).toString().equals("true")){
                        Log.d(LOG_TAG,"Conversion: First Launch");
                    } else {
                        Log.d(LOG_TAG,"Conversion: Not First Launch");
                    }
                } else {
                    Log.d(LOG_TAG, "Conversion: This is an organic install.");
                }
                conversionData = conversionDataMap;
                String con = conversionData.toString();
            }

            @Override
            public void onConversionDataFail(String errorMessage) {
                Log.d(LOG_TAG, "error getting conversion data: "+errorMessage);
                String er = errorMessage;
            }

            @Override
            public void onAppOpenAttribution(Map<String, String> attributionData) {
                Log.d(LOG_TAG, "onAppOpenAttribution: This is fake call.");
                String att = attributionData.toString();
            }

            @Override
            public void onAttributionFailure(String errorMessage) {
                Log.d(LOG_TAG, "error onAttributionFailure : " + errorMessage);
                String e = errorMessage;
            }
        };
        appsflyer.init(afDevKey, conversionListener, this);
        appsflyer.start(this);



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