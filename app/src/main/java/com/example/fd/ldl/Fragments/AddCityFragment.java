package com.example.fd.ldl.Fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.fd.ldl.LDLService;
import com.example.fd.ldl.Model.City;
import com.example.fd.ldl.Model.User;
import com.example.fd.ldl.R;
import com.example.fd.ldl.utils.retrofit.ApiClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddCityFragment extends Fragment {
    EditText etState, etCity;
    Button btnSaveCity;
    String cityName,state;
    User currentUser=null;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_add_city, container, false);

        etCity = rootView.findViewById(R.id.etCity);
        etState = rootView.findViewById(R.id.etState);
        btnSaveCity =rootView.findViewById(R.id.btnSaveCity);

        btnSaveCity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cityName=etCity.getText().toString();
                state=etState.getText().toString();

                City newCity=new City(cityName,state);
                addCity(newCity);
            }
        });
        return rootView;
    }

    public void addCity(City city) {
        if (cityName.equals("")) {
            Toast.makeText(getContext(), "Please Enter City Name", Toast.LENGTH_SHORT).show();
        } else if (state.equals("")) {
            Toast.makeText(getContext(), "Plaese Enter State", Toast.LENGTH_SHORT).show();
        } else {
            LDLService api = ApiClient.getApi().create(LDLService.class);
            //retrofit2.Call<City> call = api.addCity("token 87bbfbdad99f95ae5362bd95fcda586e07458694",city);
            retrofit2.Call<City> call = api.addCity("token " + User.getCurrentUser(getContext()).getToken(), city);
            call.enqueue(new Callback<City>() {
                @Override
                public void onResponse(Call<City> call, Response<City> response) {
                    Log.i("dsf", "post city: " + response.code());
                    if (response.code() == 201) {
                        Toast.makeText(getContext(), "City Added Successfully", Toast.LENGTH_SHORT).show();
                    } else if (response.code() == 400) {
                        Toast.makeText(getContext(), "City with this name already exists", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<City> call, Throwable t) {
                    Log.i("dsf", " post error: " + t);

                }
            });
            Toast.makeText(getContext(), "ok", Toast.LENGTH_SHORT).show();
        }
    }
}
