package com.example.fd.ldl;


import com.example.fd.ldl.Model.Camp;
import com.example.fd.ldl.Model.City;
import com.example.fd.ldl.Model.College;
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

    @GET("api/college")
    Call<ArrayList<College>> getCollege();

    @POST("api/college")
    Call<College> addCollege(@Header("Authorization")String token,@Body College college);

    @GET("api/camp")
    Call<ArrayList<City>> getCamp();

    @POST("api/camp")
    Call<Camp> addCamp(@Header("Authorization")String token, @Body Camp camp);

    @GET("api/team")
    Call<ArrayList<City>> getTeam();

    @POST("api/team")
    Call<City> addTeam(@Header("Authorization")String token);

}
