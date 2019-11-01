package com.livepyeongchang.a12three.livepyeongchang.Controller;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.livepyeongchang.a12three.livepyeongchang.Model.Model_Reply;
import com.livepyeongchang.a12three.livepyeongchang.R;

import java.util.List;

/**
 * Created by yongmac on 2017. 9. 20..
 */

public class Adapter_Reply extends RecyclerView.Adapter<Adapter_Reply.ViewHolder> {

    private List<Model_Reply> tempArr;

    public Adapter_Reply(List<Model_Reply> tempArr) {
        this.tempArr = tempArr;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_reply, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.tv_reply_comment.setText(tempArr.get(position).getContent());

        if((position % 2) == 1){
            holder.ll_reply.setBackgroundResource(R.color.colorLeft);
        }else {
            holder.ll_reply.setBackgroundResource(R.color.colorBase);
        }
    }

    @Override
    public int getItemCount() {
        return tempArr.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private CardView cv_reply;
        private TextView tv_reply_comment;
        private LinearLayout ll_reply;

        public ViewHolder(View itemView) {
            super(itemView);

            cv_reply = (CardView) itemView.findViewById(R.id.cv_reply);
            tv_reply_comment = (TextView) itemView.findViewById(R.id.tv_reply_comment);
            ll_reply = (LinearLayout) itemView.findViewById(R.id.ll_reply);

        }
    }

}
