package com.livepyeongchang.a12three.livepyeongchang.DataManager;

import android.util.Log;

import com.livepyeongchang.a12three.livepyeongchang.Controller.TimeManager;
import com.livepyeongchang.a12three.livepyeongchang.DataManager.Data.MainF_VO.MainVO;
import com.livepyeongchang.a12three.livepyeongchang.DataManager.Data.MainF_VO.ScheVO;
import com.livepyeongchang.a12three.livepyeongchang.DataManager.Remote.RetrofitService;
import com.livepyeongchang.a12three.livepyeongchang.Model.Model_Main;
import com.livepyeongchang.a12three.livepyeongchang.View.BaseActivity;
import com.livepyeongchang.a12three.livepyeongchang.View.MainActivity;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainF_DataManager {

    private MainVO mainVO;
    private List<ScheVO> scheVO;
    private TimeManager timeManager;

    public void loadData(){

        final boolean isKorean = MainActivity.isKorean;

        timeManager = new TimeManager();

        RetrofitService retrofitService = RetrofitService.retrofit_main.create(RetrofitService.class);
        Call<MainVO> call = retrofitService.getMainData();
        call.enqueue(new Callback<MainVO>() {
            @Override
            public void onResponse(Call<MainVO> call, Response<MainVO> response) {
                mainVO = response.body();
                scheVO = mainVO.getSchedule();

                for(int i=0; i<scheVO.size(); i++){
                    String matchName = scheVO.get(i).getGame();

                    String edetail = scheVO.get(i).getEdgame();
                    String estadium = scheVO.get(i).getEstadium();
                    String detail = scheVO.get(i).getDgame();
                    String stadium = scheVO.get(i).getStadium();

                    String matchEname = scheVO.get(i).getEgame();
                    String date = scheVO.get(i).getDay();
                    String time = scheVO.get(i).getTime();
                    String sex = scheVO.get(i).getSex();
                    boolean medalFlag = false;
                    if(scheVO.get(i).getMedal() == 1){ medalFlag = true; }

                    if(date.equals(timeManager.addDate(-1, true))){
                        BaseActivity.yesterdayArr.add(new Model_Main(matchName, matchEname, detail, edetail, stadium, estadium, sex, date, time, medalFlag));
                    } else if(date.equals(timeManager.addDate(0, true))){
                        BaseActivity.todayArr.add(new Model_Main(matchName, matchEname, detail, edetail, stadium, estadium, sex, date, time, medalFlag));
                        Log.v("today", String.valueOf(i));
                    } else if(date.equals(timeManager.addDate(1, true))){
                        BaseActivity.tomorrowArr.add(new Model_Main(matchName, matchEname, detail, edetail, stadium, estadium, sex, date, time, medalFlag));
                    }

                }

            }

            @Override
            public void onFailure(Call<MainVO> call, Throwable t) {

            }
        });

    }

}
