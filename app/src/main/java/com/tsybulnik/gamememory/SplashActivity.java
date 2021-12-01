package com.tsybulnik.gamememory;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.tsybulnik.gamememory.network.ApiService;
import com.tsybulnik.gamememory.network.Model;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SplashActivity extends AppCompatActivity {
    private WebView webView;
    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_main);
        webView = findViewById(R.id.webView);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(getString(R.string.base_url_geo))
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiService apiService = retrofit.create(ApiService.class);
        Call<Model> call = apiService.loadData();
        call.enqueue(new Callback<Model>() {
            @Override
            public void onResponse(Call<Model> call, Response<Model> response) {
                if (response.body()!=null) {
                    String geo = response.body().getCountry();
                    if (geo.equals(getString(R.string.country_ru))) {
                        webView.setVisibility(View.VISIBLE);
                        webView.loadUrl(getString(R.string.wiki));
                    } else if (geo.equals(getString(R.string.country_ua))) {
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                Intent intent = new Intent(SplashActivity.this, LevelActivity.class);
                                startActivity(intent);
                            }
                        }, 1000);
                    }
                }
            }
            @Override
            public void onFailure(Call<Model> call, Throwable t) {
                Log.d("MyLog",t.toString());

            }
        });
    }
}