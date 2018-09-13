package com.example.peter.workcomplain;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.peter.workcomplain.Utils.ApiUtils;
import com.example.peter.workcomplain.retrofit.ApiService;
import com.example.peter.workcomplain.retrofit.model.ComplainModel;
import com.example.peter.workcomplain.retrofit.model.LoginResponse;
import com.pixplicity.easyprefs.library.Prefs;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostComplainActivity extends AppCompatActivity {
    @BindView(R.id.anonymous)
    CheckBox checkAnonym;
    @BindView(R.id.showidentity)
    CheckBox checkIdentify;
    @BindView(R.id.edcomplainTitle)
    EditText edComplainTitle;
    @BindView(R.id.edcomplainbody)
    EditText edComplainBody;
    @BindView(R.id.loadingProgress)
    ProgressBar mProgressBar;
    String post_type, complain_title,complain_body,department;
    ApiService mApiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_complain);
        ButterKnife.bind(this);
        mApiService = ApiUtils.getApiService();
    }



    @OnClick({R.id.anonymous, R.id.showidentity})
    void checkboxAction(View view) {
        switch (view.getId()) {
            case R.id.showidentity:
                getPostOption();
                break;
            case R.id.anonymous:
                getPostOption();
                break;
        }
    }


    void getPostOption() {
        if (checkIdentify.isChecked()) {
            checkIdentify.setChecked(true);
            checkAnonym.setChecked(false);
            post_type = Prefs.getString("user","");
        } else if (checkAnonym.isChecked()) {
            checkIdentify.setChecked(false);
            checkAnonym.setChecked(true);
            post_type = "Anonymous";
        } else {
            checkAnonym.setChecked(false);
            checkIdentify.setChecked(false);
        }
    }

    private boolean isvalidInputs(){
        boolean valid;
        complain_title = edComplainTitle.getText().toString().trim();
        complain_body = edComplainBody.getText().toString().trim();

        if(!complain_title.isEmpty() && !complain_body.isEmpty()){
            valid = true;
        }else {
            Toast.makeText(this, "All Fields Required", Toast.LENGTH_SHORT).show();
            valid = false;
        }
        return valid;
    }

    @OnClick(R.id.btpostcomplain)void postComplain(){
    if (isvalidInputs()){
        mProgressBar.setVisibility(View.VISIBLE);
        ComplainModel complainModel = new ComplainModel();
        complainModel.setIdentity(post_type);
        complainModel.setComplainTitle(complain_title);
        complainModel.setComplainBody(complain_body);
        complainModel.setDepartment(Prefs.getString("department",""));
        complainModel.setUser(Prefs.getString("email",""));
        mApiService.postComplain(complainModel).enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                if (response.isSuccessful()){
                    if (response.body().getResultMsg().equals("success")){
                        mProgressBar.setVisibility(View.GONE);
                        Toast.makeText(PostComplainActivity.this, "Complain Posted Successfully", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(PostComplainActivity.this,DashboardActivity.class));
                    }else {
                        Toast.makeText(PostComplainActivity.this, "Problem Posting Complain", Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {

            }
        });
    }
    }
}
