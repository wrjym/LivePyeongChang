package com.livepyeongchang.a12three.livepyeongchang.DataManager.Data.TourF_VO;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by kwakgee on 2017. 9. 21..
 */

public class PicVO {

    @SerializedName("list")
    @Expose
    private List<PicListVO> listArr;

    public List<PicListVO> getListArr() {
        return listArr;
    }
}
