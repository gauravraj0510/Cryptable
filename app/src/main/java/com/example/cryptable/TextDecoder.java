package com.example.cryptable;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class TextDecoder extends AppCompatActivity {

    EditText enterText;
    TextView decryptedText;
    Button decryptBtn, copyTextBtn;
    ClipboardManager clipboardManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_decoder);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setTitle("Text Decryption");
        actionBar.show();

        enterText = findViewById(R.id.enter_enctext_editText);
        decryptedText = findViewById(R.id.tv_decrypted_txt);
        decryptBtn = findViewById(R.id.decrypt_btn);
        copyTextBtn = findViewById(R.id.copy_txt_btn_dec);
        clipboardManager = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);

        decryptBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(TextDecoder.this, "Working", Toast.LENGTH_SHORT).show();
            }
        });
        copyTextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(TextDecoder.this, "Working", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void dec(View view){
        String temp = enterText.getText().toString();
        String rv = DecodeText.decText(temp);
        decryptedText.setText(rv);
    }

    public void copyDec(View view){
        String data = decryptedText.getText().toString().trim();
        if(!data.isEmpty()){
            ClipData temp = ClipData.newPlainText("text", data);
            clipboardManager.setPrimaryClip(temp);
            Toast.makeText(this, "Copied to clipboard!", Toast.LENGTH_SHORT).show();
        }
    }

}