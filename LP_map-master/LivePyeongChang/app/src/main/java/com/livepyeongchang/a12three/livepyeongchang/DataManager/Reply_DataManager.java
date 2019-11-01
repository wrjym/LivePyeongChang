package com.livepyeongchang.a12three.livepyeongchang.DataManager;

import com.livepyeongchang.a12three.livepyeongchang.DataManager.Data.ReplyVO.ReplyListVO;
import com.livepyeongchang.a12three.livepyeongchang.DataManager.Data.ReplyVO.ReplyVO;
import com.livepyeongchang.a12three.livepyeongchang.DataManager.Remote.RetrofitService;
import com.livepyeongchang.a12three.livepyeongchang.Model.Model_Reply;
import com.livepyeongchang.a12three.livepyeongchang.View.Player_Detail_Activity;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by yongmac on 2017. 9. 20..
 */

public class Reply_DataManager {

    private ReplyVO replyVO;
    private List<ReplyListVO> listVO;

    public void loadData(final String nameKey){


        RetrofitService retrofitService = RetrofitService.retrofit_reply.create(RetrofitService.class);
        Call<ReplyVO> call = retrofitService.getReplyData();
        call.enqueue(new Callback<ReplyVO>() {
            @Override
            public void onResponse(Call<ReplyVO> call, Response<ReplyVO> response) {

                replyVO = response.body();
                listVO = replyVO.getListArr();

                for(int i=0; i<listVO.size(); i++) {
                    if(nameKey.equals(listVO.get(i).getPlayer())) {
                        Player_Detail_Activity.replyArr.add(new Model_Reply(listVO.get(i).getComment()));
                    }
                }
            }

            @Override
            public void onFailure(Call<ReplyVO> call, Throwable t) {

            }
        });


    }

}
