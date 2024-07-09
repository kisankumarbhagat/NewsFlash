package com.example.newsflash;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsControllerCompat;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Ensure the splash screen activity uses the full screen
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);

        setContentView(R.layout.activity_splash);

        // Apply window insets to avoid overlapping system bars
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            WindowInsetsCompat insetsCompat = ViewCompat.getRootWindowInsets(v);
            if (insetsCompat != null) {
                int left = insetsCompat.getInsets(WindowInsetsCompat.Type.systemBars()).left;
                int top = insetsCompat.getInsets(WindowInsetsCompat.Type.systemBars()).top;
                int right = insetsCompat.getInsets(WindowInsetsCompat.Type.systemBars()).right;
                int bottom = insetsCompat.getInsets(WindowInsetsCompat.Type.systemBars()).bottom;
                v.setPadding(left, top, right, bottom);
            }
            return WindowInsetsCompat.CONSUMED;
        });

        // Delay for 3 seconds and then start MainActivity
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashActivity.this, MainActivity.class));
                finish();
            }
        }, 3000);
    }
}
