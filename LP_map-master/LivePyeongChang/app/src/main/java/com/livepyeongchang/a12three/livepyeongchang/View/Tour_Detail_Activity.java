package com.livepyeongchang.a12three.livepyeongchang.View;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.livepyeongchang.a12three.livepyeongchang.R;
import com.squareup.picasso.Picasso;

public class Tour_Detail_Activity extends AppCompatActivity implements OnMapReadyCallback{

    ImageView iv_main;

    TextView tv_title;
    TextView tv_address;
    TextView tv_time;
    TextView tv_admission;
    TextView tv_parking;
    TextView tv_holiday;
    TextView tv_content;

    Button btn_tip;
    Button btn_call;
    Button btn_homepage;

    GoogleMap gMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tour_detail_activity);

        iv_main = (ImageView) findViewById(R.id.iv_main) ;
        for(int i=0; i< BaseActivity.picArr.size(); i++){
            if(getIntent().getStringExtra("name").equals(BaseActivity.picArr.get(i).getName())){

                Picasso.with(getApplicationContext()).load(BaseActivity.picArr.get(i).getUrl()).into(iv_main);

            }
        }

        tv_title = (TextView) findViewById(R.id.tv_title);
        tv_title.setText("[" + getIntent().getStringExtra("area") + "] " + getIntent().getStringExtra("name"));

        tv_address = (TextView) findViewById(R.id.tv_address);
        tv_address.setText(getIntent().getStringExtra("address"));

        tv_time = (TextView) findViewById(R.id.tv_time);
        tv_time.setText(getIntent().getStringExtra("time"));

        tv_admission = (TextView) findViewById(R.id.tv_admission);
        tv_admission.setText(getIntent().getStringExtra("admission"));

        tv_parking = (TextView) findViewById(R.id.tv_parking);
        tv_parking.setText(getIntent().getStringExtra("parking"));

        tv_holiday = (TextView) findViewById(R.id.tv_holiday);
        tv_holiday.setText(getIntent().getStringExtra("holiday"));

        tv_content = (TextView) findViewById(R.id.tv_content);
        tv_content.setText("  " + getIntent().getStringExtra("content"));

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        btn_tip = (Button) findViewById(R.id.btn_tip);
        btn_tip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder ad = new AlertDialog.Builder(Tour_Detail_Activity.this);
                ad.setIcon(android.R.drawable.ic_menu_info_details);
                ad.setTitle("tips");
                ad.setMessage(getIntent().getStringExtra("tips"));
                ad.setPositiveButton("close", null);
                ad.show();
            }
        });

        final String contact = getIntent().getStringExtra("contact");
        btn_call = (Button) findViewById(R.id.btn_call);
        btn_call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(contact.equals("없음")){
                    AlertDialog.Builder ad = new AlertDialog.Builder(Tour_Detail_Activity.this);
                    ad.setIcon(android.R.drawable.ic_menu_call);
                        ad.setMessage("등록된 전화번호가 없습니다.");
                    ad.setPositiveButton("close", null);
                    ad.show();
                } else {
                    AlertDialog.Builder ad = new AlertDialog.Builder(Tour_Detail_Activity.this);
                    ad.setIcon(android.R.drawable.ic_menu_call);
                    ad.setTitle("Would like to make phone call?");
                    if(MainActivity.isKorean) {
                        ad.setTitle("전화 하시겠습니까?");
                    }
                    ad.setMessage(contact);
                    ad.setPositiveButton("close", null);
                    ad.setNegativeButton("Call", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("tel:" + contact)));

                        }
                    });
                    ad.show();
                }
            }
        });

        final String homepage = getIntent().getStringExtra("homepage");
        btn_homepage = (Button) findViewById(R.id.btn_homepage);
        btn_homepage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(homepage.equals("없음") || homepage.equals("None")){
                    AlertDialog.Builder ad = new AlertDialog.Builder(Tour_Detail_Activity.this);
                    ad.setIcon(android.R.drawable.ic_menu_call);
                    ad.setMessage("Sorry, no such page.");
                    if(MainActivity.isKorean) {
                        ad.setMessage("등록된 홈페이지가 없습니다.");
                    }
                    ad.setPositiveButton("close", null);
                    ad.show();
                } else {
                    AlertDialog.Builder ad = new AlertDialog.Builder(Tour_Detail_Activity.this);
                    ad.setTitle("Would like to visit their homepage?");
                    if(MainActivity.isKorean) {
                        ad.setTitle("홈페이지로 이동하시겠습니까?");
                    }
                    ad.setMessage(homepage);
                    ad.setPositiveButton("close", null);
                    ad.setNegativeButton("Visit", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(homepage)));

                        }
                    });
                    ad.show();
                }
            }
        });

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        gMap = googleMap;
        double lat = Double.parseDouble(getIntent().getStringExtra("lat"));
        double lng = Double.parseDouble(getIntent().getStringExtra("lng"));

        LatLng location = new LatLng(lat, lng);
        gMap.addMarker(new MarkerOptions().position(location));
        gMap.moveCamera(CameraUpdateFactory.newLatLngZoom(location, 16));
    }
}
