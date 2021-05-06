package com.example.cryptable;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ConstraintLayout imageEncrypt, textEncrypt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        imageEncrypt = findViewById(R.id.img_encrypt);
        textEncrypt = findViewById(R.id.text_encrypt);

        imageEncrypt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent imgIntent = new Intent(MainActivity.this, ImageEncrypt.class);
                startActivity(imgIntent);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            }
        });

        textEncrypt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent textIntent = new Intent(MainActivity.this, TextEncrypt.class);
                startActivity(textIntent);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            }
        });
    }
}