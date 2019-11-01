package com.livepyeongchang.a12three.livepyeongchang.DataManager.Data.ReplyVO;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by yongmac on 2017. 9. 20..
 */

public class ReplyListVO {

    @SerializedName("comment")
    @Expose
    private String comment;

    @SerializedName("player")
    @Expose
    private String player;

    public String getComment() {
        return comment;
    }

    public String getPlayer() {
        return player;
    }
}
