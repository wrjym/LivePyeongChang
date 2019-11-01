package com.livepyeongchang.a12three.livepyeongchang.DataManager.Data.RankF_VO;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by MG_PARK on 2017-09-16.
 */

public class CountryVO {

    private int score;

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    private int rank;

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    @SerializedName("country")
    @Expose
    private String country;
    @SerializedName("ecountry")
    @Expose
    private String ecountry;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("gold")
    @Expose
    private Integer gold;
    @SerializedName("silver")
    @Expose
    private Integer silver;
    @SerializedName("bronze")
    @Expose
    private Integer bronze;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getEcountry() {
        return ecountry;
    }

    public void setEcountry(String ecountry) {
        this.ecountry = ecountry;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getGold() {
        return gold;
    }

    public void setGold(Integer gold) {
        this.gold = gold;
    }

    public Integer getSilver() {
        return silver;
    }

    @Override
    public String toString() {
        return "CountryVO{" +
                "rank=" + rank +
                ", country='" + country + '\'' +
                ", ecountry='" + ecountry + '\'' +
                ", url='" + url + '\'' +
                ", gold=" + gold +
                ", silver=" + silver +
                ", bronze=" + bronze +
                '}';
    }

    public void setSilver(Integer silver) {
        this.silver = silver;
    }

    public Integer getBronze() {
        return bronze;
    }

    public void setBronze(Integer bronze) {
        this.bronze = bronze;
    }
}
