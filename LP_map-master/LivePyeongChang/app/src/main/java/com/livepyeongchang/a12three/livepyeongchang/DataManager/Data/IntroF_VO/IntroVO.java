package com.livepyeongchang.a12three.livepyeongchang.DataManager.Data.IntroF_VO;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by kwakgee on 2017. 9. 6..
 */

public class IntroVO {

    @SerializedName("list")
    @Expose
    private List<ListVO> listVO;

    public List<ListVO> getItems()
    {
        return listVO;
    }
    public void setItems (List<ListVO> items){
        this.listVO = items;
    }

}
