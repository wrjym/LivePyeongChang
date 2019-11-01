package com.livepyeongchang.a12three.livepyeongchang.DataManager;

import com.livepyeongchang.a12three.livepyeongchang.DataManager.Data.RankF_VO.CountryVO;
import com.livepyeongchang.a12three.livepyeongchang.DataManager.Data.RankF_VO.RankingVO;
import com.livepyeongchang.a12three.livepyeongchang.DataManager.Remote.RetrofitService;

import java.util.Collections;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by MG_PARK on 2017-09-16.
 */

public class RankF_DataManager {

    private RankingVO rankVO;
    public static List<CountryVO> listVO;

    public void loadData(){

        RetrofitService retrofitService = RetrofitService .retrofit_ranking.create(RetrofitService .class);
        Call<RankingVO> call = retrofitService.getRankingData();
        call.enqueue(new Callback<RankingVO>() {
            @Override
            public void onResponse(Call<RankingVO> call, Response<RankingVO> response) {
                rankVO = response.body();
                listVO = rankVO.getItems();

                System.out.println("MANAGER start");

                for(int i=0;i<listVO.size();i++){


                    int temp;

                    temp=listVO.get(i).getGold()+listVO.get(i).getSilver()+listVO.get(i).getBronze();

                    listVO.get(i).setScore(temp);

                    for(int j=0;j<listVO.size();j++){

                        if(listVO.get(i).getGold()>listVO.get(j).getGold()){
                            Collections.swap(listVO,i,j);
                        }else if(listVO.get(i).getGold()==listVO.get(j).getGold()){
                            if(listVO.get(i).getSilver()>listVO.get(j).getSilver()){
                                Collections.swap(listVO,i,j);
                            }else if(listVO.get(i).getSilver()==listVO.get(j).getSilver()){
                                if(listVO.get(i).getBronze()>listVO.get(j).getBronze()){
                                    Collections.swap(listVO,i,j);
                                }
                            }
                        }

                    }

                }

                for(int k=0;k<listVO.size();k++){
                    listVO.get(k).setRank(k+1);
                }


                System.out.println("MANAGER end");


            }

            @Override
            public void onFailure(Call<RankingVO> call, Throwable t) {

            }
        });
    }
}
