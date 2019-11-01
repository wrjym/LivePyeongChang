package com.livepyeongchang.a12three.livepyeongchang.Controller;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.livepyeongchang.a12three.livepyeongchang.Model.Model_Tour;
import com.livepyeongchang.a12three.livepyeongchang.R;
import com.livepyeongchang.a12three.livepyeongchang.View.BaseActivity;
import com.livepyeongchang.a12three.livepyeongchang.View.Tour_Detail_Activity;
import com.squareup.picasso.Picasso;

import java.util.List;

import static com.livepyeongchang.a12three.livepyeongchang.View.BaseActivity.picArr;

/**
 * Created by kwakgee on 2017. 9. 7..
 */

public class Adapter_Tour extends RecyclerView.Adapter<Adapter_Tour.ViewHolder>{

    List<Model_Tour> tempArr;
    Context context;
    Intent in;

    public Adapter_Tour(List<Model_Tour> tempArr, Context context) {
        this.tempArr = tempArr;
        this.context = context;
    }

    public List<Model_Tour> getTempArr() {
        return tempArr;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_tour, parent, false));
    }

    @Override
    public void onBindViewHolder(Adapter_Tour.ViewHolder holder, final int position) {

        for(int i=0; i< BaseActivity.picArr.size(); i++){
            if(tempArr.get(position).getName().equals(BaseActivity.picArr.get(i).getName())){

                Picasso.with(context).load(BaseActivity.picArr.get(i).getUrl()).into(holder.iv_tour_main);

            }
        }

        holder.tv_tour_SUBJECT.setText(tempArr.get(position).getName());
        if(tempArr.get(position).getAdmission().equals("없음") || tempArr.get(position).getAdmission().equals("무료") || tempArr.get(position).getAdmission().equals("Free")){
            holder.iv_fee_icon.setImageResource(R.drawable.nofee);
        }else{
            holder.iv_fee_icon.setImageResource(R.drawable.fee);
        }

        if(!tempArr.get(position).getParking().equals("없음") || !tempArr.get(position).getParking().equals("None")){
            holder.iv_parking_icon.setImageResource(R.drawable.park);
        }else{
            holder.iv_parking_icon.setImageResource(R.drawable.nopark);
        }

        holder.ll_tour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                in = new Intent(context, Tour_Detail_Activity.class);
                in.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                in.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                in.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);

                in.putExtra("kind", tempArr.get(position).getKind());
                in.putExtra("area", tempArr.get(position).getArea());
                in.putExtra("name", tempArr.get(position).getName());
                in.putExtra("summary", tempArr.get(position).getSummary());
                in.putExtra("address", tempArr.get(position).getAddress());
                in.putExtra("lat", tempArr.get(position).getLat());
                in.putExtra("lng", tempArr.get(position).getLng());
                in.putExtra("contact", tempArr.get(position).getContact());
                in.putExtra("homepage", tempArr.get(position).getHomepage());
                in.putExtra("tips", tempArr.get(position).getTips());
                in.putExtra("holiday", tempArr.get(position).getHoliday());
                in.putExtra("time", tempArr.get(position).getTime());
                in.putExtra("admission", tempArr.get(position).getAdmission());
                in.putExtra("parking", tempArr.get(position).getParking());
                in.putExtra("content", tempArr.get(position).getContent());

                context.startActivity(in);

            }
        });

    }

    @Override
    public int getItemCount() {
        return tempArr.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        public ImageView iv_tour_main;
        public TextView tv_tour_SUBJECT;
        public ImageView iv_fee_icon;
        public ImageView iv_parking_icon;
        public LinearLayout ll_tour;

        public ViewHolder(View itemView) {
            super(itemView);

            iv_tour_main = (ImageView) itemView.findViewById(R.id.iv_tour_main);
            tv_tour_SUBJECT = (TextView) itemView.findViewById(R.id.tv_tour_SUBJECT);
            iv_fee_icon = (ImageView) itemView.findViewById(R.id.iv_fee_icon);
            iv_parking_icon = (ImageView) itemView.findViewById(R.id.iv_parking_icon);
            ll_tour = (LinearLayout) itemView.findViewById(R.id.ll_tour);

        }
    }

}
