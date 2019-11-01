package com.livepyeongchang.a12three.livepyeongchang.DataManager.Data.IntroF_VO;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by kwakgee on 2017. 9. 6..
 */

public class ListVO {

    @SerializedName("nm")
    @Expose
    private int index;

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    @SerializedName("game")
    @Expose

    private String game;
    @SerializedName("rink")
    @Expose
    private String rink;
    @SerializedName("Demo")
    @Expose
    private String demoVideo;
    @SerializedName("summary")
    @Expose
    private String summary;
    @SerializedName("stadium")
    @Expose
    private String stadium;

    @SerializedName("Egame")
    @Expose
    private String egame;

    //영어 버전 추가로 인한 변수 추가
    @SerializedName("esummary")

    @Expose
    private String esummary;

    @SerializedName("estadium")
    @Expose
    private String estadium;


    public String getEsummary() {
        return esummary;
    }

    public void setEsummary(String esummary) {
        this.esummary = esummary;
    }

    public String getEstadium() {
        return estadium;
    }

    public void setEstadium(String estadium) {
        this.estadium = estadium;
    }
    //요까지

    public String getEgame() {
        return egame;
    }

    public void setEgame(String egame) {
        this.egame = egame;
    }

    public String getGame() {
        return game;
    }

    public void setGame(String game) {
        this.game = game;
    }

    public String getRink() {
        return rink;
    }

    public void setRink(String rink) {
        this.rink = rink;
    }

    public String getDemoVideo() {
        return demoVideo;
    }

    public void setDemoVideo(String demoVideo) {
        this.demoVideo = demoVideo;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getStadium() {
        return stadium;
    }

    public void setStadium(String stadium) {
        this.stadium = stadium;
    }

}
