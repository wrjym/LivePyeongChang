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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;

import com.livepyeongchang.a12three.livepyeongchang.Controller.Adapter_Tour;
import com.livepyeongchang.a12three.livepyeongchang.Model.Model_Tour;
import com.livepyeongchang.a12three.livepyeongchang.R;
import com.livepyeongchang.a12three.livepyeongchang.View.BaseActivity;

import java.util.ArrayList;
import java.util.List;

import static com.livepyeongchang.a12three.livepyeongchang.View.MainActivity.isKorean;

/**
 * Created by kwakgee on 2017. 9. 4..
 */

public class FragmentTour extends Fragment {

    private RecyclerView rv_tour;
    private Spinner sp_subject;
    private Spinner sp_area;

    private Adapter_Tour adapter_tour;
    private LinearLayoutManager layoutManager;

    String subject;
    String area;

    private LinearLayout ll_loading;

    public FragmentTour(){}

    public static FragmentTour newInstance() {
        FragmentTour fragment = new FragmentTour();
        return fragment;
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.v("4","4");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_tour, container, false);
        Log.v("4","4");

        rv_tour = (RecyclerView) rootView.findViewById(R.id.rv_tour);
        sp_subject = (Spinner) rootView.findViewById(R.id.sp_subject);
        sp_area = (Spinner) rootView.findViewById(R.id.sp_area);

        adapter_tour = new Adapter_Tour(BaseActivity.tourArr, getContext());
        layoutManager = new LinearLayoutManager(getActivity());

        rv_tour.setLayoutManager(layoutManager);
        rv_tour.setAdapter(adapter_tour);

        String[] str1=getResources().getStringArray(R.array.theme);
        ArrayAdapter<String> adapter1=new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_dropdown_item,str1);
        sp_subject.setAdapter(adapter1);

        String[] str2=getResources().getStringArray(R.array.area);
        ArrayAdapter<String> adapter2=new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_dropdown_item,str2);
        sp_area.setAdapter(adapter2);

        subject = String.valueOf(sp_subject.getItemAtPosition(0));
        area = String.valueOf(sp_area.getItemAtPosition(0));

        sp_subject.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                subject = String.valueOf(sp_subject.getItemAtPosition(position));
                refresh();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        sp_area.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                area = String.valueOf(sp_area.getItemAtPosition(position));
                refresh();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        return rootView;

    }

    public void refresh(){

        List<Model_Tour> tempArr = new ArrayList<>();
        String all = "ALL";
        if(isKorean) all = "전체";

        if(!subject.equals(all) && !area.equals(all)) {

            for (int i = 0; i < BaseActivity.tourArr.size(); i++) {
                if (BaseActivity.tourArr.get(i).getKind().equals(subject) && BaseActivity.tourArr.get(i).getArea().equals(area)) {
                    tempArr.add(BaseActivity.tourArr.get(i));
                }

            }
        } else if(subject.equals(all) && !area.equals(all)){

            for(int i=0; i<BaseActivity.tourArr.size(); i++){
                if(BaseActivity.tourArr.get(i).getArea().equals(area)){
                    tempArr.add(BaseActivity.tourArr.get(i));
                }
            }

        } else if(!subject.equals(all) && area.equals(all)){

            for(int i = 0; i<BaseActivity.tourArr.size(); i++){
                if(BaseActivity.tourArr.get(i).getKind().equals(subject)){
                    tempArr.add(BaseActivity.tourArr.get(i));
                }
            }

        } else {
            tempArr = BaseActivity.tourArr;
        }

        adapter_tour = new Adapter_Tour(tempArr, getContext());
        rv_tour.setAdapter(adapter_tour);
        adapter_tour.notifyDataSetChanged();
    }


}
