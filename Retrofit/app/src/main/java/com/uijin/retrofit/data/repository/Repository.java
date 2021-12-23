package com.uijin.retrofit.data.repository;

import android.util.Log;
import android.widget.Toast;

import com.uijin.retrofit.MainActivity;
import com.uijin.retrofit.data.model.GetUserResponse;
import com.uijin.retrofit.data.model.User;

// 6. Repository 클래스 만들기(데이터 소스로부터 Model을 가져오는 것을 추상화)
public class Repository {
    private RemoteDataSource remoteDataSource = new RemoteDataSource();

    /** 회원가입 */
    public void signup(User user, GetDataCallback<GetUserResponse> callback) {
        remoteDataSource.signup(user, callback);
    }

    /** Get User */
    public void getUser(int userId, GetDataCallback<GetUserResponse> callback) {
        remoteDataSource.getUser(userId, callback);
    }

    /** Patch User */
    public void patchUser(int userId, User user, GetDataCallback<GetUserResponse> callback) {
        remoteDataSource.patchUser(userId, user, callback);
    }

    /** Delete User */
    public void deleteUser(int userId, GetDataCallback<GetUserResponse> callback) {
        remoteDataSource.deleteUser(userId, callback);
    }

    /** 응답 콜백 */
    public interface GetDataCallback<T> {
        void onSuccess(T data);
        void onFailure(Throwable throwable);
    }
}
