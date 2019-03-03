package com.example.fd.ldl;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

interface LDLService {

    @POST("auth/login")
    Call<User> getUserToken(@Body User user);

}
