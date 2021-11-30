package com.tsybulnik.gamememory;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.webkit.WebView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SplashActivity extends AppCompatActivity {
    private TextView tvSplash;
    private WebView webView;
    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_main);
        tvSplash = findViewById(R.id.tvSplash);
        webView = findViewById(R.id.webView);


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
                    if (geo.equals("RU")) {
                        webView.setVisibility(View.VISIBLE);
                        webView.loadUrl("https://ru.wikipedia.org/wiki/");
                    } else if (geo.equals("UA")) {
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                Intent intent = new Intent(SplashActivity.this, LevelActivity.class);
                                startActivity(intent);
                            }
                        }, 700);
                    }
                }
            }

            @Override
            public void onFailure(Call<Model> call, Throwable t) {

            }
        });




    }
}