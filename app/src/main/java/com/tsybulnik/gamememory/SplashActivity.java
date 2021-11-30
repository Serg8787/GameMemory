package com.tsybulnik.gamememory;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SplashActivity extends AppCompatActivity {
    private TextView tvSplash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_main);
        tvSplash = findViewById(R.id.tvSplash);


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://ipinfo.io/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiService apiService = retrofit.create(ApiService.class);
        Call<Model> call = apiService.loadData();
        call.enqueue(new Callback<Model>() {
            @Override
            public void onResponse(Call<Model> call, Response<Model> response) {
                if (response != null) {
                    String geo = response.body().getCountry();
                   if(geo.equals("RU")){

                   }
                }
            }

            @Override
            public void onFailure(Call<Model> call, Throwable t) {

            }
        });


        tvSplash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SplashActivity.this, LevelActivity.class);
                startActivity(intent);
            }
        });

//        String geo = response.body().getCountry();
//        Toast.makeText(SplashActivity.this,geo,Toast.LENGTH_LONG).show();
    }
}