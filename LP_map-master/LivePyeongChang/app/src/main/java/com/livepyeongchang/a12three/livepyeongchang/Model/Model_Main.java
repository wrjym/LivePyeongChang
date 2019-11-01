package com.livepyeongchang.a12three.livepyeongchang.Model;

/**
 * Created by kwakgee on 2017. 9. 5..
 */

public class Model_Main {

    private String matchNm;
    private String matchEnm;
    /* 한/영 버젼 구현 */
    private String detail;
    private String stadium;
    private String edetail;
    private String estadium;
    /* 한/영 버젼 구현 */
    private String sex;
    private String date;
    private String time;
    private boolean Medal;

    public Model_Main(String matchNm, String matchEnm, String detail, String edetail, String stadium, String estadium, String sex, String date, String time, boolean Medal) {
        this.matchNm = matchNm;
        this.matchEnm = matchEnm;
        this.detail= detail;
        this.edetail = edetail;
        this.stadium = stadium;
        this.estadium = estadium;
        this.sex = sex;
        this.date = date;
        this.time = time;
        this.Medal = Medal;
    }

    public String getMatchNm() {
        return matchNm;
    }

    public String getMatchEnm() {
        return matchEnm;
    }

    public String getDetail() {
        return detail;
    }

    public String getEdetail() {
        return edetail;
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

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public boolean isMedal() {
        return Medal;
    }
}
