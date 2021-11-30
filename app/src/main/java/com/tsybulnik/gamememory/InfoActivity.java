package com.tsybulnik.gamememory;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings;

public class InfoActivity extends AppCompatActivity {
    private TextView developerName;
    private TextView developerSurname;
    private TextView model;
    private TextView manufactura;
    private TextView versionAndroid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        model = findViewById(R.id.tv_model);
        manufactura = findViewById(R.id.tv_manufacture);
        versionAndroid = findViewById(R.id.tv_release);
        developerName = findViewById(R.id.tv_developer_name);
        developerSurname = findViewById(R.id.tv_developer_surname);

        FirebaseRemoteConfig mFirebaseRemoteConfig = FirebaseRemoteConfig.getInstance();
        FirebaseRemoteConfigSettings configSettings = new FirebaseRemoteConfigSettings.Builder()
                .setMinimumFetchIntervalInSeconds(3600)
                .build();
        mFirebaseRemoteConfig.setConfigSettingsAsync(configSettings);



        String name = mFirebaseRemoteConfig.getString("developer_name");
        Toast.makeText(InfoActivity.this,name,Toast.LENGTH_LONG).show();
        String surname = mFirebaseRemoteConfig.getString("developer_surname");
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
    }
}