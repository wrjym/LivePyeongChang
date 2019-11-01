package com.livepyeongchang.a12three.livepyeongchang.DataManager.Data.MainF_VO;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by kwakgee on 2017. 9. 10..
 */

public class ScheVO {

    @SerializedName("game")
    @Expose
    private String game;
    @SerializedName("Egame")
    @Expose
    private String egame;
    @SerializedName("dgame")
    @Expose
    private String dgame;
    @SerializedName("edgame")
    @Expose
    private String edgame;
    @SerializedName("day")
    @Expose
    private String day;
    @SerializedName("time")
    @Expose
    private String time;
    @SerializedName("stadium")
    @Expose
    private String stadium;
    @SerializedName("Estadium")
    @Expose
    private String estadium;
    @SerializedName("sex")
    @Expose
    private String sex;
    @SerializedName("medal")
    @Expose
    private int medal;

    public String getGame() {
        return game;
    }

    public String getEgame() {
        return egame;
    }

    public String getDgame() {
        return dgame;
    }

    public String getEdgame() {
        return edgame;
    }

    public String getDay() {
        return day;
    }

    public String getTime() {
        return time;
    }

    public String getStadium() {
        return stadium;
    }

    public String getEstadium() {
        return estadium;
    }

    public String getSex() {
        return sex;
    }

    public int getMedal() {
        return medal;
    }
}
