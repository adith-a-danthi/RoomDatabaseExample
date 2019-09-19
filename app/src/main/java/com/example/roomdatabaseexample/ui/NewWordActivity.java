package com.example.roomdatabaseexample.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.roomdatabaseexample.R;
import com.google.android.material.button.MaterialButton;

public class NewWordActivity extends AppCompatActivity {

    public static final String EXTRA_REPLY = "Intent";
    private EditText mNewWordEt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_word);
        mNewWordEt = findViewById(R.id.newWordEt);

        final MaterialButton button = findViewById(R.id.saveBtn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent replyIntent = new Intent();
                if(TextUtils.isEmpty(mNewWordEt.getText())){
                    setResult(RESULT_CANCELED,replyIntent);
                } else {
                    String word = mNewWordEt.getText().toString();
                    replyIntent.putExtra(EXTRA_REPLY,word);
                    setResult(RESULT_OK,replyIntent);
                }
                finish();
            }
        });
    }
}
