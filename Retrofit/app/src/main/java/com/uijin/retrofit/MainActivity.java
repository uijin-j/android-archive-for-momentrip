package com.uijin.retrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.uijin.retrofit.data.model.GetUserResponse;
import com.uijin.retrofit.data.model.User;
import com.uijin.retrofit.data.repository.Repository;

// Retrofit2 사용하기
public class MainActivity extends AppCompatActivity {
    private  static final String TAG = "myLog";
    Repository repository; // 네트워크 요청을 위한 객체

    EditText idInput;
    EditText idInput2;
    EditText nameInput;
    EditText emailInput;
    EditText passwordInput;
    EditText nickInput;

    Button postButton;
    Button getButton;
    Button patchButton;
    Button deleteButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        repository = new Repository();

        idInput = findViewById(R.id.id_input);
        idInput2 = findViewById(R.id.id_input2);
        emailInput = findViewById(R.id.email_input);
        passwordInput = findViewById(R.id.password_input);
        nameInput = findViewById(R.id.name_input);
        nickInput = findViewById(R.id.nick_input);

        postButton = findViewById(R.id.post_button);
        getButton = findViewById(R.id.get_button);
        patchButton = findViewById(R.id.patch_button);
        deleteButton = findViewById(R.id.delete_button);

        // 생성 버튼
        postButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                User user = new User(emailInput.getText().toString(), passwordInput.getText().toString() , nickInput.getText().toString(), nameInput.getText().toString(), null,null);
                repository.signup(user, new Repository.GetDataCallback<GetUserResponse>() {
                    @Override
                    public void onSuccess(GetUserResponse data) {
                        Toast.makeText(getApplicationContext(),"회원가입 완료!", Toast.LENGTH_LONG).show();
                        idInput2.setText(Integer.toString(data.getUser().getId()));
                        emailInput.setText(data.getUser().getEmail());
                        passwordInput.setText(data.getUser().getPassword());
                        nameInput.setText(data.getUser().getName());
                        nickInput.setText(data.getUser().getNick());
                    }

                    @Override
                    public void onFailure(Throwable throwable) {
                        Log.d(TAG, throwable.toString());
                        Toast.makeText(getApplicationContext(),"조회 실패!", Toast.LENGTH_LONG).show();
                    }
                });
            }
        });

        // 수정 버튼
        patchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = Integer.parseInt(idInput2.getText().toString());
                User user = new User(emailInput.getText().toString(), passwordInput.getText().toString() , nickInput.getText().toString(), nameInput.getText().toString(), null,null);
                repository.patchUser(id, user, new Repository.GetDataCallback<GetUserResponse>() {
                    @Override
                    public void onSuccess(GetUserResponse data) {
                        Log.d("myLog", "onSuccess!");
                        Toast.makeText(getApplicationContext(),"수정 완료!: " + data.isSuccess(), Toast.LENGTH_LONG).show();
                        idInput2.setText("");
                        emailInput.setText("");
                        passwordInput.setText("");
                        nameInput.setText("");
                        nickInput.setText("");
                    }

                    @Override
                    public void onFailure(Throwable throwable) {
                        Log.d(TAG, throwable.toString());
                        Toast.makeText(getApplicationContext(),"수정 실패!", Toast.LENGTH_LONG).show();
                    }
                });
            }
        });

        // 조회 버튼
        getButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = Integer.parseInt(idInput.getText().toString());
                repository.getUser(id, new Repository.GetDataCallback<GetUserResponse>() {
                    @Override
                    public void onSuccess(GetUserResponse data) {
                        Toast.makeText(getApplicationContext(),"조회 성공!", Toast.LENGTH_LONG).show();
                        idInput2.setText(Integer.toString(data.getUser().getId()));
                        emailInput.setText(data.getUser().getEmail());
                        passwordInput.setText(data.getUser().getPassword());
                        nameInput.setText(data.getUser().getName());
                        nickInput.setText(data.getUser().getNick());
                    }

                    @Override
                    public void onFailure(Throwable throwable) {
                        Log.d(TAG, throwable.toString());
                        Toast.makeText(getApplicationContext(),"조회 실패!", Toast.LENGTH_LONG).show();
                    }
                });
            }
        });

        // 삭제 버튼
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = Integer.parseInt(idInput.getText().toString());
                repository.deleteUser(id, new Repository.GetDataCallback<GetUserResponse>() {
                    @Override
                    public void onSuccess(GetUserResponse data) {
                        Toast.makeText(getApplicationContext(),"삭제 성공!", Toast.LENGTH_LONG).show();
                        idInput2.setText(null);
                        emailInput.setText(null);
                        passwordInput.setText(null);
                        nameInput.setText(null);
                        nickInput.setText(null);
                    }

                    @Override
                    public void onFailure(Throwable throwable) {
                        Log.d(TAG, throwable.toString());
                        Toast.makeText(getApplicationContext(),"삭제 실패!", Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
    }
}