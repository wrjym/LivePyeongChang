package com.livepyeongchang.a12three.livepyeongchang.DataManager;

import com.livepyeongchang.a12three.livepyeongchang.DataManager.Data.TourF_VO.FrameVO;
import com.livepyeongchang.a12three.livepyeongchang.DataManager.Data.TourF_VO.RowVO;
import com.livepyeongchang.a12three.livepyeongchang.DataManager.Data.TourF_VO.TourVO;
import com.livepyeongchang.a12three.livepyeongchang.DataManager.Remote.RetrofitService;
import com.livepyeongchang.a12three.livepyeongchang.Model.Model_Tour;
import com.livepyeongchang.a12three.livepyeongchang.View.BaseActivity;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by kwakgee on 2017. 9. 7..
 */

public class TourF_DataManager {

    private FrameVO frameVO;
    private TourVO tourVO;
    public static List<RowVO> rowVO;

    public void loadData(final String service, String endIndex){

        RetrofitService retrofitService = RetrofitService.retrofit_tour.create(RetrofitService.class);
        Call<FrameVO> call = retrofitService.getTourData(service, endIndex);
        call.enqueue(new Callback<FrameVO>() {
            @Override
            public void onResponse(Call<FrameVO> call, Response<FrameVO> response) {

                frameVO = response.body();

                /* 한/영 버젼 구현.. */
                switch (service) {
                    case "tourdb-tourist_attraction-theme_park-kr":
                        tourVO = frameVO.getTourVO_theme_kr();
                        break;
                    case "tourdb-tourist_attraction-amusement_park-kr":
                        tourVO = frameVO.getTourVO_amusement_kr();
                        break;
                    case "tourdb-tourist_attraction-ruins-kr":
                        tourVO = frameVO.getTourVO_ruins_kr();
                        break;
                    case "tourdb-tourist_attraction-culture-kr":
                        tourVO = frameVO.getTourVO_culture_kr();
                        break;
                    case "tourdb-tourist_attraction-beach-kr":
                        tourVO = frameVO.getTourVO_beach_kr();
                        break;
                    case "tourdb-tourist_attraction-theme_park-us_en":
                        tourVO = frameVO.getTourVO_theme_us();
                        break;
                    case "tourdb-tourist_attraction-amusement_park-us_en":
                        tourVO = frameVO.getTourVO_amusement_us();
                        break;
                    case "tourdb-tourist_attraction-ruins-us_en":
                        tourVO = frameVO.getTourVO_ruins_us();
                        break;
                    case "tourdb-tourist_attraction-culture-us_en":
                        tourVO = frameVO.getTourVO_culture_us();
                        break;
                    case "tourdb-tourist_attraction-beach-us_en":
                        tourVO = frameVO.getTourVO_beach_us();
                        break;
                }
                rowVO = tourVO.getRow();

                for(int i=0; i<rowVO.size(); i++){
                    String kind = rowVO.get(i).getSMGW_SUBJECT_S();
                    String area = rowVO.get(i).getSMGW_AREA_S();
                    String name = rowVO.get(i).getSUBJECT();
                    String summary = rowVO.get(i).getSMGW_SUMMARY_S();
                    String address = rowVO.get(i).getSMGW_ADDRESS_S();
                    String lat = rowVO.get(i).getLAT();
                    String lng = rowVO.get(i).getLNG();
                    String contact = rowVO.get(i).getSMGW_CONTACT_S();
                    String homepage = rowVO.get(i).getSMGW_HOMEPAGE_S();
                    String tip = rowVO.get(i).getSMGW_TIPS_T();
                    String holiday = rowVO.get(i).getSMGW_HOLIDAY_S();
                    String time = rowVO.get(i).getSMGW_TIME_S();
                    String admission = rowVO.get(i).getSMGW_ADMISSION_S();
                    String parking = rowVO.get(i).getSMGW_PARKING_S();
                    String content = rowVO.get(i).getCONTENT();

                    BaseActivity.tourArr.add(new Model_Tour(kind, area, name, summary, address, lat, lng, contact, homepage, tip, holiday, time, admission, parking, content));

                }
            }

            @Override
            public void onFailure(Call<FrameVO> call, Throwable t) {

            }
        });


    }

}