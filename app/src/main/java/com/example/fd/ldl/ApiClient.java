package com.example.fd.ldl;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    static final String  BASE_URL="http://139.59.19.170:6565/";
    public static Retrofit retrofit=null;

    public static Retrofit getApi(){
        if(retrofit==null){
            retrofit=new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

}
