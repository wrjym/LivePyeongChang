package com.livepyeongchang.a12three.livepyeongchang.View.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

import com.livepyeongchang.a12three.livepyeongchang.DataManager.Data.IntroF_VO.ListVO;
import com.livepyeongchang.a12three.livepyeongchang.DataManager.IntroF_DataManager;
import com.livepyeongchang.a12three.livepyeongchang.R;
import com.livepyeongchang.a12three.livepyeongchang.View.MainActivity;
import com.livepyeongchang.a12three.livepyeongchang.View.SubjectActivity;

/**
 * Created by kwakgee on 2017. 9. 4..
 */

public class FragmentIntroduce extends Fragment implements View.OnClickListener, View.OnLongClickListener{

    @Override
    public void onStart() {
        super.onStart();
        Log.v("2","2");
    }

    private ImageButton[] mButton=new ImageButton[15];

    public FragmentIntroduce(){}

    public static FragmentIntroduce newInstance() {
        FragmentIntroduce fragment = new FragmentIntroduce();
        return fragment;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_introduce, container, false);




        mButton[0]=(ImageButton)rootView.findViewById(R.id.btn1);
        mButton[1]=(ImageButton)rootView.findViewById(R.id.btn2);
        mButton[2]=(ImageButton)rootView.findViewById(R.id.btn3);
        mButton[3]=(ImageButton)rootView.findViewById(R.id.btn4);
        mButton[4]=(ImageButton)rootView.findViewById(R.id.btn5);
        mButton[5]=(ImageButton)rootView.findViewById(R.id.btn6);
        mButton[6]=(ImageButton)rootView.findViewById(R.id.btn7);
        mButton[7]=(ImageButton)rootView.findViewById(R.id.btn8);
        mButton[8]=(ImageButton)rootView.findViewById(R.id.btn9);
        mButton[9]=(ImageButton)rootView.findViewById(R.id.btn10);
        mButton[10]=(ImageButton)rootView.findViewById(R.id.btn11);
        mButton[11]=(ImageButton)rootView.findViewById(R.id.btn12);
        mButton[12]=(ImageButton)rootView.findViewById(R.id.btn13);
        mButton[13]=(ImageButton)rootView.findViewById(R.id.btn14);
        mButton[14]=(ImageButton)rootView.findViewById(R.id.btn15);

        IntroF_DataManager dataManager = new IntroF_DataManager();
        dataManager.loadData();

        for(int i=0;i<15;i++){
            //mButton[i]=(ImageButton)findViewById(R.id.btn1+i);

            mButton[i].setTag(i);

            mButton[i].setOnClickListener(this);
            mButton[i].setOnLongClickListener(this);

        }


        return rootView;

    }

    public ListVO findSub(int index){

        ListVO listVO=new ListVO();

        for(ListVO temp : IntroF_DataManager.listVO){

            if(temp.getIndex()==index){
                listVO=temp;
                break;
            }
        }



        return listVO;
    }

    @Override
    public boolean onLongClick(View v) {

        ImageButton newButton = (ImageButton) v;

        for(ImageButton tempButton : mButton) {
            if (tempButton == newButton) {
                int position = (Integer) v.getTag();

                ListVO matching = findSub(position+1);

                if(MainActivity.isKorean){
                    Toast.makeText(getContext(), matching.getGame(), Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getContext(), matching.getEgame(), Toast.LENGTH_SHORT).show();
                }

            }
        }

        return true;
    }

    @Override
    public void onClick(View v){

        ImageButton newButton = (ImageButton) v;

        for(ImageButton tempButton : mButton) {
            if (tempButton == newButton) {
                int position = (Integer) v.getTag();

                ListVO matching = findSub(position+1);

                Intent intent=new Intent(getContext(), SubjectActivity.class);

                if(MainActivity.isKorean){
                    intent.putExtra("rink",matching.getRink()); // 한영 버젼 구현 -> ko <-> en
                    intent.putExtra("summary",matching.getSummary());
                    intent.putExtra("stadium",matching.getStadium());
                    intent.putExtra("game",matching.getGame());
                }else{
                    String en_rink = matching.getRink().replace("ko","en");
                    intent.putExtra("rink",en_rink); // 한영 버젼 구현 -> ko <-> en
                    intent.putExtra("summary",matching.getEsummary());
                    intent.putExtra("stadium",matching.getEstadium());
                    intent.putExtra("game",matching.getEgame());
                }
                intent.putExtra("demo",matching.getDemoVideo());

                /* 한/영버젼 구현 */


                startActivity(intent);

            }
        }

    }



}
