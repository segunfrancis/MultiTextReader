package com.example.computer.multi_textreader;

import android.content.Intent;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TextActivity extends AppCompatActivity {

    @BindView(R.id.display_text)
    TextView displayText;

    @BindView(R.id.play_button)
    Button playButton;

    private TextToSpeech toSpeech;

    private String gottenText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        gottenText = intent.getStringExtra("text");
        displayText.setText(gottenText);

        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                readText();
            }
        });
    }

    private void readText() {
        toSpeech = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                toSpeech.setLanguage(Locale.UK);
                toSpeech.speak(gottenText, TextToSpeech.QUEUE_ADD, null);
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
        toSpeech.shutdown();
    }
}
