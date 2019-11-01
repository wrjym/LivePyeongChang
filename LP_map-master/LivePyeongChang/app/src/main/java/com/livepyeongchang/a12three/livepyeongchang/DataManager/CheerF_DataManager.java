package com.livepyeongchang.a12three.livepyeongchang.DataManager;

import com.livepyeongchang.a12three.livepyeongchang.Controller.Adapter_Cheer;
import com.livepyeongchang.a12three.livepyeongchang.DataManager.Data.CheerF_VO.CheerVO;
import com.livepyeongchang.a12three.livepyeongchang.DataManager.Data.CheerF_VO.PlayerVO;
import com.livepyeongchang.a12three.livepyeongchang.DataManager.Remote.RetrofitService;
import com.livepyeongchang.a12three.livepyeongchang.View.Fragment.FragmentCheer;
import com.livepyeongchang.a12three.livepyeongchang.View.MainActivity;
import com.livepyeongchang.a12three.livepyeongchang.View.SubjectActivity;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by MG_PARK on 2017-09-11.
 */

public class CheerF_DataManager {

    private CheerVO cheerVO;
    public static List<PlayerVO> playerVO;
    private List<PlayerVO> selectedList;
    private String selectedGame;


    public void loadData(String game,int actNum){

        final int Num=actNum;

        selectedGame=game;

        RetrofitService retrofitService = RetrofitService.retrofit_cheer.create(RetrofitService.class);
        Call<CheerVO> call = retrofitService.getCheerData();
        call.enqueue(new Callback<CheerVO>() {
            @Override
            public void onResponse(Call<CheerVO> call, Response<CheerVO> response) {
                cheerVO = response.body();
                playerVO = cheerVO.getItems();

                selectedList=new ArrayList<PlayerVO>();

                for(int i=0;i<playerVO.size();i++){

                    if(MainActivity.isKorean){
                        if (selectedGame.equals(playerVO.get(i).getGame())) {
                            selectedList.add(playerVO.get(i));
                        }
                    }else{
                        for(int j=0;j<IntroF_DataManager.listVO.size();j++) {
                            if (selectedGame.equals(IntroF_DataManager.listVO.get(j).getEgame()) && playerVO.get(i).getGame().equals(IntroF_DataManager.listVO.get(j).getGame())) {
                                selectedList.add(playerVO.get(i));
                            }
                        }

                    }

                }

                /*선수 카드가 요청에 따라 다른 액티비티에 들어갈 수 있도록 구현*/
                Adapter_Cheer adapter = new Adapter_Cheer(selectedList);
                if(Num==1) {
                    FragmentCheer.recyclerView.setAdapter(adapter);
                }else if(Num==2){
                    SubjectActivity.recyclerFace.setAdapter(adapter);
                }

            }

            @Override
            public void onFailure(Call<CheerVO> call, Throwable t) {

            }
        });

    }
}
