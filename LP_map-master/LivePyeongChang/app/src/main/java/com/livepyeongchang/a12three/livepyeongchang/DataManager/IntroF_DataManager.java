package com.livepyeongchang.a12three.livepyeongchang.DataManager;

import com.livepyeongchang.a12three.livepyeongchang.DataManager.Data.IntroF_VO.IntroVO;
import com.livepyeongchang.a12three.livepyeongchang.DataManager.Data.IntroF_VO.ListVO;
import com.livepyeongchang.a12three.livepyeongchang.DataManager.Remote.RetrofitService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by kwakgee on 2017. 9. 6..
 */

public class IntroF_DataManager {

    private IntroVO introVO;
    public static List<ListVO> listVO;

    public void loadData(){

        RetrofitService retrofitService = RetrofitService.retrofit_intro.create(RetrofitService.class);
        Call<IntroVO> call = retrofitService.getIntroData();
        call.enqueue(new Callback<IntroVO>() {
            @Override
            public void onResponse(Call<IntroVO> call, Response<IntroVO> response) {
                introVO = response.body();
                listVO = introVO.getItems();

            }

            @Override
            public void onFailure(Call<IntroVO> call, Throwable t) {



            }
        });

    }

}
