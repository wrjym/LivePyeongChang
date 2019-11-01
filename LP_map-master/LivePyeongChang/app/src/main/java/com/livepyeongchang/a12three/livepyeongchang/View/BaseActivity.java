package com.livepyeongchang.a12three.livepyeongchang.View;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import com.livepyeongchang.a12three.livepyeongchang.Controller.Constants;
import com.livepyeongchang.a12three.livepyeongchang.DataManager.MainF_DataManager;
import com.livepyeongchang.a12three.livepyeongchang.DataManager.TourF_DataManager;
import com.livepyeongchang.a12three.livepyeongchang.DataManager.TourP_DataManager;
import com.livepyeongchang.a12three.livepyeongchang.Model.Model_Main;
import com.livepyeongchang.a12three.livepyeongchang.Model.Model_Pic;
import com.livepyeongchang.a12three.livepyeongchang.Model.Model_Tour;
import com.livepyeongchang.a12three.livepyeongchang.R;

import java.util.ArrayList;
import java.util.List;

public class BaseActivity extends AppCompatActivity {

    public static List<Model_Main> yesterdayArr;
    public static List<Model_Main> todayArr;
    public static List<Model_Main> tomorrowArr;

    public static List<Model_Tour> tourArr;
    public static List<Model_Pic> picArr;

    public static TourF_DataManager tourF_dataManager;
    TourP_DataManager tourP_dataManager;

    TextView tv_language_check;
    boolean isKorean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        tv_language_check = (TextView) findViewById(R.id.tv_language_check);
        isKorean = false;
        if(tv_language_check.getText().equals("한국어")){
            isKorean = true;
        } else { isKorean = false; }

        ConnectivityManager cm = (ConnectivityManager) this.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo ni = cm.getActiveNetworkInfo();

        if(ni != null && ni.isConnected()) {

            yesterdayArr = new ArrayList<>();
            todayArr = new ArrayList<>();
            tomorrowArr = new ArrayList<>();

            tourArr = new ArrayList<>();
            picArr = new ArrayList<>();

            String language = Constants.SERVICE_LANGUAGE_US;
            if (isKorean) language = Constants.SERVICE_LANGUAGE_KOR;

            MainF_DataManager mainF_dataManager = new MainF_DataManager();
            mainF_dataManager.loadData();

            tourF_dataManager = new TourF_DataManager();
            tourF_dataManager.loadData(Constants.SERVICE_THEMEPARK + language, "20");
            tourF_dataManager.loadData(Constants.SERVICE_BEACH + language, "20");
            tourF_dataManager.loadData(Constants.SERVICE_AMUSEMENTPARK + language, "20");
            tourF_dataManager.loadData(Constants.SERVICE_CULTURE + language, "20");
            tourF_dataManager.loadData(Constants.SERVICE_RUINS + language, "20");

            tourP_dataManager = new TourP_DataManager();
            tourP_dataManager.loadData(isKorean);


            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {

                @Override
                public void run() {

                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    intent.putExtra("isKorean", isKorean);
                    startActivity(intent);
                    finish();

                }
            }, 4000);
        } else{

            Toast.makeText(this, "네트워크 연결을 확인해주십시오.", Toast.LENGTH_LONG).show();

        }
    }
}
