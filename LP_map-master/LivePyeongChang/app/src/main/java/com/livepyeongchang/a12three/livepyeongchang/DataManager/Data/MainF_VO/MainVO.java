package com.livepyeongchang.a12three.livepyeongchang.DataManager.Data.MainF_VO;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MainVO {

    @SerializedName("master")
    @Expose
    private String master;
    @SerializedName("list")
    @Expose
    private java.util.List<ScheVO> list;

    public String getMaster() {
        return master;
    }

    public List<ScheVO> getSchedule() {
        return list;
    }
}
