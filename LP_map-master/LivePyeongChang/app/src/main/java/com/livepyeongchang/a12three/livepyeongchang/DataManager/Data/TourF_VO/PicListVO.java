package com.livepyeongchang.a12three.livepyeongchang.DataManager.Data.TourF_VO;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by kwakgee on 2017. 9. 21..
 */

public class PicListVO {

    @SerializedName("tourname")
    @Expose
    private String tourName;

    @SerializedName("toururl")
    @Expose
    private String tourUrl;

    public String getTourName() {
        return tourName;
    }

    public String getTourUrl() {
        return tourUrl;
    }
}
