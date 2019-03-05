package com.example.fd.ldl;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fd.ldl.Model.User;
import com.example.fd.ldl.utils.retrofit.ApiClient;

import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class LogInActivity extends AppCompatActivity {

    private TextView signUp;
    EditText usernameEditText, passwordEditText;
    Button loginButton;
    Retrofit retrofit;
    //SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        signUp=findViewById(R.id.regNew);
        usernameEditText = findViewById(R.id.editText);
        passwordEditText = findViewById(R.id.editText2);
        loginButton = findViewById(R.id.button);

        //sharedPreferences = getSharedPreferences("User Details",MODE_PRIVATE);


        retrofit = ApiClient.getApi();

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(LogInActivity.this, RegisterationActivity.class));
                LogInActivity.this.finish();

            }
        });

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = usernameEditText.getText().toString();
                String password = passwordEditText.getText().toString();


                User user = new User(username,password);
                LDLService api = ApiClient.getApi().create(LDLService.class);
                retrofit2.Call<User> call = api.getUserToken(user);
                call.enqueue(new Callback<User>() {
                    @Override
                    public void onResponse(retrofit2.Call<User> call, Response<User> response) {
                        Log.i("dsf","post: "+response.body().toString());
                        Toast.makeText(LogInActivity.this, response.body().toString(), Toast.LENGTH_SHORT).show();
                        User u = response.body();
//                        SharedPreferences.Editor editor = sharedPreferences.edit();
//                        editor.putString("token",u.getToken());
//                        editor.putString("email",u.getEmail());
//                        editor.putString("first name",u.getFirstName());
//                        editor.putString("last name",u.getLastName());
//                        editor.putString("password",u.getPassword());
//                        editor.putInt("role",u.getRole());
//                        editor.putInt("user id",u.getUserId());
//                        editor.putString("username",u.getUsername());
//                        editor.commit();
                        User user=new User();
                        user.setRole(u.getRole());
                        user.setEmail(u.getEmail());
                        user.setFirstName(u.getFirstName());
                        user.setLastName(u.getLastName());
                        user.setPassword(u.getPassword());
                        user.setToken(u.getToken());
                        user.setUserId(u.getUserId());
                        user.setUsername(u.getUsername());
                        Log.i("dsf","post token: "+u.getToken());
                        User.setAsCurrentUser(LogInActivity.this, user);
                    }

                    @Override
                    public void onFailure(retrofit2.Call<User> call, Throwable t) {
                        Log.i("dsf"," post error: "+t);
                    }

                });

            }
        });

    }

}
