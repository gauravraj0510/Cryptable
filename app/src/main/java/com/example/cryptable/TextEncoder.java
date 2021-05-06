package com.example.cryptable;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class TextEncoder extends AppCompatActivity {

    EditText enterText;
    TextView encryptedText;
    Button encryptBtn, copyTextBtn;
    ClipboardManager clipboardManager;
    final String secretKey = "ssshhhhhhhhhhh!!!!";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_encoder);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setTitle("Text Encryption");
        actionBar.show();

        enterText = findViewById(R.id.enter_text_editText);
        encryptedText = findViewById(R.id.tv_encrypted_txt);
        encryptBtn = findViewById(R.id.encrypt_btn);
        copyTextBtn = findViewById(R.id.copy_text_btn);
        clipboardManager = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);

    }

    public void enc(View view){
        String temp = enterText.getText().toString();
        String rv = AESText.encrypt(temp, secretKey);
        encryptedText.setText(rv);
        closeKeyboard();
    }

    public void copy(View view){
        String data = encryptedText.getText().toString().trim();
        if(!data.isEmpty()){
            ClipData temp = ClipData.newPlainText("text", data);
            clipboardManager.setPrimaryClip(temp);
            Toast.makeText(this, "Copied to clipboard!", Toast.LENGTH_SHORT).show();
        }
    }

    private void closeKeyboard() {
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }
}