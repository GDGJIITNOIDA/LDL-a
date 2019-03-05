package com.example.fd.ldl;

import android.content.Intent;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

import static android.graphics.Color.rgb;

public class IntroScreen<timer, sTimer> extends AppCompatActivity {

    private ViewPager iSlot;
    private Button donateButton;
    private Button logInButton;
    private LinearLayout iDot;
    private SliderAdapter sliderAdapter;
    private TextView[] mDOt;
    int currentPage = 0;
    Timer timer;
    final long DELAY_MS = 300;//delay in milliseconds before task is to be executed
    final long PERIOD_MS = 3000;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro_screen);

        iSlot= (ViewPager) findViewById(R.id.viewPager);
        sliderAdapter= new SliderAdapter(this);
        donateButton= (Button) findViewById(R.id.DonateButton);
        logInButton= findViewById(R.id.LogInButton);

        final Handler handler = new Handler();
        final Runnable Update = new Runnable() {
            public void run() {
                if (currentPage == 3) {
                    currentPage = 0;
                }
                iSlot.setCurrentItem(currentPage++, true);
            }
        };

        timer = new Timer(); // This will create a new Thread

        timer.schedule(new TimerTask() { // task to be scheduled
            @Override
            public void run() {
                handler.post(Update);
            }
        }, DELAY_MS, PERIOD_MS);

        logInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(IntroScreen.this, LogInActivity.class));
                IntroScreen.this.finish();
            }
        });

       donateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                debugToast();
            }
        });
        iSlot.setAdapter(sliderAdapter);
    }
    void debugToast()
    {
        Toast.makeText(this,"Click", Toast.LENGTH_LONG).show();
    }

}
