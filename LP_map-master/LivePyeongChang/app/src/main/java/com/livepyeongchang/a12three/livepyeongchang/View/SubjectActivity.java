package com.livepyeongchang.a12three.livepyeongchang.View;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;
import com.livepyeongchang.a12three.livepyeongchang.DataManager.CheerF_DataManager;
import com.livepyeongchang.a12three.livepyeongchang.R;

public class SubjectActivity extends YouTubeBaseActivity {

    public TextView txt_title;
    public TextView txt_stadium;
    public TextView txt_summary;

    public TextView tv_btn_link;
    public TextView tv_btn_more;
    public TextView tv_btn_smaller;

    private String demo;
    private String link;
    private String stadium;
    private String game;
    private String summary;

    YouTubePlayerView view_youtube;
    YouTubePlayer.OnInitializedListener listener;
    private String videoName;

    public static RecyclerView recyclerFace;
    private LinearLayoutManager reLayoutManager;
    private CheerF_DataManager cheer;

    public void setName(String name){

        videoName=name;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject);

        view_youtube=(YouTubePlayerView) findViewById(R.id.view_youtube);

        txt_title=(TextView)findViewById(R.id.txt_title);
        txt_stadium=(TextView)findViewById(R.id.txt_stadium);
        txt_summary=(TextView)findViewById(R.id.txt_summary);

        tv_btn_link=(TextView) findViewById(R.id.tv_btn_link);

        recyclerFace=(RecyclerView)findViewById(R.id.recycler_face);
        recyclerFace.setHasFixedSize(true);
        reLayoutManager=new LinearLayoutManager(this);
        reLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerFace.setLayoutManager(reLayoutManager);

        cheer=new CheerF_DataManager();

        Intent intent=getIntent();

        link=intent.getStringExtra("rink");
        demo=intent.getStringExtra("demo");
        stadium=intent.getStringExtra("stadium");
        game=intent.getStringExtra("game");
        summary=intent.getStringExtra("summary");

        cheer.loadData(game, 2);

        txt_title.setText(game);
        txt_stadium.setText(stadium);
        txt_summary.setText(summary);

        tv_btn_link.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(link)));

            }

        });

        tv_btn_more=(TextView) findViewById(R.id.tv_btn_more);
        tv_btn_smaller=(TextView) findViewById(R.id.tv_btn_smaller);

        tv_btn_more.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){
                txt_summary.setLines(9);
                txt_summary.setEllipsize(TextUtils.TruncateAt.MARQUEE);
                tv_btn_more.setVisibility(View.INVISIBLE);
                tv_btn_smaller.setVisibility(View.VISIBLE);

            }
        });

        tv_btn_smaller.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){
                txt_summary.setLines(3);
                txt_summary.setEllipsize(TextUtils.TruncateAt.END);
                tv_btn_more.setVisibility(View.VISIBLE);
                tv_btn_smaller.setVisibility(View.INVISIBLE);

            }
        });


        listener= new YouTubePlayer.OnInitializedListener(){

            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                youTubePlayer.loadVideo(demo);
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

            }
        };

        view_youtube.initialize("AIzaSyCM3O1SoR31p1ms5mhLZVxRbzehLMZKLq8",listener);

    }
}
