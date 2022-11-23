package com.example.a20221121_michaelcasalinuovo_nycschools.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.a20221121_michaelcasalinuovo_nycschools.R;
import com.example.a20221121_michaelcasalinuovo_nycschools.utils.AppUtils;

public class AdditionalInfoActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_additional_info);

        Intent intent = getIntent();
        String satSchoolName = intent.getStringExtra(AppUtils.SCHOOL_NAME);
        String satMathScore = intent.getStringExtra(AppUtils.MATH_AVG);
        String satReadingScore = intent.getStringExtra(AppUtils.READING_AVG);
        String satWritingScore = intent.getStringExtra(AppUtils.WRITING_AVG);

        TextView tvSchoolName = findViewById(R.id.tc_school_name);
        ImageView ivBackBtn = findViewById(R.id.ivBack);
        TextView tvMathScore = findViewById(R.id.tv_math_scores);
        TextView tvReading = findViewById(R.id.tv_reading_scores);
        TextView tvWriting = findViewById(R.id.tv_writing_scores);

        tvSchoolName.setText(satSchoolName);
        tvMathScore.setText(satMathScore);
        tvReading.setText(satReadingScore);
        tvWriting.setText(satWritingScore);

        ivBackBtn.setOnClickListener(view -> finish());


    }
}