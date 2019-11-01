package com.livepyeongchang.a12three.livepyeongchang.Model;

/**
 * Created by kwakgee on 2017. 9. 7..
 */

public class Model_Tour {

    private String kind;
    private String area;
    private String name;
    private String summary;
    private String address;
    private String lat;
    private String lng;
    private String contact;
    private String homepage;
    private String tips;
    private String holiday;
    private String time;
    private String admission;
    private String parking;
    private String content;

    public Model_Tour(String kind, String area, String name, String summary, String address,
                      String lat, String lng, String contact, String homepage, String tips,
                      String holiday, String time, String admission, String parking, String content) {
        this.kind = kind;
        this.area = area;
        this.name = name;
        this.summary = summary;
        this.address = address;
        this.lat = lat;
        this.lng = lng;
        this.contact = contact;
        this.homepage = homepage;
        this.tips = tips;
        this.holiday = holiday;
        this.time = time;
        this.admission = admission;
        this.parking = parking;
        this.content = content;
    }

    public String getKind() {
        return kind;
    }

    public String getArea() {
        return area;
    }

    public String getName() {
        return name;
    }

    public String getSummary() {
        return summary;
    }

    public String getAddress() {
        return address;
    }

    public String getLat() {
        return lat;
    }

    public String getLng() {
        return lng;
    }

    public String getContact() {
        return contact;
    }

    public String getHomepage() {
        return homepage;
    }

    public String getTips() {
        return tips;
    }

    public String getHoliday() {
        return holiday;
    }

    public String getTime() {
        return time;
    }

    public String getAdmission() {
        return admission;
    }

    public String getParking() {
        return parking;
    }

    public String getContent() {
        return content;
    }
}
