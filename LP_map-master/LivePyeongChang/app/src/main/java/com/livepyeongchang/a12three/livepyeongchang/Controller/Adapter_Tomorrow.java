package com.livepyeongchang.a12three.livepyeongchang.Controller;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.livepyeongchang.a12three.livepyeongchang.Model.Model_Main;
import com.livepyeongchang.a12three.livepyeongchang.R;
import com.livepyeongchang.a12three.livepyeongchang.View.MainActivity;

import java.util.List;

/**
 * Created by kwakgee on 2017. 9. 5..
 */

public class Adapter_Tomorrow extends RecyclerView.Adapter<Adapter_Tomorrow.ViewHolder>{

    List<Model_Main> tempArr;
    Context context;

    public Adapter_Tomorrow(List<Model_Main> tempArr, Context context){
        this.tempArr = tempArr;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_base, parent, false));
    }

    private TimeManager timeManager = new TimeManager();

    @Override
    public void onBindViewHolder(Adapter_Tomorrow.ViewHolder holder, final int position) {

        if(tempArr.get(position).getDate().equals(timeManager.addDate(1, true))) {
            switch (tempArr.get(position).getMatchNm()) {
                case "스피드스케이팅":
                    holder.iv_picto.setImageResource(R.drawable.picto_ssk);
                    holder.ll_card_main.setBackgroundResource(R.drawable.photo_ssk);
                    break;
                case "피겨스케이팅":
                    holder.iv_picto.setImageResource(R.drawable.picto_fsk);
                    holder.ll_card_main.setBackgroundResource(R.drawable.photo_fsk);
                    break;
                case "봅슬레이":
                    holder.iv_picto.setImageResource(R.drawable.picto_bob);
                    holder.ll_card_main.setBackgroundResource(R.drawable.photo_bob);
                    break;
                case "바이애슬론":
                    holder.iv_picto.setImageResource(R.drawable.picto_bth);
                    holder.ll_card_main.setBackgroundResource(R.drawable.photo_bth);
                    break;
                case "프리스타일스키":
                    holder.iv_picto.setImageResource(R.drawable.picto_frs);
                    holder.ll_card_main.setBackgroundResource(R.drawable.photo_frs);
                    break;
                case "컬링":
                    holder.iv_picto.setImageResource(R.drawable.picto_cur);
                    holder.ll_card_main.setBackgroundResource(R.drawable.photo_cur);
                    break;
                case "스키점프":
                    holder.iv_picto.setImageResource(R.drawable.picto_sjp);
                    holder.ll_card_main.setBackgroundResource(R.drawable.photo_sjp);
                    break;
                case "알파인스키":
                    holder.iv_picto.setImageResource(R.drawable.picto_alp);
                    holder.ll_card_main.setBackgroundResource(R.drawable.photo_alp);
                    break;
                case "크로스컨트리스키":
                    holder.iv_picto.setImageResource(R.drawable.picto_ccs);
                    holder.ll_card_main.setBackgroundResource(R.drawable.photo_ccs);
                    break;
                case "루지":
                    holder.iv_picto.setImageResource(R.drawable.picto_lug);
                    holder.ll_card_main.setBackgroundResource(R.drawable.photo_lug);
                    break;
                case "아이스하키":
                    holder.iv_picto.setImageResource(R.drawable.picto_iho);
                    holder.ll_card_main.setBackgroundResource(R.drawable.photo_iho);
                    break;
                case "노르딕복합":
                    holder.iv_picto.setImageResource(R.drawable.picto_ncb);
                    holder.ll_card_main.setBackgroundResource(R.drawable.photo_ncb);
                    break;
                case "스켈레톤":
                    holder.iv_picto.setImageResource(R.drawable.picto_skn);
                    holder.ll_card_main.setBackgroundResource(R.drawable.photo_skn);
                    break;
                case "쇼트트랙":
                    holder.iv_picto.setImageResource(R.drawable.picto_stk);
                    holder.ll_card_main.setBackgroundResource(R.drawable.photo_stk);
                    break;
                case "스노보드":
                    holder.iv_picto.setImageResource(R.drawable.picto_sbd);
                    holder.ll_card_main.setBackgroundResource(R.drawable.photo_sbd);
                    break;

            }

            if(tempArr.get(position).isMedal()){
                holder.iv_medal.setVisibility(View.VISIBLE);
            }else{
                holder.iv_medal.setVisibility(View.INVISIBLE);
            }

            holder.tv_match_nm.setText(tempArr.get(position).getMatchEnm() + " - " + tempArr.get(position).getEdetail());
            holder.tv_match_stadium.setText(tempArr.get(position).getEstadium());
            if(MainActivity.isKorean) {
                holder.tv_match_nm.setText(tempArr.get(position).getMatchNm() + " - " + tempArr.get(position).getDetail());
                holder.tv_match_stadium.setText(tempArr.get(position).getStadium());
            }

            String timeTitle = "Time: ";
            if (MainActivity.isKorean) timeTitle = "시간: ";
            holder.tv_match_time.setText(timeTitle + tempArr.get(position).getTime());
            holder.iv_status.setImageResource(R.drawable.unlive);

            holder.ll_frame.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    AlertDialog.Builder ad = new AlertDialog.Builder(context);
                    ad.setIcon(R.drawable.icon_news);
                    String negative = "Go to page";
                    String title = "Match news";
                    String message = tempArr.get(position).getMatchEnm();
                    if(MainActivity.isKorean) {
                        negative = "바로보기";
                        title = "출전선수 및 관련 뉴스";
                        message = tempArr.get(position).getMatchNm();
                    }
                    ad.setMessage("\n" + message + " - " + tempArr.get(position).getDetail());
                    ad.setTitle(title);
                    ad.setPositiveButton("close", null);
                    ad.setNegativeButton(negative, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                            context.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://sports.news.naver.com/index.nhn")));

                        }
                    });
                    ad.show();

                }
            });
        }

    }

    @Override
    public int getItemCount() {
        return tempArr.size(); // 수정할 부분
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        public ImageView iv_picto;
        public TextView tv_match_nm;
        public ImageView iv_status;
        public LinearLayout ll_card_main;
        public ImageView iv_medal;
        public TextView tv_match_stadium;
        public TextView tv_match_time;
        public LinearLayout ll_frame;

        public ViewHolder(View itemView){
            super(itemView);

            iv_picto = (ImageView) itemView.findViewById(R.id.iv_picto);
            tv_match_nm = (TextView) itemView.findViewById(R.id.tv_match_nm);
            iv_status = (ImageView) itemView.findViewById(R.id.iv_status);
            ll_card_main = (LinearLayout) itemView.findViewById(R.id.ll_card_main);
            iv_medal = (ImageView) itemView.findViewById(R.id.iv_medal);
            tv_match_stadium = (TextView) itemView.findViewById(R.id.tv_match_stadium);
            tv_match_time = (TextView) itemView.findViewById(R.id.tv_match_time);
            ll_frame = (LinearLayout) itemView.findViewById(R.id.ll_frame);

        }


    }

}
