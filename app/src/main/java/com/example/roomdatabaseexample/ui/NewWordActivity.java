package com.example.roomdatabaseexample.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import com.example.roomdatabaseexample.R;
import com.google.android.material.button.MaterialButton;

import static com.example.roomdatabaseexample.ui.MainActivity.EXTRA_DATA_ID;
import static com.example.roomdatabaseexample.ui.MainActivity.EXTRA_DATA_UPDATE_WORD;

public class NewWordActivity extends AppCompatActivity {

    public static final String EXTRA_REPLY = "Intent";
    public static final String EXTRA_REPLY_ID = "Reply Id";

    private EditText mWordEt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_word);

        mWordEt = findViewById(R.id.newWordEt);
        int id = -1;

        final Bundle extras = getIntent().getExtras();

        if(extras != null){
            String word = extras.getString(EXTRA_DATA_UPDATE_WORD, "");
            if(!word.isEmpty()){
                mWordEt.setText(word);
                mWordEt.setSelection(word.length());
                mWordEt.requestFocus();
            }
        }

        final MaterialButton button = findViewById(R.id.saveBtn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent replyIntent = new Intent();
                if(TextUtils.isEmpty(mWordEt.getText())){
                    //No new word enetered
                    setResult(RESULT_CANCELED,replyIntent);
                } else {
                    String word = mWordEt.getText().toString();
                    replyIntent.putExtra(EXTRA_REPLY,word);

                    if (extras != null && extras.containsKey(EXTRA_DATA_ID)){
                        int id = extras.getInt(EXTRA_DATA_ID,-1);
                        if(id!= -1){
                            replyIntent.putExtra(EXTRA_REPLY_ID,id);
                        }
                    }

                    setResult(RESULT_OK,replyIntent);
                }
                finish();
            }
        });
    }
}
