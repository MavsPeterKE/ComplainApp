package com.example.peter.workcomplain;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.peter.workcomplain.Utils.ApiUtils;
import com.example.peter.workcomplain.retrofit.ApiService;
import com.example.peter.workcomplain.retrofit.model.ComplainReportResponse;
import com.pixplicity.easyprefs.library.Prefs;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.peter.workcomplain.Utils.ApiUtils.*;

public class RecordActivity extends AppCompatActivity {

    @BindView(R.id.count)
    TextView tvReportingCount;
    @BindView(R.id.summons)
    TextView tvSummonsCount;
    @BindView(R.id.warnings)
    TextView tvWarningCount;
    @BindView(R.id.done)
    TextView tvClearedCount;
    @BindView(R.id.reportProgress)
    ProgressBar mProgressBar;
    ApiService mApiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record);
        ButterKnife.bind(this);
        mProgressBar.setVisibility(View.VISIBLE);


        getReport();
    }

    private void getReport(){
        getApiService().getReport(Prefs.getString("email","")).enqueue(new Callback<ComplainReportResponse>() {



            @Override
            public void onResponse(Call<ComplainReportResponse> call,
                                   Response<ComplainReportResponse> response) {
                if (response.isSuccessful()){
                    if (response.body() !=null){
                        mProgressBar.setVisibility(View.GONE);
                        tvReportingCount.setText("Reported : "+response.body().getReportedTimes()+" Times");
                        tvWarningCount.setText(response.body().getWarnings()+" Warnings");
                        tvSummonsCount.setText(response.body().getSummons()+" Summons");
                        tvClearedCount.setText(response.body().getCleared()+" Complain (s) Cleared");

                    }
                }
            }

            @Override
            public void onFailure(Call<ComplainReportResponse> call, Throwable t) {

            }
        });
    }
}
