package com.example.layoutpractice;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.ColorSpace;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.animation.AlphaAnimation;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class TalkingActivity extends Activity {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.talking);
        ImageButton call_end_button = findViewById(R.id.call_end_button);
        ImageView talking_Image = findViewById(R.id.talking_image);
        AlphaAnimation feedIn_am = new AlphaAnimation(0,1);
        AlphaAnimation feedIn_name = new AlphaAnimation(0,1);
        feedIn_am.setDuration(800);
        feedIn_name.setDuration(250);
        talking_Image.setColorFilter(0xaaff0000);
        talking_Image.setColorFilter(Color.argb(80,255,0,0));
        talking_Image.startAnimation(feedIn_am);
        Intent intent = getIntent();
        String name = intent.getStringExtra("TALKING");
        int iconId = intent.getIntExtra("ICON",R.drawable.human);
        TextView nameText = findViewById(R.id.talking_name);
        talking_Image.setImageResource(iconId);


        new CountDownTimer(2500,1000){
            @Override
            public void onTick(long l) {}

            @Override
            public void onFinish() {
                talking_Image.setColorFilter(null);
                nameText.setText(name);
                nameText.startAnimation(feedIn_name);
            }
        }.start();
        call_end_button.setOnClickListener(view -> startActivity(new Intent(this,SelectModeActivity.class)));
    }
}
