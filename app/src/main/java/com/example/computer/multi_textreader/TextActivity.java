package com.example.computer.multi_textreader;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TextActivity extends AppCompatActivity {

    @BindView(R.id.display_text)
    TextView displayText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        String gottenText = intent.getStringExtra("text");
        displayText.setText(gottenText);
    }
}
