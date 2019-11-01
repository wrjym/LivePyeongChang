package com.livepyeongchang.a12three.livepyeongchang.View.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.livepyeongchang.a12three.livepyeongchang.DataManager.CheerF_DataManager;
import com.livepyeongchang.a12three.livepyeongchang.DataManager.Data.CheerF_VO.PlayerVO;
import com.livepyeongchang.a12three.livepyeongchang.R;

import java.util.List;

/**
 * Created by kwakgee on 2017. 9. 4..
 */

public class FragmentCheer extends Fragment {


    List<PlayerVO> playerList;
    List<PlayerVO> selectedList;

    private String game;

    public static RecyclerView recyclerView;
    private RecyclerView.LayoutManager reLayoutManager;

    private CheerF_DataManager dataManager;

    private Spinner spinner;

    public FragmentCheer(){}

    public static FragmentCheer newInstance() {
        FragmentCheer fragment = new FragmentCheer();
        return fragment;
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.v("3","3");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_support, container, false);

        dataManager = new CheerF_DataManager();


        recyclerView=(RecyclerView)rootView.findViewById(R.id.recycler_view);

        recyclerView.setHasFixedSize(true);
        reLayoutManager=new GridLayoutManager(getContext(),2);
        recyclerView.setLayoutManager(reLayoutManager);


        spinner=(Spinner)rootView.findViewById(R.id.spinner);
        String[] str=getResources().getStringArray(R.array.subject);

        ArrayAdapter<String> adapter=new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_dropdown_item,str);
        spinner.setAdapter(adapter);



        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                game=String.valueOf(spinner.getItemAtPosition(position));

                dataManager.loadData(game, 1);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        return rootView;

    }
}
