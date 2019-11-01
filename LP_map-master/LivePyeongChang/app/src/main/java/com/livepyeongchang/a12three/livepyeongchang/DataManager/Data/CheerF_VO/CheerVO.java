package com.livepyeongchang.a12three.livepyeongchang.DataManager.Data.CheerF_VO;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by MG_PARK on 2017-09-06.
 */

public class CheerVO {

    @SerializedName("list")
    @Expose
    private List<PlayerVO> player = null;

    public List<PlayerVO> getItems() {
        return player;
    }

    public void setItems(List<PlayerVO> player) {
        this.player = player;
    }

}
