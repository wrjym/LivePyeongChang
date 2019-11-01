package com.livepyeongchang.a12three.livepyeongchang.Controller;

import com.livepyeongchang.a12three.livepyeongchang.View.MainActivity;

import java.util.Calendar;

/**
 * Created by kwakgee on 2017. 9. 5..
 */

public class TimeManager {

    public String addDate(int day, boolean isAdapter){
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, day);

        String currentDate = String.valueOf((cal.get(Calendar.MONTH)+1)) + "/"
                + String.valueOf(cal.get(Calendar.DATE));

        if(MainActivity.isKorean){
        currentDate = String.valueOf((cal.get(Calendar.MONTH)+1)) + "월 "
                + String.valueOf(cal.get(Calendar.DATE)) + "일";
        }
        String currentDateValue = String.valueOf(cal.get(Calendar.DATE));

        if(!isAdapter){
            return currentDate;
        }else{
            return currentDateValue;
        }
    }

}
