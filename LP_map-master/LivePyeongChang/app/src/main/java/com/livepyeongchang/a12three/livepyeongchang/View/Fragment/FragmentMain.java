package com.livepyeongchang.a12three.livepyeongchang.View.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import com.livepyeongchang.a12three.livepyeongchang.Controller.Adapter_Today;
import com.livepyeongchang.a12three.livepyeongchang.Controller.Adapter_Tomorrow;
import com.livepyeongchang.a12three.livepyeongchang.Controller.Adapter_Yesterday;
import com.livepyeongchang.a12three.livepyeongchang.Controller.TimeManager;
import com.livepyeongchang.a12three.livepyeongchang.R;
import com.livepyeongchang.a12three.livepyeongchang.View.BaseActivity;

/**
 * Created by kwakgee on 2017. 9. 4..
 */

public class FragmentMain extends Fragment {

    private Button btn_pre;
    private TextView tv_date;
    private Button btn_nex;
    private int dateIndex;

    private RecyclerView rv_card_main_yes;
    private Adapter_Yesterday adapterYesterday;

    private RecyclerView rv_card_main_tod;
    private Adapter_Today adapterToday;

    private RecyclerView rv_card_main_tom;
    private Adapter_Tomorrow adapterTomorrow;


    private LinearLayoutManager layoutManager1;
    private LinearLayoutManager layoutManager2;
    private LinearLayoutManager layoutManager3;

    private Animation translate_left_appear;
    private Animation translate_left_fadeout;
    private Animation translate_right_appear;
    private Animation translate_right_fadeout;

    public FragmentMain(){}

    public static FragmentMain newInstance() {
        FragmentMain fragment = new FragmentMain();
        return fragment;
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.v("1","1");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_main, container, false);
        Log.v("1","1");

        rv_card_main_yes = (RecyclerView) rootView.findViewById(R.id.rv_card_main_yes);
        rv_card_main_tod = (RecyclerView) rootView.findViewById(R.id.rv_card_main_tod);
        rv_card_main_tom = (RecyclerView) rootView.findViewById(R.id.rv_card_main_tom);


        layoutManager1 = new LinearLayoutManager(getActivity());
        layoutManager2 = new LinearLayoutManager(getActivity());
        layoutManager3 = new LinearLayoutManager(getActivity());
        rv_card_main_yes.setLayoutManager(layoutManager1);
        rv_card_main_tod.setLayoutManager(layoutManager2);
        rv_card_main_tom.setLayoutManager(layoutManager3);

        /* 수정할 부분*/
        adapterYesterday = new Adapter_Yesterday(BaseActivity.yesterdayArr, getContext()); // 배열
        rv_card_main_yes.setAdapter(adapterYesterday);

        adapterToday = new Adapter_Today(BaseActivity.todayArr, getContext()); // 배열
        rv_card_main_tod.setAdapter(adapterToday);

        adapterTomorrow = new Adapter_Tomorrow(BaseActivity.tomorrowArr, getContext()); // 배열
        rv_card_main_tom.setAdapter(adapterTomorrow);

        btn_pre = rootView.findViewById(R.id.btn_pre);
        tv_date = rootView.findViewById(R.id.tv_date);
        btn_nex = rootView.findViewById(R.id.btn_nex);

        final TimeManager timeManager = new TimeManager();

        translate_left_appear = AnimationUtils.loadAnimation(getContext(), R.anim.translate_left_appear);
        translate_left_fadeout = AnimationUtils.loadAnimation(getContext(), R.anim.translate_left_fadeout);
        translate_right_appear = AnimationUtils.loadAnimation(getContext(), R.anim.translate_right_appear);
        translate_right_fadeout = AnimationUtils.loadAnimation(getContext(), R.anim.translate_right_fadeout);

        tv_date.setText(timeManager.addDate(0, false));
        dateIndex = 1;

        btn_pre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(dateIndex == 0){

                }else if(dateIndex == 1){
                    dateIndex--;
                    tv_date.setText(timeManager.addDate(-1, false));
                    rv_card_main_yes.setVisibility(View.VISIBLE);
                    rv_card_main_yes.startAnimation(translate_right_appear);
                    rv_card_main_tod.startAnimation(translate_right_fadeout);
                    rv_card_main_tod.setVisibility(View.INVISIBLE);
                }else if(dateIndex == 2){
                    dateIndex--;
                    tv_date.setText(timeManager.addDate(0, false));
                    rv_card_main_tod.setVisibility(View.VISIBLE);
                    rv_card_main_tod.startAnimation(translate_right_appear);
                    rv_card_main_tom.startAnimation(translate_right_fadeout);
                    rv_card_main_tom.setVisibility(View.INVISIBLE);
                }
            }
        });

        btn_nex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(dateIndex == 0){
                    dateIndex++;
                    tv_date.setText(timeManager.addDate(0, false));
                    rv_card_main_tod.setVisibility(View.VISIBLE);
                    rv_card_main_tod.startAnimation(translate_left_appear);
                    rv_card_main_yes.startAnimation(translate_left_fadeout);
                    rv_card_main_yes.setVisibility(View.INVISIBLE);
                }else if(dateIndex == 1){
                    dateIndex++;
                    tv_date.setText(timeManager.addDate(1, false));
                    rv_card_main_tom.setVisibility(View.VISIBLE);
                    rv_card_main_tom.startAnimation(translate_left_appear);
                    rv_card_main_tod.startAnimation(translate_left_fadeout);
                    rv_card_main_tod.setVisibility(View.INVISIBLE);
                }else if(dateIndex == 2){

                }
            }
        });

        return rootView;

    }

}
