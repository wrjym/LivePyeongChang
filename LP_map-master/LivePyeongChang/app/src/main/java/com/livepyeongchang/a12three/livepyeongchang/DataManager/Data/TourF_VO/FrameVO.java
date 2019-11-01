package com.livepyeongchang.a12three.livepyeongchang.DataManager.Data.TourF_VO;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by kwakgee on 2017. 9. 7..
 */

public class FrameVO {

    @SerializedName("tourdb-tourist_attraction-theme_park-kr")
    @Expose
    private TourVO tourVO_theme_kr;

    @SerializedName("tourdb-tourist_attraction-theme_park-us_en")
    @Expose
    private TourVO tourVO_theme_us;

    @SerializedName("tourdb-tourist_attraction-ruins-kr")
    @Expose
    private TourVO tourVO_ruins_kr;

    @SerializedName("tourdb-tourist_attraction-ruins-us_en")
    @Expose
    private TourVO tourVO_ruins_us;

    @SerializedName("tourdb-tourist_attraction-culture-kr")
    @Expose
    private TourVO tourVO_culture_kr;

    @SerializedName("tourdb-tourist_attraction-culture-us_en")
    @Expose
    private TourVO tourVO_culture_us;

    @SerializedName("tourdb-tourist_attraction-amusement_park-kr")
    @Expose
    private TourVO tourVO_amusement_kr;

    @SerializedName("tourdb-tourist_attraction-amusement_park-us_en")
    @Expose
    private TourVO tourVO_amusement_us;

    @SerializedName("tourdb-tourist_attraction-beach-kr")
    @Expose
    private TourVO tourVO_beach_kr;

    @SerializedName("tourdb-tourist_attraction-beach-us_en")
    @Expose
    private TourVO tourVO_beach_us;

    public TourVO getTourVO_theme_kr() {
        return tourVO_theme_kr;
    }

    public TourVO getTourVO_theme_us() {
        return tourVO_theme_us;
    }

    public TourVO getTourVO_ruins_kr() {
        return tourVO_ruins_kr;
    }

    public TourVO getTourVO_ruins_us() {
        return tourVO_ruins_us;
    }

    public TourVO getTourVO_culture_kr() {
        return tourVO_culture_kr;
    }

    public TourVO getTourVO_culture_us() {
        return tourVO_culture_us;
    }

    public TourVO getTourVO_amusement_kr() {
        return tourVO_amusement_kr;
    }

    public TourVO getTourVO_amusement_us() {
        return tourVO_amusement_us;
    }

    public TourVO getTourVO_beach_kr() {
        return tourVO_beach_kr;
    }

    public TourVO getTourVO_beach_us() {
        return tourVO_beach_us;
    }
}
