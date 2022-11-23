package com.example.a20221121_michaelcasalinuovo_nycschools.retrofit;

import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import com.example.a20221121_michaelcasalinuovo_nycschools.activity.AdditionalInfoActivity;
import com.example.a20221121_michaelcasalinuovo_nycschools.activity.MainActivity;
import com.example.a20221121_michaelcasalinuovo_nycschools.adapter.SchoolsItemAdapter;
import com.example.a20221121_michaelcasalinuovo_nycschools.model.AdditionalInfoModel;
import com.example.a20221121_michaelcasalinuovo_nycschools.model.SchoolNycModel;
import com.example.a20221121_michaelcasalinuovo_nycschools.utils.AppUtils;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Network {

    public static void getNycSchool(NycResponse nycResponse) {
        Call<List<SchoolNycModel>> call = RetrofitClient.getInstance().getMyApi().getNycSchoolList();
        call.enqueue(new Callback<List<SchoolNycModel>>() {
            @Override
            public void onResponse(Call<List<SchoolNycModel>> call, Response<List<SchoolNycModel>> response) {
                List<SchoolNycModel> nycSchoolList = response.body();
                nycResponse.nycModelList(nycSchoolList);
            }

            @Override
            public void onFailure(Call<List<SchoolNycModel>> call, Throwable t) {
                nycResponse.nycListFailure(t.getMessage());
            }

        });
    }

    public static void getAdditionalInfo(NycResponse nycResponse, String dbn) {
        Call<List<AdditionalInfoModel>> call = RetrofitClient.getInstance().getMyApi().getAdditionalInfoList();
        call.enqueue(new Callback<List<AdditionalInfoModel>>() {
            @Override
            public void onResponse(Call<List<AdditionalInfoModel>> call, Response<List<AdditionalInfoModel>> response) {
                List<AdditionalInfoModel> additionalInfoModelList = response.body();
                nycResponse.additionalInfoModelList(additionalInfoModelList, dbn);
            }

            @Override
            public void onFailure(Call<List<AdditionalInfoModel>> call, Throwable t) {
                nycResponse.additionalInfoFailure(t.getMessage());
            }
        });
    }

    public interface NycResponse {
        void nycModelList(List<SchoolNycModel> schoolNycModelList);

        void nycListFailure(String errorMsg);

        void additionalInfoModelList(List<AdditionalInfoModel> additionalInfoModelList, String dbn);

        void additionalInfoFailure(String errorMsg);
    }
}
