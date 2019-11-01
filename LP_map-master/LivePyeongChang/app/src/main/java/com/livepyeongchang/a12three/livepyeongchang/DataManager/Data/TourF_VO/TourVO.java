package com.livepyeongchang.a12three.livepyeongchang.DataManager.Data.TourF_VO;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by kwakgee on 2017. 9. 7..
 */

public class TourVO {

    @SerializedName("list_total_count")
    @Expose
    private String listTotalCount;
    @SerializedName("row")
    @Expose
    private List<RowVO> row;

    public String getListTotalCount() {
        return listTotalCount;
    }

    public void setListTotalCount(String listTotalCount) {
        this.listTotalCount = listTotalCount;
    }

    public List<RowVO> getRow() {
        return row;
    }

    public void setRow(List<RowVO> row) {
        this.row = row;
    }

}
