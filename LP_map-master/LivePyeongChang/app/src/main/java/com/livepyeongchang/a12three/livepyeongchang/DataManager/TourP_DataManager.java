package com.livepyeongchang.a12three.livepyeongchang.DataManager;

import android.util.Log;

import com.livepyeongchang.a12three.livepyeongchang.DataManager.Data.TourF_VO.PicListVO;
import com.livepyeongchang.a12three.livepyeongchang.DataManager.Data.TourF_VO.PicVO;
import com.livepyeongchang.a12three.livepyeongchang.DataManager.Remote.RetrofitService;
import com.livepyeongchang.a12three.livepyeongchang.Model.Model_Pic;
import com.livepyeongchang.a12three.livepyeongchang.View.BaseActivity;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by kwakgee on 2017. 9. 21..
 */

public class TourP_DataManager {

    private PicVO picVO;
    private List<PicListVO> picListVO;

    public void loadData(boolean iskorean){

        RetrofitService retrofitService = RetrofitService.retrofit_Pic.create(RetrofitService.class);

        Call<PicVO> call;

        if(iskorean){
            call = retrofitService.getKorPic();
        }else{
            call = retrofitService.getEngPic();
        }

        call.enqueue(new Callback<PicVO>() {
            @Override
            public void onResponse(Call<PicVO> call, Response<PicVO> response) {

                picVO = response.body();
                picListVO = picVO.getListArr();

                for(int i=0; i<picListVO.size(); i++){
                    String url = picListVO.get(i).getTourUrl();
                    String name = picListVO.get(i).getTourName();

                    Log.v("name", name);
                    Log.v("url", url);

                    BaseActivity.picArr.add(new Model_Pic(url, name));
                }

            }

            @Override
            public void onFailure(Call<PicVO> call, Throwable t) {

            }
        });

    }

}
