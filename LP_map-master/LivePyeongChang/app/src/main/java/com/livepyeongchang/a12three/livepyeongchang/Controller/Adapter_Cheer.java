package com.livepyeongchang.a12three.livepyeongchang.Controller;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.livepyeongchang.a12three.livepyeongchang.DataManager.Data.CheerF_VO.PlayerVO;
import com.livepyeongchang.a12three.livepyeongchang.DataManager.IntroF_DataManager;
import com.livepyeongchang.a12three.livepyeongchang.R;
import com.livepyeongchang.a12three.livepyeongchang.View.MainActivity;
import com.livepyeongchang.a12three.livepyeongchang.View.Player_Detail_Activity;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by MG_PARK on 2017-09-06.
 */

public class Adapter_Cheer  extends RecyclerView.Adapter<Adapter_Cheer.ViewHolder> {
    private List<PlayerVO> mDataset;
    public Context context;
    private ItemClick itemClick;

    public ViewGroup vg;

    public interface ItemClick {

        public void onClick(View view, int position);

    }

    public void setItemClick(ItemClick itemClick) {
        this.itemClick = itemClick;
    }

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public ImageView img_player;
        public TextView txt_name;
        public CardView cv;
        View view;


        public ViewHolder(View view) {
            super(view);
            img_player = (ImageView) view.findViewById(R.id.img_player);
            txt_name = (TextView) view.findViewById(R.id.txt_name);
            cv = (CardView) view.findViewById(R.id.cardview);
            this.view = view;
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public Adapter_Cheer(List<PlayerVO> myDataset) {
        mDataset = myDataset;
        context = null;
        notifyDataSetChanged();
    }

    // Create new views (invoked by the layout manager)
    @Override
    public Adapter_Cheer.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                       int viewType) {

        context = parent.getContext();
        vg = parent;
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_player, parent, false);
        // set the view's size, margins, paddings and layout parameters
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        final int Position = position;
        final ViewHolder Holder = holder;

        // - get element from your dataset at this position
        // - replace the contents of the view with that element

        if (MainActivity.isKorean) {
            holder.txt_name.setText(mDataset.get(position).getPlayer());
        } else {
            holder.txt_name.setText(mDataset.get(position).getEplayer());

        }

        if (mDataset.get(position).getPicture() != null) {
            Picasso.with(context)
                    .load(mDataset.get(position).getPicture())
                    .into(holder.img_player);

        }

        holder.cv.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent in = new Intent(context, Player_Detail_Activity.class);

                /*선수 댓글 창의 한영 버전 구현*/

                if (MainActivity.isKorean) {
                    in.putExtra("name", mDataset.get(Position).getPlayer());
                    in.putExtra("game", mDataset.get(Position).getGame());
                } else {
                    in.putExtra("name", mDataset.get(Position).getEplayer());
                    for (int i = 0; i < IntroF_DataManager.listVO.size(); i++) {
                        if (mDataset.get(Position).getGame().equals(IntroF_DataManager.listVO.get(i).getGame()))
                            in.putExtra("game", IntroF_DataManager.listVO.get(i).getEgame());
                    }
                }

                in.putExtra("nameKey", mDataset.get(position).getEplayer());

                in.putExtra("picture", mDataset.get(Position).getPicture());

                in.putExtra("birth", mDataset.get(Position).getBirth());
                in.putExtra("sex", mDataset.get(Position).getSex());

                ActivityOptionsCompat activityOptions = ActivityOptionsCompat.makeSceneTransitionAnimation(
                        (Activity) context,
                        // Now we provide a list of Pair items which contain the view we can transitioning
                        // from, and the name of the view it is transitioning to, in the launched activity
                        new Pair<View, String>(view.findViewById(R.id.img_player),
                                "player"));

                // Now we can start the Activity, providing the activity options as a bundle
                context.startActivity(in, activityOptions.toBundle());
                // END_INCLUDE(start_activity)


            }
        });


    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}