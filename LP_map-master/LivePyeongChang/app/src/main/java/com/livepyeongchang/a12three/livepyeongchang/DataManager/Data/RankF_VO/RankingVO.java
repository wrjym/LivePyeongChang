package com.livepyeongchang.a12three.livepyeongchang.DataManager.Data.RankF_VO;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by MG_PARK on 2017-09-16.
 */

public class RankingVO {

    @SerializedName("master")
    @Expose
    private String master;
    @SerializedName("list")
    @Expose
    private List<CountryVO> list = null;

    public String getMaster() {
        return master;
    }

    public void setMaster(String master) {
        this.master = master;
    }

    public List<CountryVO> getItems() {
        return list;
    }

    public void setItems(List<CountryVO> list) {
        this.list = list;
    }
}
