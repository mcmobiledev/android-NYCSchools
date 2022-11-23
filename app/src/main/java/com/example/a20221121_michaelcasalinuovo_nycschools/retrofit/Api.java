package com.example.a20221121_michaelcasalinuovo_nycschools.retrofit;

import com.example.a20221121_michaelcasalinuovo_nycschools.model.AdditionalInfoModel;
import com.example.a20221121_michaelcasalinuovo_nycschools.model.SchoolNycModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.GET;

public interface Api {

    String BASE_URL = "https://data.cityofnewyork.us/resource/";

    @GET("s3k6-pzi2.json")
    Call<List<SchoolNycModel>> getNycSchoolList();

    @GET("f9bf-2cp4.json")
    Call<List<AdditionalInfoModel>> getAdditionalInfoList();
}
