package com.example.fd.ldl;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MemberActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_add_member);

        Button bsTeam = findViewById(R.id.btn_team);
        Button bsCollege= findViewById(R.id.btn_colg);
        Button bsRole= findViewById(R.id.btn_role);
        Button bsDay= findViewById(R.id.btn_day);

        bsTeam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                BottomSheetTeam bsTeam= new BottomSheetTeam();
                bsTeam.show(getSupportFragmentManager(), "bsTeam");
            }
        });


        bsCollege.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                BottomSheetCollege bsCollege= new BottomSheetCollege();
                bsCollege.show(getSupportFragmentManager(), "bsCollege");
            }
        });


        bsRole.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                BottomSheetRole bsRole= new BottomSheetRole();
                bsRole.show(getSupportFragmentManager(), "bsRole");
            }
        });


        bsDay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                BottomSheetDay bsDay= new BottomSheetDay();
                bsDay.show(getSupportFragmentManager(), "bsDay");
            }
        });
    }
}
