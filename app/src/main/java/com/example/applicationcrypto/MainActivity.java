package com.example.applicationcrypto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView loadingImage;
    private View whiteLine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadingImage = findViewById(R.id.images);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                loadingImage.setVisibility(View.GONE);

                Intent intent = new Intent(MainActivity.this, Basement.class);
                startActivity(intent);

                finish();
            }
        }, 3000); // 3 секунди затримки

        // Анімація обертання значка загрузки
        RotateAnimation rotateAnimation = new RotateAnimation(0, 360,
                Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f);
        rotateAnimation.setDuration(1000);
        rotateAnimation.setRepeatCount(Animation.INFINITE);
        loadingImage.startAnimation(rotateAnimation);

        // Анімація та метод білої полоски
        whiteLine = findViewById(R.id.whiteLine);

        whiteLine.setVisibility(View.VISIBLE);
        startAnimation();
    }
    private void startAnimation() { // Метод з анімацією білої полоски
        int screenWidth = getResources().getDisplayMetrics().widthPixels;

        Animation animation = new TranslateAnimation(
                0f, screenWidth,
                0f, 0f);

        animation.setDuration(3000);
        animation.setInterpolator(new LinearInterpolator());
        whiteLine.startAnimation(animation);
    }
}