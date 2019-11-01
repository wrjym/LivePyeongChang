package com.livepyeongchang.a12three.livepyeongchang.View.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.livepyeongchang.a12three.livepyeongchang.Controller.Adapter_Rank;
import com.livepyeongchang.a12three.livepyeongchang.DataManager.Data.RankF_VO.CountryVO;
import com.livepyeongchang.a12three.livepyeongchang.R;
import com.livepyeongchang.a12three.livepyeongchang.View.MainActivity;
import com.squareup.picasso.Picasso;

import java.util.List;

import static com.livepyeongchang.a12three.livepyeongchang.DataManager.RankF_DataManager.listVO;

/**
 * Created by kwakgee on 2017. 9. 18..
 */

public class FragmentRank extends Fragment {

    private List<CountryVO> list_country;



    public static RecyclerView recyclerView;
    public RecyclerView.LayoutManager layoutManager;

    public static CountryVO korea;
    private ImageView img_kor;
    private TextView txt_kor;
    private TextView txt_kor_rank;
    private TextView txt_kor_gold;
    private TextView txt_kor_silver;
    private TextView txt_kor_bronze;

    private ImageView img_first;
    private ImageView img_second;
    private ImageView img_third;

    public FragmentRank(){}

    public static FragmentRank newInstance() {
        FragmentRank fragment = new FragmentRank();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_rank, container, false);


        System.out.println("MAIN onCreate()");


        recyclerView=(RecyclerView)rootView.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        layoutManager=new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);


        img_kor=(ImageView)rootView.findViewById(R.id.img_kor);
        txt_kor=(TextView)rootView.findViewById(R.id.txt_kor);
        txt_kor_rank=(TextView)rootView.findViewById(R.id.txt_kor_rank);
        txt_kor_gold=(TextView)rootView.findViewById(R.id.txt_kor_gold);
        txt_kor_silver=(TextView)rootView.findViewById(R.id.txt_kor_silver);
        txt_kor_bronze=(TextView)rootView.findViewById(R.id.txt_kor_bronze);

        img_first=(ImageView)rootView.findViewById(R.id.img_first);
        img_second=(ImageView)rootView.findViewById(R.id.img_second);
        img_third=(ImageView)rootView.findViewById(R.id.img_third);

        for(int i = 0; i< listVO.size(); i++) {
            if (listVO.get(i).getCountry().equals("대한민국")) {

                korea = listVO.get(i);

                System.out.println(FragmentRank.korea.toString());
            }
        }

        Adapter_Rank adapter = new Adapter_Rank(listVO);
        FragmentRank.recyclerView.setAdapter(adapter);

        settingKor();
        settingTopThree();

        System.out.println("MAIN Done");


        return rootView;
    }

    public void settingKor(){

        System.out.println("MAIN"+ korea.toString());

        Picasso.with(getActivity())
                .load(korea.getUrl())
                .into(img_kor);


        if(MainActivity.isKorean) {
            txt_kor.setText(korea.getCountry());
            txt_kor_rank.setText("종합 " + korea.getRank() + "위");
        }else{
            txt_kor.setTextSize(15);
            txt_kor.setText(korea.getEcountry());
            if(korea.getRank()==1){
                txt_kor_rank.setText("Total " + korea.getRank() + "'st");
            }else if(korea.getRank()==2){
                txt_kor_rank.setText("Total " + korea.getRank() + "'ed");
            }else if(korea.getRank()==3){
                txt_kor_rank.setText("Total " + korea.getRank() + "'rd");
            }else{
                txt_kor_rank.setText("Total " + korea.getRank() + "'th");
            }
        }

        txt_kor_gold.setText(korea.getGold()+"");
        txt_kor_silver.setText(korea.getSilver()+"");
        txt_kor_bronze.setText(korea.getBronze()+"");

    }

    public void settingTopThree(){

        for(int i=0;i<listVO.size();i++) {
            if (listVO.get(i).getRank() == 1) {
                Picasso.with(getActivity())
                        .load(listVO.get(i).getUrl())
                        .into(img_first);
            }else if(listVO.get(i).getRank() == 2){
                Picasso.with(getActivity())
                        .load(listVO.get(i).getUrl())
                        .into(img_second);
            }else if(listVO.get(i).getRank() == 3) {
                Picasso.with(getActivity())
                        .load(listVO.get(i).getUrl())
                        .into(img_third);
            }
        }
    }
}
