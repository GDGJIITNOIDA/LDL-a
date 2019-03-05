package com.example.fd.ldl;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import static android.graphics.Color.rgb;

public class IntroScreen extends AppCompatActivity {

    private ViewPager iSlot;

    private Button donateButton;

    private Button logInButton;
    private LinearLayout iDot;

    private SliderAdapter sliderAdapter;

    private TextView[] mDOt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro_screen);

        iSlot= (ViewPager) findViewById(R.id.viewPager);
        sliderAdapter= new SliderAdapter(this);
        donateButton= (Button) findViewById(R.id.DonateButton);
        logInButton= findViewById(R.id.LogInButton);


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
