package com.example.fd.ldl;

import android.support.design.widget.BottomSheetDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AddCollegeActivity extends AppCompatActivity implements BottomSheetCity.BottomSheetListener {
    private TextView tvCity;
    Button btnCity , btnSave ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_college);
        btnCity = findViewById(R.id.btnCity);
        btnSave = findViewById(R.id.btnSave);
        tvCity = findViewById(R.id.tvCity);
        btnCity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BottomSheetCity bottomsheet = new BottomSheetCity();
                bottomsheet.show(getSupportFragmentManager(),"bottomSheetCity");

            }
        });

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    @Override
    public void onButtonClicked(String text) {
        tvCity.setText(text);
    }
}
