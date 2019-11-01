package com.livepyeongchang.a12three.livepyeongchang.DataManager.Data.ReplyVO;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by yongmac on 2017. 9. 16..
 */

public class ReplyVO {

    @SerializedName("list")
    @Expose
    private List<ReplyListVO> listArr;

    public List<ReplyListVO> getListArr() {
        return listArr;
    }
}
