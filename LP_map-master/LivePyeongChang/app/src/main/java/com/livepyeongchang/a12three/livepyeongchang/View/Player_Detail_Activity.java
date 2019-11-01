package com.livepyeongchang.a12three.livepyeongchang.View;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.livepyeongchang.a12three.livepyeongchang.Controller.Adapter_Reply;
import com.livepyeongchang.a12three.livepyeongchang.DataManager.Data.ReplyVO.ReplyVO_Post;
import com.livepyeongchang.a12three.livepyeongchang.DataManager.Remote.RetrofitService;
import com.livepyeongchang.a12three.livepyeongchang.DataManager.Reply_DataManager;
import com.livepyeongchang.a12three.livepyeongchang.Model.Model_Reply;
import com.livepyeongchang.a12three.livepyeongchang.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class Player_Detail_Activity extends AppCompatActivity {

    Retrofit retrofit;
    RetrofitService retrofitService;
    EditText et_comment;
    Button bt_ok;

    public static List<Model_Reply> replyArr;

    RecyclerView rv_reply;
    LinearLayoutManager manager;
    Adapter_Reply adapterReply;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_detail);

        replyArr = new ArrayList<>();

        Intent intent = getIntent();
        CardView cardView = (CardView) findViewById(R.id.card_view);
        final TextView name = (TextView) findViewById(R.id.txt_name);
        ImageView player_bg = (ImageView) findViewById(R.id.cover_bg_details);
        TextView game = (TextView) findViewById(R.id.txt_game);
        TextView birth = (TextView) findViewById(R.id.txt_birth);
        ImageView img_sex = (ImageView) findViewById(R.id.img_sex);
        String sex;

        bt_ok = (Button)findViewById(R.id.bt_ok);
        et_comment = (EditText) findViewById(R.id.et_comment);

        Picasso.with(this).load(intent.getStringExtra("picture")).into(player_bg);

        final String nameKey = intent.getStringExtra("nameKey");
        final Reply_DataManager reply_dataManager = new Reply_DataManager();
        reply_dataManager.loadData(nameKey);

        name.setText(intent.getStringExtra("name"));
        game.setText(intent.getStringExtra("game"));
        birth.setText(intent.getStringExtra("birth"));
        sex = intent.getStringExtra("sex");

        if (sex.equals("남")) {
            Picasso.with(this).load(R.drawable.soohorang).into(img_sex);
        } else if (sex.equals("여")) {
            Picasso.with(this).load(R.drawable.bandabi).into(img_sex);
            Picasso.with(this).load(R.drawable.bandabi).into(img_sex);
        }

        rv_reply = (RecyclerView) findViewById(R.id.rv_reply);
        manager = new LinearLayoutManager(getApplicationContext());
        adapterReply = new Adapter_Reply(replyArr);

        rv_reply.setLayoutManager(manager);
        rv_reply.setAdapter(adapterReply);

        final InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);

        bt_ok.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View view) {
                String temp = et_comment.getText().toString();
                imm.hideSoftInputFromWindow(et_comment.getWindowToken(), 0);

                if (temp.equals("")) {
                    String message = "Enter the supporting message!";
                    if(MainActivity.isKorean) message = "응원글이 없습니다!";
                    Toast.makeText(Player_Detail_Activity.this, message, Toast.LENGTH_SHORT).show();
                } else {
                    retrofitService = (RetrofitService) RetrofitService.retrofit_replys.create(RetrofitService.class);
                    Call<ReplyVO_Post> call = retrofitService.getComment(temp, nameKey);
                    call.enqueue(new Callback<ReplyVO_Post>() {
                        @Override
                        public void onResponse(Call<ReplyVO_Post> call, Response<ReplyVO_Post> response) {
                        }

                        @Override
                        public void onFailure(Call<ReplyVO_Post> call, Throwable t) {
                        }
                    });
                    String message = "You cheer " + getIntent().getStringExtra("name") + "!";
                    if (MainActivity.isKorean) message = getIntent().getStringExtra("name") + " 선수를 응원하셨습니다!";
                    Toast.makeText(Player_Detail_Activity.this, message, Toast.LENGTH_SHORT).show();
                    et_comment.setText("");
                    replyArr.add(new Model_Reply(temp));
                    adapterReply = new Adapter_Reply(replyArr);
                    rv_reply.setAdapter(adapterReply);
                    adapterReply.notifyDataSetChanged();
                }
            }
        });
    }
}
