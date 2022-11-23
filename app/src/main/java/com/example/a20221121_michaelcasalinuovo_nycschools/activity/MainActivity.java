package com.example.a20221121_michaelcasalinuovo_nycschools.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.a20221121_michaelcasalinuovo_nycschools.R;
import com.example.a20221121_michaelcasalinuovo_nycschools.adapter.SchoolsItemAdapter;
import com.example.a20221121_michaelcasalinuovo_nycschools.model.AdditionalInfoModel;
import com.example.a20221121_michaelcasalinuovo_nycschools.model.SchoolNycModel;
import com.example.a20221121_michaelcasalinuovo_nycschools.retrofit.Network;
import com.example.a20221121_michaelcasalinuovo_nycschools.retrofit.RetrofitClient;
import com.example.a20221121_michaelcasalinuovo_nycschools.utils.AppUtils;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends BaseActivity implements SchoolsItemAdapter.ItemClickListener, Network.NycResponse {

    RecyclerView recyclerView;
    AdditionalInfoModel findAdditionalInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.m_recycler);
        showProgressBar(true);
        Network.getNycSchool(this);
    }

    private void getAdditionalInfoData(String dbn) {
        findAdditionalInfo = null;

        if (AppUtils.additionalInfoModelList.size() == 0) {
            showProgressBar(true);
            Network.getAdditionalInfo(MainActivity.this, dbn);
        } else {
            for (int i = 0; i < AppUtils.additionalInfoModelList.size(); i++) {
                AdditionalInfoModel additionalInfoModel = AppUtils.additionalInfoModelList.get(i);
                if (additionalInfoModel.getDbn().equals(dbn)) {
                    Log.e("findDBN - > ", additionalInfoModel.getDbn());
                    findAdditionalInfo = additionalInfoModel;
                }
            }

            if (findAdditionalInfo == null) {
                showAlertMessage("Information not found against this school");
            }
            else {
                Intent intent = new Intent(MainActivity.this, AdditionalInfoActivity.class);
                intent.putExtra(AppUtils.SCHOOL_NAME, findAdditionalInfo.getSchool_name());
                intent.putExtra(AppUtils.MATH_AVG, findAdditionalInfo.getSat_math_avg_score());
                intent.putExtra(AppUtils.READING_AVG, findAdditionalInfo.getSat_critical_reading_avg_score());
                intent.putExtra(AppUtils.WRITING_AVG, findAdditionalInfo.getSat_writing_avg_score());

                startActivity(intent);
            }
        }
    }


    @Override
    public void onItemClick(SchoolNycModel schoolNycModel) {
        getAdditionalInfoData(schoolNycModel.getDbn());
    }

    @Override
    public void nycModelList(List<SchoolNycModel> schoolNycModelList) {
        SchoolsItemAdapter schoolsItemAdapter = new SchoolsItemAdapter(schoolNycModelList, MainActivity.this);
        recyclerView.setAdapter(schoolsItemAdapter);
        showProgressBar(false);
    }

    @Override
    public void nycListFailure(String errorMsg) {
        Toast.makeText(getApplicationContext(), "An error has occured " + errorMsg, Toast.LENGTH_LONG).show();
        showProgressBar(false);
    }

    @Override
    public void additionalInfoModelList(List<AdditionalInfoModel> additionalInfoModelList, String dbn) {
        showProgressBar(false);

        AppUtils.additionalInfoModelList = additionalInfoModelList;

        for (int i = 0; i < AppUtils.additionalInfoModelList.size(); i++) {
            AdditionalInfoModel additionalInfoModel = AppUtils.additionalInfoModelList.get(i);
            if (additionalInfoModel.getDbn().equals(dbn)) {
                Log.e("findDBN - > ", additionalInfoModel.getDbn());
                findAdditionalInfo = additionalInfoModel;
            }
        }

        if (findAdditionalInfo == null) {
            showAlertMessage("Information not found against this school");
        }
        else {
            Intent intent = new Intent(MainActivity.this, AdditionalInfoActivity.class);
            intent.putExtra(AppUtils.SCHOOL_NAME, findAdditionalInfo.getSchool_name());
            intent.putExtra(AppUtils.MATH_AVG, findAdditionalInfo.getSat_math_avg_score());
            intent.putExtra(AppUtils.READING_AVG, findAdditionalInfo.getSat_critical_reading_avg_score());
            intent.putExtra(AppUtils.WRITING_AVG, findAdditionalInfo.getSat_writing_avg_score());

            startActivity(intent);
        }
    }


    @Override
    public void additionalInfoFailure(String errorMsg) {
        Toast.makeText(getApplicationContext(), "An error has occured " + errorMsg, Toast.LENGTH_LONG).show();
        showProgressBar(false);
    }
}