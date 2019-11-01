package com.livepyeongchang.a12three.livepyeongchang.View;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.livepyeongchang.a12three.livepyeongchang.Controller.Constants;
import com.livepyeongchang.a12three.livepyeongchang.DataManager.RankF_DataManager;
import com.livepyeongchang.a12three.livepyeongchang.R;
import com.livepyeongchang.a12three.livepyeongchang.View.Fragment.FragmentCheer;
import com.livepyeongchang.a12three.livepyeongchang.View.Fragment.FragmentIntroduce;
import com.livepyeongchang.a12three.livepyeongchang.View.Fragment.FragmentMain;
import com.livepyeongchang.a12three.livepyeongchang.View.Fragment.FragmentRank;
import com.livepyeongchang.a12three.livepyeongchang.View.Fragment.FragmentTour;

public class MainActivity extends AppCompatActivity {

    private SectionsPagerAdapter mSectionsPagerAdapter;

    private ViewPager mViewPager;

    private FragmentMain fragmentMain;
    private FragmentIntroduce fragmentIntroduce;
    private FragmentCheer fragmentCheer;
    private FragmentTour fragmentTour;
    private FragmentRank fragmentRank;

    private RankF_DataManager dataManager;

    public static boolean isKorean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        isKorean = getIntent().getBooleanExtra("isKorean", false);

//        fragmentMain = new FragmentMain();
//        fragmentIntroduce = new FragmentIntroduce();
//        fragmentCheer = new FragmentCheer();
//        fragmentTour = new FragmentTour();
//        fragmentRank = new FragmentRank();

        dataManager=new RankF_DataManager();

        dataManager.loadData();

        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

    }

    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {

            switch (position) {
                case 0:
                    return FragmentMain.newInstance();
                case 1:
                    return FragmentIntroduce.newInstance();
                case 2:
                    return FragmentCheer.newInstance();
                case 3:
                    return FragmentRank.newInstance();
                case 4:
                    return FragmentTour.newInstance();
                default:
                    return FragmentMain.newInstance();

            }
        }

        @Override
        public int getCount() {
            return Constants.MENU_COUNT;
        }

        @Override
        public CharSequence getPageTitle(int position){

            String[] tabs = new String[5];

            if(isKorean){
                tabs[0] = "LIVE";
                tabs[1] = "종목소개";
                tabs[2] = "응원하기";
                tabs[3] = "순위보기";
                tabs[4] = "여행하기";
            }else{
                tabs[0] = "LIVE";
                tabs[1] = "SPORTS";
                tabs[2] = "CHEER";
                tabs[3] = "RANKING";
                tabs[4] = "TOUR";
            }

            switch (position) {
                case 0:
                    return tabs[0];
                case 1:
                    return tabs[1];
                case 2:
                    return tabs[2];
                case 3:
                    return tabs[3];
                case 4:
                    return tabs[4];
            }
            return null;
        }
    }
}
