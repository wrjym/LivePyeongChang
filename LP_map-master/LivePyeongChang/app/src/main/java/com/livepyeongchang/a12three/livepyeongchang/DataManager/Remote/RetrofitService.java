package com.livepyeongchang.a12three.livepyeongchang.DataManager.Remote;

import com.livepyeongchang.a12three.livepyeongchang.Controller.Constants;
import com.livepyeongchang.a12three.livepyeongchang.DataManager.Data.CheerF_VO.CheerVO;
import com.livepyeongchang.a12three.livepyeongchang.DataManager.Data.IntroF_VO.IntroVO;
import com.livepyeongchang.a12three.livepyeongchang.DataManager.Data.MainF_VO.MainVO;
import com.livepyeongchang.a12three.livepyeongchang.DataManager.Data.RankF_VO.RankingVO;
import com.livepyeongchang.a12three.livepyeongchang.DataManager.Data.ReplyVO.ReplyVO;
import com.livepyeongchang.a12three.livepyeongchang.DataManager.Data.ReplyVO.ReplyVO_Post;
import com.livepyeongchang.a12three.livepyeongchang.DataManager.Data.TourF_VO.FrameVO;
import com.livepyeongchang.a12three.livepyeongchang.DataManager.Data.TourF_VO.PicVO;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface RetrofitService {

    @GET("/schedule")
    Call<MainVO> getMainData();

    Retrofit retrofit_main = new Retrofit.Builder()
            .baseUrl(Constants.SCHEDULE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    @GET("/infor")
    Call<IntroVO> getIntroData();

    Retrofit retrofit_intro = new Retrofit.Builder()
            .baseUrl(Constants.INTRODUCE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    @GET("/apiservice/647845744372686b34364d52434b68/json/{SERVICE}/1/{END_INDEX}")
    Call<FrameVO> getTourData(@Path("SERVICE") String service, @Path("END_INDEX") String endIndex);

    Retrofit retrofit_tour = new Retrofit.Builder()
            .baseUrl(Constants.API_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    @GET("/player")
    Call<CheerVO> getCheerData();

    Retrofit retrofit_cheer = new Retrofit.Builder()
            .baseUrl(Constants.CHEER_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    @GET("/medals")
    Call<RankingVO> getRankingData();

    Retrofit retrofit_ranking=new Retrofit.Builder()
            .baseUrl("http://ec2-13-124-87-34.ap-northeast-2.compute.amazonaws.com:4000/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();


    @GET("/greply")
    Call<ReplyVO> getReplyData();

    Retrofit retrofit_reply = new Retrofit.Builder()
            .baseUrl(Constants.REPLY_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    @FormUrlEncoded
    @POST("/preply")
    Call<ReplyVO_Post> getComment(
            @Field("comment") String comment,
            @Field("player") String player
    );

    Retrofit retrofit_replys = new Retrofit.Builder()
            .baseUrl(Constants.REPLY_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    @GET("tour")
    Call<PicVO> getKorPic();

    @GET("etour")
    Call<PicVO> getEngPic();

    Retrofit retrofit_Pic = new Retrofit.Builder()
            .baseUrl(Constants.TOUR_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();


}
