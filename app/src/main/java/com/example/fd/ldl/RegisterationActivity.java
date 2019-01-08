package com.example.fd.ldl;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class RegisterationActivity extends AppCompatActivity {

    private EditText userName, userPassword, userNumber, userCamp;
    private Button regBtn;
    private TextView goBack;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registeration);
        setUI();
        regBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });

    }

    private void setUI()
    {
        userName= (EditText) findViewById(R.id.regName);
        userPassword= (EditText) findViewById(R.id.regPass);
        userNumber= (EditText) findViewById(R.id.regPhone);
        userCamp= (EditText) findViewById(R.id.regCamp);
        regBtn= (Button) findViewById(R.id.regSub);
        goBack= (TextView) findViewById(R.id.regGoBack);




    }
}
