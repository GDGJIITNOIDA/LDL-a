package com.example.fd.ldl;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import java.util.Calendar;

public class MemberActivity extends AppCompatActivity {

    private DatePickerDialog.OnDateSetListener dBirth;
    private DatePickerDialog.OnDateSetListener dJoin;
    private TextView t_dJoin;
    private TextView t_dDOB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member);

        Button bsTeam = findViewById(R.id.btn_team);
        Button bsCollege= findViewById(R.id.btn_colg);
        Button bsRole= findViewById(R.id.btn_role);
        Button bsDay= findViewById(R.id.btn_day);
        t_dJoin= findViewById(R.id.dJoin);
        t_dDOB= findViewById(R.id.dDOB);
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


        //CALENDER CODES GO HERE

        t_dJoin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cal= Calendar.getInstance();
                int year= cal.get(Calendar.YEAR);
                int month= cal.get(Calendar.MONTH);
                int day= cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog= new DatePickerDialog(MemberActivity.this,
                        android.R.style.Theme_Holo_Dialog_MinWidth,
                        dJoin,year,month,day

            );
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
            });

        t_dDOB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cal= Calendar.getInstance();
                int year= cal.get(Calendar.YEAR);
                int month= cal.get(Calendar.MONTH);
                int day= cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog= new DatePickerDialog(MemberActivity.this,
                        android.R.style.Theme_Holo_Dialog_MinWidth,
                        dBirth,year,month,day

                );
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });



        dBirth=  new DatePickerDialog.OnDateSetListener()
        {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                //               Log.d(BATTERY_SERVIC, "ondate :"+month);
                month=month+1;
                String jDate= day+"/"+month+"/"+ year;

                t_dDOB.setText(jDate);

            }




        };

       dJoin=  new DatePickerDialog.OnDateSetListener()
        {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
 //               Log.d(BATTERY_SERVIC, "ondate :"+month);
                month=month+1;
                String jDate= day+"/"+month+"/"+ year;

                t_dJoin.setText(jDate);

            }




    };

       //CALENDER CODES END HERE
}
}

