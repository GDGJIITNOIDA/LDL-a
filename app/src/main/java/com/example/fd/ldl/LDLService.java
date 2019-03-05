package com.example.fd.ldl;

import com.example.fd.ldl.Model.User;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

interface LDLService {

    @POST("auth/login")
    Call<User>getUserToken(@Body User user);

}
