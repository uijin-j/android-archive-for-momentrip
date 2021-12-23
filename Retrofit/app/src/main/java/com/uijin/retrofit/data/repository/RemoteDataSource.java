package com.uijin.retrofit.data.repository;

import android.util.Log;

import com.uijin.retrofit.data.model.GetUserResponse;
import com.uijin.retrofit.data.model.User;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

// 5. Retrofit 인스턴스 생성
public class RemoteDataSource {
    private Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://52.79.158.158:3000/momentrip/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    private Webservice service = retrofit.create(Webservice.class);

    /** 회원가입 */
    public void signup(User user, Repository.GetDataCallback<GetUserResponse> callback) {
        // 인터페이스 구현
        service.signup(user).enqueue(new Callback<GetUserResponse>() {
            @Override
            public void onResponse(Call<GetUserResponse> call, Response<GetUserResponse> response) {
                if (response.isSuccessful()) {
                    callback.onSuccess(response.body());
                }
            }
            @Override
            public void onFailure(Call<GetUserResponse> call, Throwable t) {
                callback.onFailure(t);
            }
        });
    }

    /** Get User */
    public void getUser(int userId, Repository.GetDataCallback<GetUserResponse> callback) {
        // 인터페이스 구현
        service.getUser(userId).enqueue(new Callback<GetUserResponse>() {
            @Override
            public void onResponse(Call<GetUserResponse> call, Response<GetUserResponse> response) {
                if (response.isSuccessful()) { callback.onSuccess(response.body()); }
            }
            @Override
            public void onFailure(Call<GetUserResponse> call, Throwable t) { callback.onFailure(t); }
        });
    }

    /** Patch User */
    public void patchUser(int userId, User user, Repository.GetDataCallback<GetUserResponse> callback) {
        // 인터페이스 구현
        service.patchUser(userId, user).enqueue(new Callback<GetUserResponse>() {
            @Override
            public void onResponse(Call<GetUserResponse> call, Response<GetUserResponse> response) {
                if (response.isSuccessful()) { callback.onSuccess(response.body()); }
            }
            @Override
            public void onFailure(Call<GetUserResponse> call, Throwable t) { callback.onFailure(t); }
        });
    }

    /** Delete User */
    public void deleteUser(int userId, Repository.GetDataCallback<GetUserResponse> callback) {
        // 인터페이스 구현
        service.deleteUser(userId).enqueue(new Callback<GetUserResponse>() {
            @Override
            public void onResponse(Call<GetUserResponse> call, Response<GetUserResponse> response) {
                if (response.isSuccessful()) { callback.onSuccess(response.body()); }
            }
            @Override
            public void onFailure(Call<GetUserResponse> call, Throwable t) { callback.onFailure(t); }
        });
    }
}
