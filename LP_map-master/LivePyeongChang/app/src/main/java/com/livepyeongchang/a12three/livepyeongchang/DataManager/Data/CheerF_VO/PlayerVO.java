package com.livepyeongchang.a12three.livepyeongchang.DataManager.Data.CheerF_VO;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by MG_PARK on 2017-09-06.
 */

public class PlayerVO {

    @SerializedName("game")
    @Expose
    private String game;
    @SerializedName("player")
    @Expose
    private String player;
    @SerializedName("birth")
    @Expose
    private String birth;
    @SerializedName("sex")
    @Expose
    private String sex;
    @SerializedName("picture")
    @Expose
    private String picture;

    public String getEplayer() {
        return eplayer;
    }

    public void setEplayer(String eplayer) {
        this.eplayer = eplayer;
    }

    @SerializedName("eplayer")
    @Expose

    private String eplayer;

    public String getGame() {
        return game;
    }

    public void setGame(String game) {
        this.game = game;
    }

    public String getPlayer() {
        return player;
    }

    public void setPlayer(String player) {
        this.player = player;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
}
