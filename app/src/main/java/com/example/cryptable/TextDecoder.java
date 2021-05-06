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

public class TextDecoder extends AppCompatActivity {

    EditText enterText;
    TextView decryptedText;
    Button decryptBtn, copyTextBtn;
    ClipboardManager clipboardManager;
    final String secretKey = "ssshhhhhhhhhhh!!!!";

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

    }

    public void dec(View view){
        String temp = enterText.getText().toString();
        String rv = AESText.decrypt(temp, secretKey);
        decryptedText.setText(rv);
        closeKeyboardD();
    }

    public void copyDec(View view){
        String data = decryptedText.getText().toString().trim();
        if(!data.isEmpty()){
            ClipData temp = ClipData.newPlainText("text", data);
            clipboardManager.setPrimaryClip(temp);
            Toast.makeText(this, "Copied to clipboard!", Toast.LENGTH_SHORT).show();
        }
    }

    private void closeKeyboardD() {
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }
}