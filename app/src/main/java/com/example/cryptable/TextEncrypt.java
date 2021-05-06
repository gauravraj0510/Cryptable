package com.example.cryptable;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TextEncrypt extends AppCompatActivity {

    Button encrypt, decrypt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_encrypt);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setTitle("Crypt Text");
        actionBar.show();

        encrypt = findViewById(R.id.enc_text_btn);
        decrypt = findViewById(R.id.dec_text_btn);

        encrypt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent enc = new Intent(TextEncrypt.this, TextEncoder.class);
                startActivity(enc);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            }
        });

        decrypt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent dec = new Intent(TextEncrypt.this, TextDecoder.class);
                startActivity(dec);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            }
        });
    }
}