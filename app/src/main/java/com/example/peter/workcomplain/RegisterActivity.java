package com.example.peter.workcomplain;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import com.example.peter.workcomplain.Utils.ApiUtils;
import com.example.peter.workcomplain.retrofit.ApiService;
import com.example.peter.workcomplain.retrofit.model.LoginResponse;
import com.example.peter.workcomplain.retrofit.model.UserModel;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity {
    @BindView(R.id.edname)
    EditText edname;
    @BindView(R.id.eddepartment)
    EditText eddepartment;
    @BindView(R.id.edemail)
    EditText edemail;
    @BindView(R.id.edpass)
    EditText edpassword;
    @BindView(R.id.edconfirmpass)
    EditText edcpassword;
    String name, email, password, department, cpass;
    ApiService mApiService;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);
        mApiService = ApiUtils.getApiService();
    }

    @OnClick(R.id.btnregister)
    void register() {
        if (isInputValid()) {
            UserModel user = new UserModel();
            user.setName(name);
            user.setPassword(password);
            user.setDepartment(department);
            user.setEmail(email);
            mApiService.registerUser(user).enqueue(new Callback<LoginResponse>() {
                @Override
                public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                    LoginResponse loginResponse = response.body();
                    String mgh= "";
                    if (response.isSuccessful()) {
                        if (response.body().getResultMsg().equals("success")) {
                            Toast.makeText(RegisterActivity.this, "registered Successfully",
                                    Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(RegisterActivity.this,MainActivity.class));
                        } else {
                            Toast.makeText(RegisterActivity.this, "Problem Registering", Toast
                                    .LENGTH_SHORT).show();
                        }
                    }
                }

                @Override
                public void onFailure(Call<LoginResponse> call, Throwable t) {

                }
            });
        } else {
            Toast.makeText(this, "All Fields Required", Toast.LENGTH_SHORT).show();
        }
    }

    private boolean isInputValid() {
        boolean result;
        name = edname.getText().toString().trim();
        department = eddepartment.getText().toString().trim();
        email = edemail.getText().toString().trim();
        password = edpassword.getText().toString().trim();
        cpass = edcpassword.getText().toString().trim();

        if (!name.isEmpty() && !department.isEmpty() && !email.isEmpty() && !password.isEmpty() &&
                !cpass.isEmpty()) {
            if (password.matches(cpass)) {
                result = true;
            } else {
                Toast.makeText(this, "Password Do not match", Toast.LENGTH_SHORT).show();
                result = false;
            }
        } else {
            result = false;
        }
        return result;
    }
}
