package com.uijin.retrofit.data.repository;

import com.uijin.retrofit.data.model.GetUserResponse;
import com.uijin.retrofit.data.model.User;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.Path;

// 4. Interface 정의
public interface Webservice {

    @POST("auth/signUp")
    Call<GetUserResponse> signup(@Body User user);

    @GET("user/select/id/{user_id}")
    Call<GetUserResponse> getUser(@Path("user_id") int userId);

    @PATCH("user/{user_id}")
    Call<GetUserResponse> patchUser(@Path("user_id") int userId, @Body User user);

    @DELETE("user/{user_id}")
    Call<GetUserResponse> deleteUser(@Path("user_id") int userId);
}