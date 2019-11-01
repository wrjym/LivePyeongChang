package com.livepyeongchang.a12three.livepyeongchang.Controller;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.livepyeongchang.a12three.livepyeongchang.DataManager.Data.RankF_VO.CountryVO;
import com.livepyeongchang.a12three.livepyeongchang.R;
import com.livepyeongchang.a12three.livepyeongchang.View.MainActivity;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by MG_PARK on 2017-09-16.
 */

public class Adapter_Rank extends RecyclerView.Adapter<Adapter_Rank.ViewHolder>{

    private List<CountryVO> country;
    public Context context;

    public Adapter_Rank(List<CountryVO> list){
        country=list;
        context=null;
        notifyDataSetChanged();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case


        ImageView img_country;
        TextView txt_gold;
        TextView txt_silver;
        TextView txt_bronze;
        TextView txt_rank;
        TextView txt_country;

        public ViewHolder(View view) {
            super(view);

            img_country=(ImageView)view.findViewById(R.id.img_country);
            txt_gold=(TextView)view.findViewById(R.id.txt_gold);
            txt_silver=(TextView)view.findViewById(R.id.txt_silver);
            txt_bronze=(TextView)view.findViewById(R.id.txt_bronze);
            txt_rank=(TextView)view.findViewById(R.id.txt_rank);
            txt_country=(TextView)view.findViewById(R.id.txt_country);
        }
    }


    @Override
    public Adapter_Rank.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        context=parent.getContext();

        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_country,parent, false);
        // set the view's size, margins, paddings and layout parameters
        ViewHolder vh = new ViewHolder(v);


        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        if (country.get(position).getUrl() != null) {

            Picasso.with(context)
                    .load(country.get(position).getUrl())
                    .into(holder.img_country);
        }

        holder.txt_gold.setText(country.get(position).getGold() + "");
        holder.txt_silver.setText(country.get(position).getSilver() + "");
        holder.txt_bronze.setText(country.get(position).getBronze() + "");
        holder.txt_rank.setText(country.get(position).getRank() + "");
        if(MainActivity.isKorean) {
            holder.txt_country.setText(country.get(position).getCountry());
        }else{
            holder.txt_country.setText(country.get(position).getEcountry());

        }

    }

    @Override
    public int getItemCount() {
        return country.size();
    }

}
