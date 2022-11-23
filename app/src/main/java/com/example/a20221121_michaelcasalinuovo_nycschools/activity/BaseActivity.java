package com.example.a20221121_michaelcasalinuovo_nycschools.activity;

import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.kaopiz.kprogresshud.KProgressHUD;

public class BaseActivity extends AppCompatActivity {

    private KProgressHUD kProgressHUD;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    public void showProgressBar(Boolean isShow){
        if (kProgressHUD == null){
            kProgressHUD = KProgressHUD.create(this)
                    .setStyle(KProgressHUD.Style.SPIN_INDETERMINATE)
                    .setLabel("Loading")
                    .setMaxProgress(100);
        }

        if (isShow)
            kProgressHUD.show();
        else
            kProgressHUD.dismiss();
    }

    public void showAlertMessage(String message){
        new AlertDialog.Builder(this)
                .setMessage(message)
                .setCancelable(false)
                .setPositiveButton("ok", (dialog, which) -> {
                    // Whatever...
                }).show();
    }
}
