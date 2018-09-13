package com.example.peter.workcomplain;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.peter.workcomplain.Utils.ApiUtils;
import com.example.peter.workcomplain.adapters.NotificationAdapter;
import com.example.peter.workcomplain.adapters.RecyclerAdapter;
import com.example.peter.workcomplain.retrofit.model.ComplainResponseModel;
import com.example.peter.workcomplain.retrofit.model.NotificationResponse;
import com.pixplicity.easyprefs.library.Prefs;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NotificationsActivity extends AppCompatActivity {
    @BindView(R.id.NotiicationList)
    RecyclerView mRecyclerView;
    @BindView(R.id.NotificationLoading)
    ProgressBar mProgressBar;
    NotificationAdapter mRecyclerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifications);
        ButterKnife.bind(this);
        mProgressBar.setVisibility(View.VISIBLE);
        mRecyclerView.setVisibility(View.GONE);
        mRecyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager =new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        getNotification();

    }

    private void getNotification(){
        ApiUtils.getApiService().getNoticationsReport(Prefs.getString("email","")).enqueue(new Callback<List<NotificationResponse>>() {
            @Override
            public void onResponse(Call<List<NotificationResponse>> call, Response<List<NotificationResponse>> response) {
                if (response.isSuccessful()){
                    List <NotificationResponse> list = response.body();
                    if (response.body().size()!=0){
                        mProgressBar.setVisibility(View.GONE);
                        mRecyclerView.setVisibility(View.VISIBLE);
                        mRecyclerAdapter = new NotificationAdapter(response.body(),NotificationsActivity.this);
                        mRecyclerView.setAdapter(mRecyclerAdapter);
                    }else {
                        Toast.makeText(NotificationsActivity.this, "No Notifications", Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<List<NotificationResponse>> call, Throwable t) {
                Toast.makeText(NotificationsActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }
}
