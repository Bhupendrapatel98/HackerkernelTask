package com.example.hackerkerneltask.Network;

import com.example.hackerkerneltask.model.LoginRequest;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface PostRequest {

    @POST("login")
    Call<JsonObject> login(@Body LoginRequest request);

}
