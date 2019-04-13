package com.example.fd.ldl;


import com.example.fd.ldl.Model.City;
import com.example.fd.ldl.Model.User;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface LDLService {

    @POST("auth/login")
    Call<User>getUserToken(@Body User user);

    @GET("api/city")
    Call<ArrayList<City>> getCity();

    @POST("api/city")
    Call<City>addCity(@Header("Authorization")String token,@Body City city);

}
