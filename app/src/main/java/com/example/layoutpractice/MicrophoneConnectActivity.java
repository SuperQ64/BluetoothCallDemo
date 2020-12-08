package com.example.layoutpractice;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;

public class MicrophoneConnectActivity extends Activity {
    static final String TAG = "MICRO_PHONE_ACTIVITY";
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.microphone_connect);

        Button button = findViewById(R.id.button_microphone);
        button.setOnClickListener(view -> {
                startActivity(new Intent(this,SelectModeActivity.class));
        });
    }
}
