package com.tsybulnik.gamememory;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LevelActivity extends AppCompatActivity {
    private Button btLevelSimple;
    private Button btLevelNormal;
    private Button btLevelHard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level);
        btLevelSimple = findViewById(R.id.btLevelEasy);
        btLevelNormal = findViewById(R.id.btLevelNormal);
        btLevelHard = findViewById(R.id.btLevelHard);
        btLevelSimple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LevelActivity.this, GameSimpleActivity.class);
//                intent.putExtra("level",6);
                startActivity(intent);

            }
        });
        btLevelNormal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LevelActivity.this, GameMiddleActivity.class);
//                intent.putExtra("level",6);
                startActivity(intent);
//
            }
        });
        btLevelHard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LevelActivity.this, GameHardActivity.class);
//                intent.putExtra("level",6);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        moveTaskToBack(true);
    }
}